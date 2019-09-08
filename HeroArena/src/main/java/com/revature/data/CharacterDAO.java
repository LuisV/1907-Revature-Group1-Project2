package com.revature.data;

import com.revature.beans.Character;

import java.util.List;
import java.util.Set;

public interface CharacterDAO {

    public Set<Character> getAllCharacters();
    public List<Character> getAllCharactersByRarity(String rarity);
    public Character updateCharacter(Character c);
    public Character addCharacter(Character c);
    public void deleteCharacter(Character c);
}
