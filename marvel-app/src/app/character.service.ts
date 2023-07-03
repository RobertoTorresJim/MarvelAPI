import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get('http://localhost:8080/v1/public/characters')
  }
  getCharacter(data: any){
    return this.http.get('http://localhost:8080/v1/public/characters/', data);
  }
  create(data: any){
    return this.http.post('http://localhost:8080/v1/public/characters/details', data);
  }
}
