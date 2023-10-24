import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css'],
})
export class CourseDetailComponent implements OnInit {
  courseId: number | undefined;
  course: any;
  comments: string[] = [];
  newComment:string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.courseId = +params['id'];

      this.course = {
        title: 'Sample Course',
        description: 'Sample Description',
      };
      this.comments = ['Comment 1', 'Comment 2']; // Sample comments
    });
  }

  addComment(newComment: string) {
    this.comments.push(newComment);
  }
}
