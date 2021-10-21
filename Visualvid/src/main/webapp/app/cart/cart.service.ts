import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { map } from 'rxjs/operators';
import { Observable, BehaviorSubject, Subscriber } from 'rxjs';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { HttpClient } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';
// Get product from Localstorage
let products = JSON.parse(localStorage.getItem('cartItem')!) || [];

@Injectable({
  providedIn: 'root',
})
export class CartService {
  // Array
  public favMediaUrl = SERVER_API_URL + '/api/faviourite/';
  public cartItems: BehaviorSubject<AdminMedia[]> = new BehaviorSubject([]);
  public observer: Subscriber<{}> | undefined;
  constructor(public snackBar: MatSnackBar, private httpClient: HttpClient) {
    this.cartItems.subscribe(media => {
      products = media;
    });
  }

  // Get Products
  public getItems(): Observable<any> {
    return this.httpClient.get(this.favMediaUrl + 'getShoppingCart/' + localStorage.getItem('userId'));
  }

  // Add to cart
  public addToCart(userId: string, product: AdminMedia): Observable<any> {
    // If Products exist
    const message = 'The Media ' + product.name + ' has been added to cart.';
    const status = 'success';
    this.snackBar.open(message, '×', { panelClass: [status], verticalPosition: 'top', duration: 3000 });
    // If Products does not exist (Add New Products)
    products.push(product);
    localStorage.setItem('cartItem', JSON.stringify(products));
    // let cart=new Cart('0',userId,product.id!,product.name!);
    // return this.httpClient.post(url,bodyString);
    return this.httpClient.get(this.favMediaUrl + 'addToCart/' + product.id! + '/' + userId);
  }
  // Removed in cart
  public removeFromCart(item: AdminMedia): Observable<any> {
    const index = products.indexOf(item);
    products.splice(index, 1);
    localStorage.setItem('cartItem', JSON.stringify(products));
    return this.httpClient.delete(this.favMediaUrl + 'removeItemFromCart/' + item.id! + '/' + localStorage.getItem('userId'));
  }

  // Total amount
  public getTotalAmount(): Observable<number> {
    return this.cartItems.pipe(
      map((product: AdminMedia[]) => {
        return products.reduce((prev: any, curr: AdminMedia) => {
          return prev + curr.indianPrice;
        }, 0);
      })
    );
  }

  public removeAllFromCart(): Observable<any> {
    return this.httpClient.delete(this.favMediaUrl + 'deleteAllItemsFromCart/' + localStorage.getItem('userId'));
  }
}
