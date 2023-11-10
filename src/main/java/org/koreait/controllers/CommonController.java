package org.koreait.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.ExpiresFilter;
import org.koreait.commons.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice("org.koreait.controllers")
public class CommonController {

    @ExceptionHandler(Exception.class)
    public String errorHandler(@Valid Exception e, Model model, HttpServletRequest request, HttpServletResponse response) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        response.setStatus(status.value());

        Map<String, String> attrs = new HashMap<>();
        attrs.put("status", String.valueOf(status.value()));
        attrs.put("path", request.getRequestURI()); // 주소
        attrs.put("method", request.getMethod());
        attrs.put("message", e.getMessage());
        attrs.put("timestamp", LocalDateTime.now().toString());

        model.addAllAttributes(attrs);

        Writer writer = new StringWriter(); // 메모리에 쓰임 = 문자열
        PrintWriter pr = new PrintWriter(writer); //변환을 도와주는 역할

        e.printStackTrace(pr); // 표준 에러

        String errorMessage = ((StringWriter)writer).toString();
        log.error(errorMessage);


        return "error/common";

    }
}
