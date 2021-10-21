import { Component, Input, OnInit, AfterViewInit, TemplateRef, ViewChild } from '@angular/core';
import { OrderModel } from 'app/order/order.model';
import { OrderService } from 'app/order/order.service';
import { ColumnSettingsModel } from 'app/shared/table/table-settings.model';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
export interface Action {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'jhi-dashboard-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['orders.scss'],
})
export class DashboardOrdersComponent implements OnInit, AfterViewInit {
  @Input() orders?: OrderModel[];
  @ViewChild('orderStatusTemplate', { static: true }) orderStatusTemplate?: TemplateRef<any>;
  columnDefinition: ColumnSettingsModel[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  rowData: Array<OrderModel> = [];
  pageSize = 5;
  pageNumber = 1;
  length = 1000;
  pageEvent: PageEvent | undefined;
  datasource: null;
  pageIndex = 0;
  dataSource = new MatTableDataSource<OrderModel>(this.rowData);
  displayedColumns = ['name', 'orderId', 'orderStatus'];
  // dataSource = new MatTableDataSource<OrderModel>(this.rowData);
  actions: Action[] = [
    { viewValue: 'Action 1', value: 'action1' },
    { viewValue: 'Action 2', value: 'action2' },
    { viewValue: 'Action 3', value: 'action3' },
  ];
  currentAction = 'action1';
  todoService: any;
  todos: any;
  totalElements: any;
  loading: boolean | undefined;
  constructor(private orderService: OrderService) {}

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator ? this.paginator : null;
    console.log('this.orderStatusTemplate', this.orderStatusTemplate);
  }
  ngOnInit(): void {
    this.columnDefinition = [
      {
        name: 'name',
        displayName: 'Name',
      },
      {
        name: 'orderId',
        displayName: 'Order ID #',
      },
      {
        name: 'orderStatus',
        displayName: 'Status',
        cellTemplate: this.orderStatusTemplate,
      },
    ];
    this.orderService.findAll(this.paginator ? this.paginator.pageIndex : 0, this.pageSize).subscribe(data => {
      console.log(data);
      this.rowData = data;
      this.pageIndex = this.paginator ? this.paginator.pageIndex : 0;
      // eslint-disable-next-line no-self-assign
      this.pageSize = this.pageSize;
      // this.length = data.length;
      this.dataSource = new MatTableDataSource<OrderModel>(this.rowData);
    });
  }
  onNotifySelected(selectedRows: object[]): void {
    console.log(selectedRows);
  }
  onDoubleClick(data: any): void {
    window.location.href = '/customer/upload/' + data.adminMediaId + '/' + data.id;
  }
  search(evt: any): void {
    console.log(evt);
    // TODO call a back-end service awith evt.query and map result to this.rowData;
  }

  getServerData(event: PageEvent) {
    this.orderService.findAll(event.pageIndex, event.pageSize).subscribe(data => {
      console.log(data);
      this.rowData = data;
      this.pageIndex = event.pageIndex;
      // eslint-disable-next-line no-self-assign
      this.pageSize = event.pageSize;
      // this.length = data.length;
      this.dataSource = new MatTableDataSource<OrderModel>(this.rowData);
    });
  }
}
