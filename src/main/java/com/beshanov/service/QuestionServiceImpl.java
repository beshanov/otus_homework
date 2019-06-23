package com.beshanov.service;

import com.beshanov.dao.QuestionDao;
import com.beshanov.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Autowired
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

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }
}
