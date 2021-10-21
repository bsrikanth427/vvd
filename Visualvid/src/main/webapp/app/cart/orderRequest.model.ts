import { ItemCustomization } from './itemCustomization';

export interface OrderRequestArr {
  couponCode?: string;
  currencyCode?: string;
  itemCustomizations?: ItemCustomization[];
}
