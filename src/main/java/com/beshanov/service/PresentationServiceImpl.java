package com.beshanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class PresentationServiceImpl implements PresentationService {

    private final QuestionService questionService;
    private final MessageSource messageSource;

    @Value("${current.locale}")
    private String currentLocale;

    @Autowired
    public PresentationServiceImpl(QuestionService questionService, MessageSource messageSource) {
        this.questionService = questionService;
        this.messageSource = messageSource;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        Locale locale = new Locale(currentLocale);

        System.out.println(messageSource.getMessage("type.your.name",null, locale));
        String userName = scanner.next();

        int score = 0;

        int numberOfQuestions = questionService.getAllQuestions().size();
        for (int id = 0; id < numberOfQuestions; id++) {
            String text = questionService.getQuestionTextById(id);
            System.out.println(text);
            String userAnswer = scanner.next();
            if (questionService.checkQuestionAnswer(userAnswer, id)) {
                ++score;
            }
        }

        System.out.println(messageSource.getMessage("result.for.user", new Object[]{userName, score, numberOfQuestions}, locale));
    }
}
