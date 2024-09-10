package ch.mesoneer.innovapoints.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String creatorName;
    private int points;

    public Score(String creatorName, int points) {
        this.creatorName = creatorName;
        this.points = points;
    }

    public Score() {
    }

    public void addScorePoints(int points) {
        this.points += points;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String fullUserName) {
        this.creatorName = fullUserName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
