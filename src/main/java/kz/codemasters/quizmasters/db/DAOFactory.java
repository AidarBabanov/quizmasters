package kz.codemasters.quizmasters.db;

import kz.codemasters.quizmasters.db.DAO.*;
import kz.codemasters.quizmasters.db.DAOImpl.*;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by aidar on 7/6/17.
 */
@Startup
//@Singleton
@Stateless
public class DAOFactory {

    @PersistenceContext(name = "QuizMastersPU")
    EntityManager entityManager;

    public UserDAO getUserDAO(){
        return new UserDAOImpl(entityManager);
    }

    public AnswerMultChoiceDAO getAnswerMultChoiceDAO(){
        return new AnswerMultChoiceDAOImpl(entityManager);
    }

    public PropertyTimeToAnswerDAO getPropertyTimeToAnswerDAODAO(){
        return new PropertyTimeToAnswerDAOImpl(entityManager);
    }

    public QuestionDAO getQuestionDAO(){
        return new QuestionDAOImpl(entityManager);
    }

    public QuestionTypeDAO getQuestionTypeDAO(){
        return new QuestionTypeDAOImpl(entityManager);
    }

    public QuizDAO getQuizDAO(){
        return new QuizDAOImpl(entityManager);
    }

    public QuizPropertyDAO getQuizPropertyDAO(){
        return new QuizPropertyDAOImpl(entityManager);
    }

    public QuizPropertyTypeDAO getQuizPropertyTypeDAO(){
        return new QuizPropertyTypeDAOImpl(entityManager);
    }

}
