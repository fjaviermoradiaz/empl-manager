package com.enterprise.management.annotation;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Api
@Controller
@RequestMapping
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestBaseController {

    String value() default "/";
    String description() default "Operations controllers";
}
