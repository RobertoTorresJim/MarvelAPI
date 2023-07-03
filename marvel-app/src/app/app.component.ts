import { Component, OnInit } from '@angular/core';
import {CharacterService } from './character.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'marvel-app';
  characters: any[] = [];
  history= {date:''};

  constructor (private characterService: CharacterService){

  }

  ngOnInit(): void{
    this.characterService.getAll().subscribe((data:any)=>this.characters = data.data);
  }

  create(){
    this.characterService. create(this.history);
  }
}
