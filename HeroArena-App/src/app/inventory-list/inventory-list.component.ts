import { AuthenticateService } from './../authenticate.service';
import { Component, OnInit } from '@angular/core';
import { Inventory } from '../inventory';
import { InventoryShopService } from '../inventory-shop.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css']
})
export class InventoryListComponent implements OnInit {

  constructor(private ss: InventoryShopService, private as: AuthenticateService) { }
  inventory: any;
  ngOnInit() {
    this.ss.getInventoryByUser(this.as.getUser().id).subscribe((obj: object) => {
      this.inventory = obj;
      console.log(this.inventory);
    });

  }
handleUse(itemId: number) {
  this.ss.useAnItem(4, itemId).subscribe((obj: object) => {
    this.ngOnInit();
  });
}

}
