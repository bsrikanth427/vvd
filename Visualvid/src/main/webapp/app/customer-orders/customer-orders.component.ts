import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { OrderModel } from 'app/order/order.model';
import { OrderService } from 'app/order/order.service';
import { MatTableDataSource } from '@angular/material/table';
@Component({
  selector: 'jhi-customer-orders',
  templateUrl: './customer-orders.component.html',
  styleUrls: ['./customer-orders.component.scss'],
})
export class CustomerOrdersComponent implements OnInit {
  orderList: OrderModel[] = [];
  public displayedColumns = ['orderId', 'name', 'totalCost', 'description', 'status'];
  public dataSource = new MatTableDataSource<OrderModel>();
  @ViewChild(MatSort, { static: true }) sort: MatSort | undefined;
  constructor(private orderService: OrderService) {
    this.orderService.findByUserId().subscribe(res => {
      this.dataSource.data = res;
    });
  }

  ngOnInit(): void {
    this.dataSource.sort = this.sort!;
  }
}
