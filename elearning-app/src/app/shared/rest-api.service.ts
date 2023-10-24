import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap, Subject, catchError, retry, throwError } from 'rxjs';
import { Quizz } from './quizz';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  apiURL = 'http://localhost:8081/api'

  private _refreshNeeded = new Subject<void>();

  get refreshNeeded() {
    return this._refreshNeeded;
  }

  constructor(private httpClient: HttpClient) {
  }

  get(target: string) {
    return this.httpClient.get(this.apiURL + target);
  }
  getAllComments(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.apiURL}/comments/all`);
  }


  add(target: string, requestBody: Object) {
    return this.httpClient.post(this.apiURL + target, requestBody).pipe(
      tap(() => {
        this._refreshNeeded.next();
      })
    );
  }

  delete(target: string, elementId: number) {
    return this.httpClient.delete(this.apiURL + target + '/' + elementId).pipe(
      tap(() => {
        this._refreshNeeded.next();
      })
    );
  }

  update(target: string, elementId: number, requestBody: Object) {
    return this.httpClient
      .put(this.apiURL + target + '/' + elementId, requestBody)
      .pipe(
        tap(() => {
          this._refreshNeeded.next();
        })
      );
  }

  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    console.log(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
