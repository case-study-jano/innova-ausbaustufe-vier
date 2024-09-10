package ch.mesoneer.innovapoints.repositories;

import ch.mesoneer.innovapoints.entities.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScoreRepository extends CrudRepository<Score, Long> {
    Optional<Score> findByCreatorName(String fullUserName);
}
