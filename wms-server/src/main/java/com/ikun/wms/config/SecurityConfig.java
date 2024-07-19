package com.ikun.wms.config;



import com.ikun.wms.config.Filter.TokenVerifyFilter;
import com.ikun.wms.config.Handler.MyAccessDeniedHandler;
import com.ikun.wms.config.Handler.MyAuthenticationFailureHandler;
import com.ikun.wms.config.Handler.MyAuthenticationSuccessHandler;
import com.ikun.wms.config.Handler.MyLogoutSuccessHandler;
import com.ikun.wms.utils.Constants;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Resource
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private MyLogoutSuccessHandler LogoutSuccessHandler;
    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    TokenVerifyFilter tokenVerifyFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,@Qualifier("cors") CorsConfigurationSource configurationSource) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests -> {
                    //配置请求权限
                    authorizeRequests
//                            .requestMatchers(Constants.LOGIN_URI)//登录请求
//                            .permitAll()//允许登录请求
                            .requestMatchers(Constants.CAPTCHA_URI)
                            .permitAll()
                            .requestMatchers(Constants.CAPTCHA_CHECK_URI)
                            .permitAll()
                            .anyRequest().authenticated();//其他请求都需要认证
                    // 所有请求都需要认证
                })
                .formLogin(formLogin -> {
                    //获取登录请求
                    formLogin.loginProcessingUrl(Constants.LOGIN_URI) //指定接受的uri
                            .usernameParameter("loginAct")//指定用户名参数
                            .passwordParameter("loginPwd")//指定密码参数
                            .successHandler(authenticationSuccessHandler) //登录成功
                            .failureHandler(authenticationFailureHandler);//登录失败
                })
                .csrf(csrf -> {
                    csrf.disable();
                })
                .cors(cors->{
                    cors.configurationSource(configurationSource);
                })
                .logout(logout -> {
                    logout.logoutUrl(Constants.LOGOUT_URI)
                            .logoutSuccessHandler(LogoutSuccessHandler);
                }).exceptionHandling(exceptionHandling -> {
                    exceptionHandling.authenticationEntryPoint(authenticationEntryPoint);
                    exceptionHandling.accessDeniedHandler(accessDeniedHandler);
                })
                .addFilterBefore(tokenVerifyFilter, LogoutFilter.class)
                .build();
    }

    @Bean("cors")
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource url = new UrlBasedCorsConfigurationSource();
        url.registerCorsConfiguration("/**",corsConfiguration);
        return url;
    }




}
