package com.revature.data.hibernate;

import com.revature.beans.Character;
import com.revature.data.CharacterDAO;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class CharacterHibernate implements CharacterDAO {
    @Autowired
    private HibernateUtil hu;

    @Override
    public Set<Character> getAllCharacters() {
        System.out.println("calling getAllCharacters");
        Session s = hu.getSession();
        String query = "from Character";
        Query<Character> q = s.createQuery(query, Character.class);
        Set<Character> allChars =  new HashSet<>(q.getResultList());

        s.close();
        return allChars;
    }
}
