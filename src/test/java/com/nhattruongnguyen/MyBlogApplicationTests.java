package com.nhattruongnguyen;

import com.nhattruongnguyen.config.security.CustomizedUserDetails;
import com.nhattruongnguyen.config.security.CustomizedUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MyBlogApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomizedUserDetailsService customizedUserDetailsService;

    private CustomizedUserDetails adminUser() {
        return (CustomizedUserDetails) customizedUserDetailsService.loadUserByUsername("nhattruongnguyenag@gmail.com");
    }

    @Test
    public void givenLoginToSystemSuccessfully_whenMockMvc_thenReturnsPostAdminPage() throws Exception {
        this.mockMvc
                .perform(post("/authenticate").with(csrf())
                        .param("email", "nhattruongnguyenag@gmail.com")
                        .param("password", "1234567"))
                .andExpect(authenticated().withRoles("admin"))
                .andExpect(redirectedUrl("/admin/posts/publish"));
    }

    @Test
    public void givenLoginToSystemWithIncorrectEmail_whenMockMvc_thenReturnsLoginFailUrl() throws Exception {
        this.mockMvc
                .perform(post("/authenticate").with(csrf())
                        .param("email", "nhattruongnguyeng@gmail.com")
                        .param("password", "1234567"))
                .andExpect(redirectedUrl("/mb-login?error=true"));
    }

    @Test
    public void givenLoginToSystemWithIncorrectPassword_whenMockMvc_thenReturnsLoginFailUrl() throws Exception {
        this.mockMvc
                .perform(post("/authenticate").with(csrf())
                        .param("email", "nhattruongnguyenag@gmail.com")
                        .param("password", "111111111"))
                .andExpect(redirectedUrl("/mb-login?error=true"));
    }

    @Test
    public void givenLogoutFromSystem_whenMockMvc_thenReturnsLogoutSuccessfull() throws Exception {
        this.mockMvc
                .perform(post("/logout").with(csrf()))
                .andExpect(redirectedUrl("/mb-login?logout"));
    }


    @Test
    public void givenPostEditUri_whenMockMvc_thenReturnsPostEditPage() throws Exception {
        this.mockMvc.perform(get("/admin/post-edit")
                        .with(user(adminUser())))
                .andExpect(view().name("admin/post-edit"));
    }
}
