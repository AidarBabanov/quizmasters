package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by user on 6/28/17.
 */
public class AnswerMultChoiceEntityPK implements Serializable {
    private int questionId;
    private int position;

    @Column(name = "question_id")
    @Id
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Column(name = "position")
    @Id
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerMultChoiceEntityPK that = (AnswerMultChoiceEntityPK) o;

        if (questionId != that.questionId) return false;
        if (position != that.position) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + position;
        return result;
    }
}
