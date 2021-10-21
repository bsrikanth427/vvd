import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserSubscriptionModel } from './user-subscription.model';
@Injectable({ providedIn: 'root' })
export class SubscriptionService {
  public resourceUrl = 'http://localhost:8080/api/subscription/';
  public userUrl = 'http://localhost:8080/api/user/subscription/';
  constructor(private httpClient: HttpClient) {}

  public getSubscriptionPlans(): Observable<any> {
    return this.httpClient.get(this.resourceUrl + 'subscribes/Active');
  }

  public userSubScription(subscription: UserSubscriptionModel): Observable<any> {
    return this.httpClient.post(this.userUrl + 'new', subscription);
  }
}
