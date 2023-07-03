package com.marvel.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.api.model.Character;
import com.marvel.api.responses.Response;
import com.marvel.api.services.CharacterService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/v1/public/characters")
public class CharacterController {
	@Autowired
	private CharacterService characterService;
	@GetMapping
	public ResponseEntity<Response<List<Character>>> listAll() {
		List<Character> characters = characterService.listAll();
		
		if (characters.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(new Response<List<Character>>(characters));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Character>> getById(@PathVariable Long id) {
		Character character = this.characterService.listById(id);
		
		if (character == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(new Response<Character>(character));
	}
		
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Response<Character>> add(@Valid @RequestBody Character character, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Character>(erros));
		}
		
		return new ResponseEntity<>(new Response<Character>(this.characterService.add(character)), HttpStatus.CREATED);
	}
	
	
}
