export class UserSubscriptionModel {
  userId?: String;
  planName?: String;
  subscriptionId?: String;
  currencyCode?: String;
  userName?: String;
  startDate?: String;
  endDate?: String;
  ordersLeft?: String;
  availedOrders?: String;
  status: String;
  action?: String;

  constructor(
    userId: String,
    planName: String,
    subscriptionId: String,
    currencyCode: String,
    userName: String,
    availedOrders: String,
    startDate: String,
    endDate: String,
    ordersLeft: String,
    status: String,
    action: String
  ) {
    this.userId = userId;
    this.planName = planName;
    this.subscriptionId = subscriptionId;
    this.currencyCode = currencyCode;
    this.userName = userName;
    this.availedOrders = availedOrders;
    this.startDate = startDate;
    this.endDate = endDate;
    this.ordersLeft = ordersLeft;
    this.status = status;
    this.action = action;
  }
}
