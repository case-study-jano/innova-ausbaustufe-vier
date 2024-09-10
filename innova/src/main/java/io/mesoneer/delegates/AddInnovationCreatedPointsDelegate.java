package io.mesoneer.delegates;

import io.mesoneer.entities.InnovationProposal;
import io.mesoneer.external.ScoreServiceExternal;
import io.mesoneer.repositories.InnovationProposalRepository;
import jakarta.ws.rs.NotFoundException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddInnovationCreatedPointsDelegate implements JavaDelegate {

    private final ScoreServiceExternal scoreService;
    private final InnovationProposalRepository innovationProposalRepository;

    @Autowired
    public AddInnovationCreatedPointsDelegate(InnovationProposalRepository innovationProposalRepository, ScoreServiceExternal scoreService) {
        this.scoreService = scoreService;
        this.innovationProposalRepository = innovationProposalRepository;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long proposalId = (Long) delegateExecution.getVariable("proposalId");
        InnovationProposal proposal = innovationProposalRepository.findById(proposalId).orElseThrow(NotFoundException::new);
        String creatorName = proposal.getCreatorName();

        scoreService.createScore(creatorName);
    }
}
