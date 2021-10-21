import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { CookieHelper } from '../cookie/cookie.helper';
import { Observable } from 'rxjs';

@Injectable()
export class HttpApiService {
  // public cookieHelper: CookieHelper = new CookieHelper();
  constructor(private _httpClient: HttpClient) {}

  public fetch(url: string): Observable<any> {
    return this._httpClient.get(url);
  }

  public get(url: string): Observable<any> {
    return this._httpClient.get(url);
  }

  public create(body: Object, url: string): Observable<any> {
    const bodyString = JSON.stringify(body);
    return this._httpClient.post(url, bodyString);
  }

  public update(body: Object, url: string): Observable<any> {
    return this._httpClient.put(url, body);
  }

  public delete(url: string): Observable<any> {
    return this._httpClient.delete(url);
  }

  /* private getAuthToken() {
var cookieName = "";
var cookie = this.cookieHelper.get(cookieName);
var token = ""; //cookie.AuthToken;
return token;
}

private buildHeader() {
var cookieName = "";
var cookie = this.cookieHelper.get(cookieName);
var token = ""; //cookie.AuthToken;
return token;
} */
}
