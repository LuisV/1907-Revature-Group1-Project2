package com.revature.controller;

import com.revature.beans.Character;
import com.revature.beans.Gladiator;
import com.revature.services.CharacterService;
import com.revature.services.GladiatorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Set<Character> getAllCharacters() {
        return cs.getAllCharacters();
    }
}
