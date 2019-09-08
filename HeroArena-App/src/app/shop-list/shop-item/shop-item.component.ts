import { InventoryShopService } from './../../inventory-shop.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-shop-item',
  templateUrl: './shop-item.component.html',
  styleUrls: ['./shop-item.component.css']
})
export class ShopItemComponent implements OnInit {
@Input() public id: number;
@Input() public name: string;
@Input() public description: string;
@Input() public price: number;
@Input() public amount: number;
@Input() public purchaseString: string;
  constructor(private is: InventoryShopService) { }

  ngOnInit() {

  }

  onPurchase() {
      this.is.purchaseItemFromShop(this.id).subscribe((obj:Object) => {
        console.log(obj);
      });
  }
}
