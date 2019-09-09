import { InventoryShopService } from './../../inventory-shop.service';
import { EventEmitter, Component, OnInit, Input, Output } from '@angular/core';

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
@Input() public quantity: number;
@Output() submitted = new EventEmitter();

  constructor(private is: InventoryShopService) { }

  ngOnInit() {

  }
onClick() {
  this.submitted.emit(this.purchaseString);
}

}
