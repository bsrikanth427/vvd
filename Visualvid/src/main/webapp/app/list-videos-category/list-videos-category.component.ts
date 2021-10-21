import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { VideoDesignsService } from 'app/videodesigns/videodesigns.service';
import { CategoryService } from 'app/category/category.service';
import { Category } from 'app/category/category.model';
import { CartService } from 'app/cart/cart.service';
import { MatPaginator } from '@angular/material/paginator';

// const Plyr = require("plyr");

@Component({
  selector: 'jhi-list-videos-category',
  templateUrl: './list-videos-category.component.html',
  styleUrls: ['./list-videos-category.component.scss'],
})
export class ListVideosCategoryComponent implements OnInit {
  @Input() category: any;
  list: AdminMedia[] = [];
  videosByCategory: AdminMedia[] = [];
  public player: any;
  categories: Category[] = [];
  activeId = 'ngb-nav-0';
  panelOpenState = false;
  pageSize = 60;
  pageNumber = 1;
  searchText = '';
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  constructor(
    private categoryService: CategoryService,
    private videoDesignsService: VideoDesignsService,
    private adminMediaService: AdminMediaService,
    private cartService: CartService
  ) {}

  counter(i: number) {
    return new Array(i);
  }

  ngOnInit(): void {
    this.loadData();
    this.getCategories();
  }

  loadData(): void {
    this.list = [];
    this.adminMediaService.getAll('All').subscribe(data => {
      if (data) {
        this.videosByCategory = data.content;
        this.list = this.videosByCategory;
        // const players = Array.from(document.querySelectorAll('.player')).map(p => new Plyr(p));
      }
    });
  }

  orderByDate() {
    this.list = [];
    this.adminMediaService.getLatest(this.paginator!.pageIndex, this.pageSize).subscribe(data => {
      if (data) {
        this.list = data.content;
      }
    });
  }
  orderByPopular() {
    this.list = [];
    this.adminMediaService.getPopular(this.paginator!.pageIndex, this.pageSize).subscribe(data => {
      if (data) {
        this.list = data.content;
      }
    });
  }

  searchFilter() {
    this.list = [];
    this.adminMediaService.searchFilter(this.paginator!.pageIndex, this.pageSize, this.searchText).subscribe(data => {
      if (data) {
        this.list = data.content;
      }
    });
  }

  onVideoItemClick(item: any): void {
    console.log('videoItem', item);
  }
  onVideoItemDoubleClick(item: any): void {
    window.location.href = '/item/' + item.id;
  }

  filterByCategories(categoryId: string) {
    this.list = [];
    this.videosByCategory.forEach(item => {
      if (item.categoryId === categoryId) {
        this.list.push(item);
      }
    });
  }
  filterBySubCategories(subCategoryId: string) {
    this.list = [];
    this.videosByCategory.forEach(category => {
      if (category.subCategoryId === subCategoryId) {
        this.list.push(category);
      }
    });
  }

  public addToCart(product: AdminMedia) {
    const userId = localStorage.getItem('userId');
    this.cartService.addToCart(userId!, product).subscribe(res => {});
  }

  getCategories(): void {
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
