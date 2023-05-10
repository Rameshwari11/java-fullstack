import { Component } from '@angular/core';
import { OrderList } from './order-list';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent {

  orderList : OrderList[] =[
    new OrderList(1,"Vegetables",6000,'Yes'),
    new OrderList(2,"Furniture",10000,'Yes'),
    new OrderList(3,"Fruits",4000,'No'),
    new OrderList(4,"Clothing",9000,'Yes'),

  ]

  OrderId = '';
 OrderName='';
 OrderPrice ='';
 ClearOrder ='';
}
