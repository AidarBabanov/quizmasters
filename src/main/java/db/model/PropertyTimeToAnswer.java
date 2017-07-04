package db.model;

import javax.persistence.*;

/**
 * Created by user on 6/28/17.
 */
@Entity
@Table(name = "property_time_to_answer", schema = "quizmasters", catalog = "")
public class PropertyTimeToAnswer {
    private int quizId;
    private Integer timeSec;

    @Id
    @Column(name = "quiz_id")
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Basic
    @Column(name = "time_sec")
    public Integer getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(Integer timeSec) {
        this.timeSec = timeSec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyTimeToAnswer that = (PropertyTimeToAnswer) o;

        if (quizId != that.quizId) return false;
        if (timeSec != null ? !timeSec.equals(that.timeSec) : that.timeSec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quizId;
        result = 31 * result + (timeSec != null ? timeSec.hashCode() : 0);
        return result;
    }
}
