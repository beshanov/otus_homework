package service;

import java.util.Scanner;

public class PresentationServiceImpl implements PresentationService {

    public QuestionService questionService;

    public PresentationServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type your name, please");
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

        System.out.println("Result for user " + userName + " : you have " + score + " right answers from " + numberOfQuestions);
    }
}
