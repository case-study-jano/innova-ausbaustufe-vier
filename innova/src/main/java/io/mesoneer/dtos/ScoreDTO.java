package io.mesoneer.dtos;


public class ScoreDTO {

    private String creatorName;

    public ScoreDTO(String creatorName) {
        this.creatorName = creatorName;
    }

    public ScoreDTO() {
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
