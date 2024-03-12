package com.nhattruongnguyen.config;

import com.cksource.ckfinder.servlet.CKFinderServlet;
import com.nhattruongnguyen.interceptor.MenuHandlerInterceptor;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Configuration
@EnableWebMvc
public class SpringWebConfig implements WebMvcConfigurer, ApplicationContextAware, ServletContextInitializer {
    private ApplicationContext applicationContext;
    @Autowired
    private MenuHandlerInterceptor menuHandlerInterceptor;

    public SpringWebConfig() {
        super();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(menuHandlerInterceptor);
    }

    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String publicFilesDir = String.format("file:%s/userfiles/", System.getProperty("user.dir"));
        registry.addResourceHandler("/resources/**", "/userfiles/**")
                .addResourceLocations("/resources/", "file:C:/Users/nhatt/Documents/Data/upload/")
        ;
    }

    /* **************************************************************** */
    /*  THYMELEAF-SPECIFIC ARTIFACTS                                    */
    /*  TemplateResolver <- TemplateEngine <- ViewResolver              */
    /* **************************************************************** */

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        // SpringResourceTemplateResolver automatically integrates with Spring's own
        // resource resolution infrastructure, which is highly recommended.
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // HTML is the default value, added here for the sake of clarity.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        // SpringTemplateEngine automatically applies SpringStandardDialect and
        // enables Spring's own MessageSource message resolution mechanisms.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect());
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        // Register the CKFinder's servlet.
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("ckfinder", new CKFinderServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/ckfinder/*");
        dispatcher.setInitParameter("scan-path", "com.nhattruongnguyen.ckfinder");

        FilterRegistration.Dynamic filter = servletContext.addFilter("x-content-options", new Filter() {
            @Override
            public void init(FilterConfig filterConfig) {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                ((HttpServletResponse) response).setHeader("X-Content-Type-Options", "nosniff");
                chain.doFilter(request, response);
            }

            @Override
            public void destroy() {
            }
        });

        filter.addMappingForUrlPatterns(null, false, "/userfiles/*");

        String tempDirectory;

        try {
            tempDirectory = Files.createTempDirectory("ckfinder").toString();
        } catch (IOException e) {
            tempDirectory = null;
        }

        dispatcher.setMultipartConfig(new MultipartConfigElement(tempDirectory));
    }

    @Controller
    static class FaviconController {
        @GetMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/web/img/favicon.ico";
        }

        @GetMapping("logo")
        String logo() {
            return "forward:/resources/web/img/logo-website.jpg";
        }
    }
}

