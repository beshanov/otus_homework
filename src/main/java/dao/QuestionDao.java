package dao;

import domain.Question;

import java.util.List;

public interface QuestionDao {
    Question getQuestionById(int id);

    List<Question> getAllQuestions();
}
