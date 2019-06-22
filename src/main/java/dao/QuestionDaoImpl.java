package dao;

import domain.Question;
import utils.QuestionParser;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionDaoImpl implements QuestionDao {

    private QuestionParser questionParser;

    public QuestionDaoImpl(QuestionParser questionParser) {
        this.questionParser = questionParser;
    }

    public Question getQuestionById(int id) {
        ArrayList<Question> allQuestions = null;
        try {
            allQuestions = questionParser.getAllQuestions();
        } catch (IOException e) {
            System.err.println("Problem with reading CSV file");
        }
        for (Question question : allQuestions) {
            if (question.getId() == id) {
                return question;
            }
        }

        return null;
    }
}
