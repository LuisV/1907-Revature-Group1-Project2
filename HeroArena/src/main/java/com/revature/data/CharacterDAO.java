package com.revature.data;

import com.revature.beans.Character;

import java.util.Set;

public interface CharacterDAO {

    public Set<Character> getAllCharacters();
    public Character updateCharacter(Character c);
    public Character addCharacter(Character c);
    public void deleteCharacter(Character c);
}
