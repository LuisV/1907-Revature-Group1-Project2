import { AuthenticateService } from './../authenticate.service';
import { Component, OnInit } from '@angular/core';
import { Inventory } from '../inventory';
import { InventoryShopService } from '../inventory-shop.service';
import { UserService } from '../user.service';
import { UserItemComponent } from '../user-list/user-item/user-item.component';

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css']
})
export class InventoryListComponent implements OnInit {

  constructor(private ss: InventoryShopService, private as: AuthenticateService) { }
  inventory: any;
  currItem: number;
  ngOnInit() {
    this.currItem = null;
    this.ss.getInventoryByUser(this.as.getUser().id).subscribe((obj: object) => {
      this.inventory = obj;
      console.log(this.inventory);
    });
  }

  displayTargetSelector(itemId: number) {
    this.currItem = itemId;
  }

  applyItemToTarget(targetId: number) {
    console.log('Applying item #' + this.currItem + ' to Gladiator #' + targetId)
    this.ss.useAnItem(targetId, this.currItem).subscribe((obj: object) => {
      this.ngOnInit();
    });
  }
}
