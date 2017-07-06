package kz.codemasters.quizmasters.model;

import javax.persistence.*;

/**
 * Created by user on 6/28/17.
 */
@Entity
@Table(name = "question", schema = "quizmasters", catalog = "")
public class Question {
    private int id;
    private int quizId;
    private int questionTypeId;
    private String text;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quiz_id")
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Basic
    @Column(name = "question_type_id")
    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question that = (Question) o;

        if (id != that.id) return false;
        if (quizId != that.quizId) return false;
        if (questionTypeId != that.questionTypeId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quizId;
        result = 31 * result + questionTypeId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
