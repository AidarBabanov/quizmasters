package kz.codemasters.quizmasters;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by aidar on 7/16/17.
 */
@Startup
@Singleton
public class AppConstant {
    public static final String SESSION_USER = "user";

}
