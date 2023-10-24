import { Component, OnInit } from '@angular/core';
import { Quizz } from 'app/shared/quizz';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  quizzes: any = [];

  loadQuizz() {

    return this.restApi.get("/quiz").subscribe((data: {}) => {
      this.quizzes = data;
    })
  }


  // Add more quizzes as needed


  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {
    this.loadQuizz()

  }

}
