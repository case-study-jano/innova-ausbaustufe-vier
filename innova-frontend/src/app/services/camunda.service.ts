import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CamundaService {
  private camundaApiUrl = 'https://localhost:8080/engine-rest'; // Replace with your API endpoint

  constructor(private http: HttpClient) {
  }


  startProcess(): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(`${this.camundaApiUrl}/process-definition/key/process-innova-main/start`, {headers});
  }

  getOpenUserTask(processDefinitionId: string): Observable<any> {
    return this.http.get<any>(`${this.camundaApiUrl}/task?processDefinitionId=${processDefinitionId}`);
  }

  completeTask(taskId: string, creatorName: string, proposalTitle: string, proposalDescription: string): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(`${this.camundaApiUrl}/task/${taskId}/complete`, this.createCompleteTaskBody(creatorName, proposalTitle, proposalDescription), {headers});
  }

  private createCompleteTaskBody(creatorName: string, proposalTitle: string, proposalDescription: string): object {
    return {
      "variables":
        {
          "creatorName": {"value": creatorName},
          "proposalTitle": {"value": proposalTitle},
          "proposalDescription": {"value": proposalDescription}
        }

    }
  }
}
