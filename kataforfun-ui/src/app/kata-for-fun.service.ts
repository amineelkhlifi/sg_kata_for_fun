import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Result } from './model/result';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KataForFunService {
  apiUrl = environment.apiURL;
  constructor(private httpClient: HttpClient) {

   }

   convertNumber(id: any): Observable<Result> {
    console.log(this.apiUrl + '/kata-for-fun/' + id);
    return this.httpClient.get<Result>(this.apiUrl + '/kata-for-fun/' + id);
  }

}
