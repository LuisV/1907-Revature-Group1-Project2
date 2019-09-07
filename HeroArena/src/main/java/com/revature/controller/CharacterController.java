package com.revature.controller;

import com.revature.beans.Character;
import com.revature.beans.Gladiator;
import com.revature.services.CharacterService;
import com.revature.services.GladiatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@CrossOrigin
@RequestMapping(value="/character")
public class CharacterController {

    @Autowired
    private CharacterService cs;

    @GetMapping("all")
    @ResponseBody
    public ResponseEntity<Set<Character>> getAllCharacters() {
        return ResponseEntity.ok(cs.getAllCharacters());
    }

    @PostMapping
    public ResponseEntity<Character> updateCharacter( @RequestBody Character c){
        return ResponseEntity.ok(cs.updateCharacter(c));
    }

    @PutMapping
    public ResponseEntity<Character> addCharacter( @RequestBody Character c){
        return ResponseEntity.ok(cs.addCharacter(c));
    }

    @DeleteMapping
    public ResponseEntity<Character> deleteCharacter( @RequestBody Character c){
       cs.deleteCharacter(c);
       return ResponseEntity.status(405).build();
    }
}
