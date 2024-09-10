import {Component, OnInit} from '@angular/core';
import {CamundaService} from "../../services/camunda.service";

@Component({
  selector: 'app-proposal-creator',
  templateUrl: './proposal-creator.component.html',
  styleUrls: ['./proposal-creator.component.css']
})
export class ProposalCreatorComponent implements OnInit {

  creatorName = '';
  title = '';
  description = '';


  constructor(private camundaService: CamundaService) {
  }

  ngOnInit(): void {
  }

  public createProcessAndMakeProposal(): void {
    this.camundaService.startProcess()
      .subscribe(response => {
        console.log(response);
      })
  }

}
