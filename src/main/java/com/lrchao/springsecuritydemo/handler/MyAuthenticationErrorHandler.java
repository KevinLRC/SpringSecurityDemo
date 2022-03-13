package com.lrchao.springsecuritydemo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author kevinliu
 * @date 3/12/22 3:37 PM
 * @since v1.0.0
 */


public class MyAuthenticationErrorHandler implements AuthenticationFailureHandler {
    private String url;

    public MyAuthenticationErrorHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("error url: " + url);
        response.sendRedirect(url);
    }
}
