package kz.codemasters.quizmasters;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by serikzhilibayev on 27.07.17.
 */
@Startup
@Singleton
public class Pages {
    public static final String MAIN_PAGE = "mainpage.xhtml";
    public static final String QUESTIONS_PAGE = "questions.xhtml";
    public static final String REGISTRATION_PAGE = "registrationPage.xhtml";


}
