package kz.codemasters.quizmasters.repository;

import kz.codemasters.quizmasters.repository.implementations.*;
import kz.codemasters.quizmasters.repository.interfaces.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by aidar on 7/6/17.
 */
//@Startup
//@Singleton
@Stateless
public class RepositoryFactory {

    @PersistenceContext(name = "QuizMastersPU")
    private EntityManager entityManager;

    public UserRepositroy getUserRepository() {
        return new UserRepositoryImpl(entityManager);
    }

    public AnswerMultChoiceRepository getAnswerMultChoiceRepository() {
        return new AnswerMultChoiceRepositoryImpl(entityManager);
    }

    public PropertyTimeToAnswerRepository getPropertyTimeToAnswerRepository() {
        return new PropertyTimeToAnswerRepositoryImpl(entityManager);
    }

    public QuestionRepository getQuestionRepository() {
        return new QuestionRepositoryImpl(entityManager);
    }

    public QuestionTypeRepository getQuestionTypeRepository() {
        return new QuestionTypeRepositoryImpl(entityManager);
    }

    public QuizRepository getQuizRepository() {
        return new QuizRepositoryImpl(entityManager);
    }

    public QuizPropertyRepository getQuizPropertyRepository() {
        return new QuizPropertyRepositoryImpl(entityManager);
    }

    public QuizPropertyTypeRepository getQuizPropertyTypeRepository() {
        return new QuizPropertyTypeRepositoryImpl(entityManager);
    }

}
