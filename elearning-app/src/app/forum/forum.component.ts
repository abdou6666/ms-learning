import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  forumPosts = [
    {
      title: 'Post 1',
      author: 'John Doe',
      date: 'October 26, 2023',
      content: 'Content for Post 1'
    },
    {
      title: 'Post 2',
      author: 'Jane Smith',
      date: 'November 3, 2023',
      content: 'Content for Post 2'
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
