import { Component, OnInit, Input } from '@angular/core';

import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { CartService } from 'app/cart/cart.service';
import { AddFaviourite } from 'app/whish-list-items/AddFaviourite';

@Component({
  selector: 'jhi-videolisting',
  templateUrl: './videolisting.component.html',
  styleUrls: ['videolisting.scss'],
})
export class VideoListingComponent implements OnInit {
  @Input() category: any;
  list: AdminMedia[] = [];
  constructor(private adminMediaService: AdminMediaService, private cartService: CartService, private mediaService: AdminMediaService) {}

  ngOnInit(): void {
    console.log(this.category, 'this is the category');
    this.loadData();
  }
  loadData(): void {
    this.adminMediaService.getAll(this.category.id).subscribe(data => {
      if (data) {
        this.list = data.content;
      }
    });
  }
  public addToCart(product: AdminMedia) {
    const userId = localStorage.getItem('userId');
    this.cartService.addToCart(userId!, product).subscribe(res => {});
  }
  addFaviouritMedia(item: AdminMedia): void {
    const email = localStorage.getItem('email');
    const userId = localStorage.getItem('userId');
    const faviourite = new AddFaviourite('', item.id!, item.name!, userId!, email!);
    this.mediaService.addFaviouritMedia(faviourite).subscribe(res => {});
  }
  onVideoItemDoubleClick(item: any): void {
    window.location.href = '/item/' + item.id;
  }
}
