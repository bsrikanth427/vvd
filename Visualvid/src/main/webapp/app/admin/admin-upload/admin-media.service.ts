import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { AddFaviourite } from 'app/whish-list-items/AddFaviourite';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';

@Injectable({ providedIn: 'root' })
export class AdminMediaService {
  public resourceUrl = SERVER_API_URL + '/api/admin/project-upload';
  public categoryUrl = SERVER_API_URL + '/api/categories/';
  public favMediaUrl = SERVER_API_URL + '/api/faviourite/';
  constructor(protected httpClient: HttpClient, private accService: AccountService) {}

  public save(adminMedia: AdminMedia): Observable<any> {
    if (adminMedia.id) {
      return this.httpClient.put(this.resourceUrl, adminMedia);
    } else {
      return this.httpClient.post(this.resourceUrl, adminMedia);
    }
  }
  public get(id: String): Observable<any> {
    return this.httpClient.get(this.resourceUrl + '/' + id);
  }
  public getAll(categoryId: String): Observable<any> {
    return this.httpClient.get(this.resourceUrl + '/page/category/' + categoryId);
  }

  public getLatest(pageNumber: number, pageSize: number): Observable<any> {
    return this.httpClient.get(this.resourceUrl + '/latest/' + pageNumber + '/' + pageSize);
  }
  searchFilter(pageNumber: number, pageSize: number, searchKey: string): Observable<any> {
    return this.httpClient.get(this.resourceUrl + '/search/' + pageNumber + '/' + pageSize + '/' + searchKey);
  }

  public getPopular(pageNumber: number, pageSize: number): Observable<any> {
    return this.httpClient.get(this.resourceUrl + '/popular/' + pageNumber + '/' + pageSize);
  }

  public addFaviouritMedia(faviourite: AddFaviourite): Observable<any> {
    return this.httpClient.post(this.favMediaUrl + 'create', faviourite);
  }

  public removeFromWishList(faviourite: AdminMedia): Observable<any> {
    return this.httpClient.delete(this.favMediaUrl + 'removeItemFromWishList/' + faviourite.id! + '/' + localStorage.getItem('userId'));
  }

  public fetch(): Observable<Account> {
    return this.httpClient.get<Account>(SERVER_API_URL + 'api/account');
  }

  public getFavouriteMedias(account: Account): Observable<any> {
    return this.httpClient.post(this.favMediaUrl + 'getFavouriteMedais', account);
  }
}
