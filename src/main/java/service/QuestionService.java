package service;

import domain.Question;

import java.util.List;

public interface QuestionService {
    Question getQuestionById(int id);

    String getQuestionTextById(int id);

    boolean checkQuestionAnswer(String userAnswer, int id);

    List<Question> getAllQuestions();
}
