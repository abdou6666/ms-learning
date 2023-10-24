import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events = [
    {
      title: 'Event 1',
      date: 'October 25, 2023',
      description: 'Description for Event 1'
    },
    {
      title: 'Event 2',
      date: 'November 2, 2023',
      description: 'Description for Event 2'
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
