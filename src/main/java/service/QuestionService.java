package service;

import domain.Question;

public interface QuestionService {
    Question getQuestionById(int id);

    String getQuestionTextById(int id);

    boolean checkQuestionAnswer(String userAnswer, int id);
}
