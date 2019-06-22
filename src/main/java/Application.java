import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_context.xml");

        QuestionService questionService = (QuestionService) context.getBean("questionService");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Random random = new Random();
            int id = random.nextInt(4);
            String text = questionService.getQuestionTextById(id);
            System.out.println(text);
            String userAnswer = scanner.next();
            System.out.println(questionService.checkQuestionAnswer(userAnswer,id));
        }
    }
}
