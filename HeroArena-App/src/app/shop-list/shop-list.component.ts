import { Item } from './../item';
import { Component, OnInit } from '@angular/core';
import { InventoryShopService } from '../inventory-shop.service';

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.css']
})
export class ShopListComponent implements OnInit {

  constructor( private is: InventoryShopService) { }
  shop: any;

  ngOnInit() {
    this.is.getShopItems().subscribe((obj:Object) => {
      this.shop = obj;
      console.log( this.shop );
    });
  }
  onPurchase(itemId: number) {
    this.is.purchaseItemFromShop(itemId).subscribe((obj:Object) => {
      console.log(obj);
    });
}
}
