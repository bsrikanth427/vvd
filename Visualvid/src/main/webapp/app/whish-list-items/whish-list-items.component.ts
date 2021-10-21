import { Component, OnInit } from '@angular/core';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { CartService } from 'app/cart/cart.service';
import { Account } from 'app/core/user/account.model';
// const Plyr = require("plyr");
@Component({
  selector: 'jhi-whish-list-items',
  templateUrl: './whish-list-items.component.html',
  styleUrls: ['./whish-list-items.component.scss'],
})
export class WhishListItemsComponent implements OnInit {
  account?: Account;
  wishlistItems: AdminMedia[] = [];
  // public player :any;
  constructor(private adminMediaService: AdminMediaService, private service: AdminMediaService, private cartService: CartService) {}

  counter(i: number) {
    return new Array(i);
  }
  ngOnInit(): void {
    this.showFavouriteItems();
  }

  showFavouriteItems() {
    this.service.fetch().subscribe(acc => {
      this.adminMediaService.getFavouriteMedias(acc).subscribe(res => {
        if (res) {
          this.wishlistItems = res;
          // const players = Array.from(document.querySelectorAll('.player')).map(p => new Plyr(p));
        }
      });
    });
  }
  public removeItem(item: AdminMedia) {
    this.adminMediaService.removeFromWishList(item).subscribe(res => {
      this.wishlistItems = res;
    });
  }
  onVideoItemClick(item: any): void {
    console.log('videoItem', item);
  }
  onVideoItemDoubleClick(item: any): void {
    window.location.href = '/item/' + item.id;
  }

  public addToCart(product: AdminMedia) {
    const userId = localStorage.getItem('userId');
    this.cartService.addToCart(userId!, product).subscribe(res => {});
  }
}
