package com.example.mebelsite.view;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/navbar").setViewName("/components/navigationBar");
        registry.addViewController("/footer").setViewName("/components/floor");

        registry.addViewController("/partners").setViewName("/site/partners");
        registry.addViewController("/services").setViewName("/site/services");

        registry.addViewController("/static/help").setViewName("/static/help");
        registry.addViewController("/static/history").setViewName("/static/history");
        registry.addViewController("/static/filosof").setViewName("/static/filosof");
        registry.addViewController("/static/social").setViewName("/static/social");
        registry.addViewController("/static/imagination").setViewName("/static/imagination");
        registry.addViewController("/static/").setViewName("/static/");
        registry.addViewController("/static/").setViewName("/static/");
        registry.addViewController("/static/").setViewName("/static/");

    }
}