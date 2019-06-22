import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PresentationService;
import service.PresentationServiceImpl;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_context.xml");

        PresentationService presentationService = context.getBean("presentationService", PresentationServiceImpl.class);
        presentationService.start();
    }
}
