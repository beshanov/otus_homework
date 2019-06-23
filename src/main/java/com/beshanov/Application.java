package com.beshanov;

import com.beshanov.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.beshanov.service.PresentationService;
import com.beshanov.service.PresentationServiceImpl;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PresentationService presentationService = context.getBean("presentationServiceImpl", PresentationServiceImpl.class);
        presentationService.start();
    }
}
