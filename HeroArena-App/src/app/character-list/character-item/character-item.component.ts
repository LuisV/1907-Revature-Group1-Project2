import { CharacterService } from './../../character.service';
import { EventEmitter, Component, OnInit, ChangeDetectionStrategy, Input, Output } from '@angular/core';
import { Character } from 'src/app/character';
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
  @Output() submitted = new EventEmitter();

  constructor( private cs: CharacterService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const ch = new Character(this.id, this.name, this.description,
      this.strength, this.dexterity, this.vitality, this.health, this.rarity);
    console.log(ch);
    this.cs.updateCharacter(ch).subscribe((obj: Object) => {
    console.log(obj);
    this.submitted.emit('submitted');
  });
  }

  delete() {
    const ch = new Character(this.id, this.name, this.description,
      this.strength, this.dexterity, this.vitality, this.health, this.rarity);
    console.log(ch);
    this.cs.deleteCharacter(ch).subscribe(() => {
    this.submitted.emit('Submit!');
  });
  }
}
