package com.revature.services;

import com.revature.beans.Character;
import com.revature.data.CharacterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterService {

    @Autowired
    private CharacterDAO cd;

    public Character getRandomCharacter(){
        // Select rarity class
        String rarity;
        double rand = Math.random();
        if (rand < .55)
       //     rarity = "Common";
       // else if (rand < .85)
            rarity = "Rare";
        else
            rarity = "Epic";

        // Get all Characters of class
        List<Character> chars = cd.getAllCharactersByRarity(rarity);

        if (chars.isEmpty())
            return null;

        // Select random character from list
        int choice = (int) (Math.random() * chars.size());
        return chars.get(choice);
    }
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
