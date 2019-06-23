package com.beshanov.dao;

import com.beshanov.domain.Question;

import java.util.List;

public interface QuestionDao {
    Question getQuestionById(int id);

    List<Question> getAllQuestions();
}
