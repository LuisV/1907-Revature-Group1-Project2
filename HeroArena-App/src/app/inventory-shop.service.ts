import { Gladiator } from './gladiator';
import { AuthenticateService } from './authenticate.service';
import { Item } from './item';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Inventory } from './inventory';
import { User } from './user';

const url = 'http://localhost:8080/HeroArena/';

export class InventoryShopService {

  constructor(private http: HttpClient, private as: AuthenticateService) { }

  getShopItems() {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.get( url + 'shop/items', {headers, withCredentials: true}).pipe(map(resp => resp as Item[]));
  }
  purchaseItemFromShop(itemNum: number) {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.put( url + 'shop/items/' + itemNum +"?userId=" + this.as.getUser().id, {headers, withCredentials: true}).pipe(map(resp => resp as Inventory));
  }

  getInventoryByUser(userId: number) {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.get( url + 'user/items?userId=' + this.as.getUser().id, {headers, withCredentials: true}).pipe(map(resp => resp as Inventory));

  }
  useAnItem( gladiatorId: number, itemId: number) {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.delete( url + 'user/items/' +itemId + "?userId="+this.as.getUser().id+"&gladiatorId=2", {headers, withCredentials: true}).pipe(map(resp => resp as Gladiator));

  }

}
