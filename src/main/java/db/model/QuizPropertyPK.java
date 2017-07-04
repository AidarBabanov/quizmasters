package db.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by user on 6/28/17.
 */
public class QuizPropertyPK implements Serializable {
    private int quizId;
    private int quizPropertyTypeId;

    @Column(name = "quiz_id")
    @Id
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Column(name = "quiz_property_type_id")
    @Id
    public int getQuizPropertyTypeId() {
        return quizPropertyTypeId;
    }

    public void setQuizPropertyTypeId(int quizPropertyTypeId) {
        this.quizPropertyTypeId = quizPropertyTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizPropertyPK that = (QuizPropertyPK) o;

        if (quizId != that.quizId) return false;
        if (quizPropertyTypeId != that.quizPropertyTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quizId;
        result = 31 * result + quizPropertyTypeId;
        return result;
    }
}
