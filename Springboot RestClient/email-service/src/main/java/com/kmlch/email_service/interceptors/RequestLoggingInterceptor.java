package com.kmlch.email_service.interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RequestLoggingInterceptor  implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        System.out.println("=====================REST CLIENT LOGGING=====================");
        System.out.println("url: " + request.getURI());
        System.out.println("method: " + request.getMethod());
        System.out.println("headers: " + request.getHeaders());
        System.out.println("body: " + new String(body));
        System.out.println("=============================================================");
        return execution.execute(request,body);
    }
}
