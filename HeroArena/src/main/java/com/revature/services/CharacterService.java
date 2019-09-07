package com.revature.services;

import com.revature.beans.Character;
import com.revature.data.CharacterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CharacterService {

    @Autowired
    private CharacterDAO cd;

    public Set<Character> getAllCharacters(){
        return cd.getAllCharacters();
    }
    public Character addCharacter(Character c){
        return cd.addCharacter(c);
    }
    public Character updateCharacter(Character c){
        return cd.updateCharacter(c);
    }
    public void deleteCharacter(Character c){
        cd.deleteCharacter(c);
    }

}
