import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css']
})
export class CoursComponent implements OnInit {

  cours = [
    {
      id: 1,
      title: 'Cours 1',
      description: 'Description du cours 1'
    },
    {
      id: 2,
      title: 'Cours 2',
      description: 'Description du cours 2'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
