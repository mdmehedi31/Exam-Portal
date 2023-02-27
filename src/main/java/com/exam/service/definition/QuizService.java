package com.exam.service.definition;

import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizList();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);
}
