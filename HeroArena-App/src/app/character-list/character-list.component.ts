import { CharacterService } from './../character.service';
import {Character} from '../character';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-character-list',
  templateUrl: './character-list.component.html',
  styleUrls: ['./character-list.component.css']
})
export class CharacterListComponent implements OnInit {

  chars: any;
  constructor( private cs: CharacterService) { }

  ngOnInit() {
    this.cs.getAllCharacters().subscribe((obj:Object) =>{
      console.log(obj);
      this.chars = obj;
    });
  }
  handleSubmit(){
   this.ngOnInit();
  }
}
