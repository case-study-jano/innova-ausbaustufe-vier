package ch.mesoneer.innovapoints.controller;

import ch.mesoneer.innovapoints.entities.Score;
import ch.mesoneer.innovapoints.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.addPointsForInnovationCreation(score.getCreatorName());
    }

    @PutMapping
    public Score updateScore(@RequestBody Score score) {
        return scoreService.addPointsForInnovationApproved(score.getCreatorName());
    }
}
