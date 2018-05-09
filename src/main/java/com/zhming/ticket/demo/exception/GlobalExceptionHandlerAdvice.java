package com.zhming.ticket.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request, HttpServletResponse response, Exception exception){
        LOGGER.error("HttpRequest error:{}", request.getRequestURL());
        LOGGER.error("HttpRequest error stack :" ,exception );
        ModelAndView modelAndView = new ModelAndView("/error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        modelAndView.addObject("stackTrace", exception.getStackTrace());
        return modelAndView;
    }
}
