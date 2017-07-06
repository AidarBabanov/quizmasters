package kz.codemasters.quizmasters.model;

import javax.persistence.*;

/**
 * Created by user on 6/28/17.
 */
@Entity
@Table(name = "answer_mult_choice", schema = "quizmasters", catalog = "")
@IdClass(AnswerMultChoicePK.class)
public class AnswerMultChoice {
    private int questionId;
    private int position;
    private String text;
    private byte isright;

    @Id
    @Column(name = "question_id")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Id
    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "isright")
    public byte getIsright() {
        return isright;
    }

    public void setIsright(byte isright) {
        this.isright = isright;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerMultChoice that = (AnswerMultChoice) o;

        if (questionId != that.questionId) return false;
        if (position != that.position) return false;
        if (isright != that.isright) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + position;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (int) isright;
        return result;
    }
}
