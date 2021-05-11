/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.filter.SecurityFilter
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.ServletException
 *  javax.servlet.ServletInputStream
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.stereotype.Component
 */
package com.galaxy.movie.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class SecurityFilter
implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        System.out.println("\n*******************************************************************");
        System.out.println("Security Filter Layer: ");
        System.out.println("\tRequest Type:----------> " + httpServletRequest.getMethod());
        System.out.println("\tRequest URI:-----------> " + httpServletRequest.getRequestURL());
        System.out.println("*******************************************************************\n");
        chain.doFilter((ServletRequest)httpServletRequest, response);
    }

    public String getBody(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            ServletInputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader((InputStream)inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        }
        catch (IOException ex) {
            throw ex;
        }
        finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        String body = stringBuilder.toString();
        return body;
    }
}

