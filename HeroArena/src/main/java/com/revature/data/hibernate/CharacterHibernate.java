package com.revature.data.hibernate;

import com.revature.beans.Character;
import com.revature.data.CharacterDAO;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Override
    public List<Character> getAllCharactersByRarity(String rarity)
    {
        System.out.println("calling getAllCharactersByRarity");
        Session s = hu.getSession();
        String query = "from Character c where c.rarity = :rare";
        Query<Character> q = s.createQuery(query, Character.class);
        q.setParameter("rare", rarity);
        List<Character> allChars =  new ArrayList<>(q.getResultList());

        s.close();
        return allChars;
    }

    @Override
    public Character updateCharacter(Character c) {
        Session s = hu.getSession();
        Transaction t = null;
        try{
            t= s.beginTransaction();

            s.update(c);
            t.commit();
        } catch (Exception e){
            if(t != null)
                t.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return c;
    }

    @Override
    public Character addCharacter(Character c) {
        Session s = hu.getSession();
        Transaction t = null;
        Integer i = 0;
        try{
            t= s.beginTransaction();
            i= (Integer) s.save(c);
            t.commit();
        } catch (Exception e){
            if(t != null)
                t.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return c;
    }

    @Override
    public void deleteCharacter(Character c) {
        Session s = hu.getSession();
        Transaction t = null;

        try{
            t= s.beginTransaction();
           s.delete(c);
            t.commit();
        } catch (Exception e){
            if(t != null)
                t.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

    }
}
