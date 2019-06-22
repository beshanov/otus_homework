package service;

import dao.QuestionDao;
import domain.Question;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }

    public String getQuestionTextById(int id) {
        return questionDao.getQuestionById(id).getQuestionText();
    }

    public boolean checkQuestionAnswer(String userAnswer, int id) {
        Question question = questionDao.getQuestionById(id);
        String correctAnswer = question.getAnswer().trim();
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
