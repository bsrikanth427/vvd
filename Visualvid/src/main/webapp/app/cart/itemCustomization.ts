export class ItemCustomization {
  adminMediaId: string;
  optedForAdvCustomization: boolean;
  optedForPremumDelivery: boolean;
  currencyCode: string;
  constructor(adminMediaId: string, optedForAdvCustomization: boolean, optedForPremumDelivery: boolean, currencyCode: string) {
    this.adminMediaId = adminMediaId;
    this.optedForAdvCustomization = optedForAdvCustomization;
    this.optedForPremumDelivery = optedForPremumDelivery;
    this.currencyCode = currencyCode;
  }
}
