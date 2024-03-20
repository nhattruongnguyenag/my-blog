package com.nhattruongnguyen.interceptor;

import com.nhattruongnguyen.config.security.CustomizedUserDetails;
import com.nhattruongnguyen.config.security.SecurityContextUtils;
import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.dto.response.BlogInfoResponseDTO;
import com.nhattruongnguyen.service.BlogMetaService;
import com.nhattruongnguyen.service.CategoryService;
import com.nhattruongnguyen.utils.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BlogInterceptor implements HandlerInterceptor {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogMetaService blogMetaService;
    @Autowired
    private SecurityContextUtils securityContextUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("menu", categoryService.findAll());
        request.setAttribute("baseUrl", CommonUtils.getBaseUrl(request));
        request.setAttribute("currentUrl", request.getRequestURL().toString());

        CustomizedUserDetails userLogin = securityContextUtils.getUserLogin();

        if (userLogin != null) {
            request.setAttribute("userLogin", userLogin);
        }

        BlogInfoResponseDTO blogInfo = blogMetaService.getBlogInfo();
        request.setAttribute("blog", blogInfo);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
