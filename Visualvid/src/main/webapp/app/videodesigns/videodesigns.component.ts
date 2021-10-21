import { Component, OnInit } from '@angular/core';

import { Category } from 'app/category/category.model';
import { VideoDesignsService } from './videodesigns.service';
import { CategoryService } from 'app/category/category.service';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';

@Component({
  selector: 'jhi-videodesigns',
  templateUrl: './videodesigns.component.html',
  styleUrls: ['videodesigns.scss'],
})
export class VideoDesignsComponent implements OnInit {
  categories: Category[] = [];
  activeId = 'ngb-nav-0';
  category: Category | undefined;
  list: AdminMedia[] = [];
  // showCategory:boolean = false;
  constructor(
    private videoDesignsService: VideoDesignsService,
    private categoryService: CategoryService,
    private adminMediaService: AdminMediaService
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  filterByCategories(category: Category) {
    this.list = [];
    this.adminMediaService.getAll(category.id!).subscribe(data => {
      if (data) {
        this.list = data.content;
      }
    });
  }
  loadData(): void {
    this.categoryService.getCategories().subscribe(data => {
      if (data) {
        this.categories = data;
        this.categories.forEach(c => {
          c.nameFormatted = c.name.split(' ').join(' ');
        });
      }
    });
  }
}
