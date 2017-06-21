package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexandr on 20.06.2017.
 */
@Stateless
public class IndexEJB {

    @PersistenceContext(unitName = "QuizMastersPU")
    private EntityManager entityManager;

    public String getUser(int id){
        UserEntity userEntity = entityManager.find(UserEntity.class, id);
        System.out.println("Test EJB");
        return userEntity.getUsername();
    }
}
