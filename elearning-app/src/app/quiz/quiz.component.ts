import {Component, OnInit} from '@angular/core';
import {Quizz} from 'app/shared/quizz';
import {RestApiService} from 'app/shared/rest-api.service';

@Component({
    selector: 'app-quiz',
    templateUrl: './quiz.component.html',
    styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
    quizzes: Quizz[] = [];

    loadQuizz() {
        return this.restApi.get<Quizz>("/quiz/").subscribe((data) => {
            console.log(data)
            this.quizzes = data;
        })
    }


    constructor(public restApi: RestApiService) {
    }

    ngOnInit(): void {
        this.loadQuizz()

    }

}
