import { TestBed } from '@angular/core/testing';

import { InventoryShopService } from './inventory-shop.service';

describe('InventoryShopService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InventoryShopService = TestBed.get(InventoryShopService);
    expect(service).toBeTruthy();
  });
});
