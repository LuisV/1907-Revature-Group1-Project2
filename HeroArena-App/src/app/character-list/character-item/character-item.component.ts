import { Component, OnInit, ChangeDetectionStrategy, Input } from '@angular/core';

@Component({
  selector: 'app-character-item',
  templateUrl: './character-item.component.html',
  styleUrls: ['./character-item.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CharacterItemComponent implements OnInit {

  @Input() public id: number;
  @Input() public name: string;
  @Input() public description: string;
  @Input() public strength: number;
  @Input() public dexterity: number;
  @Input() public health: number;
  @Input() public rarity: string;
  @Input() public vitality: number;

  ngOnInit(): void {
  }
}
