package db.model;

import javax.persistence.*;

/**
 * Created by user on 6/28/17.
 */
@Entity
@Table(name = "quiz_property", schema = "quizmasters", catalog = "")
@IdClass(QuizPropertyPK.class)
public class QuizProperty {
    private int quizId;
    private int quizPropertyTypeId;

    @Id
    @Column(name = "quiz_id")
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Id
    @Column(name = "quiz_property_type_id")
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

        QuizProperty that = (QuizProperty) o;

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
