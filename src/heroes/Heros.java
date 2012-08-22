/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package heroes;

import java.util.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 20, 2012 
 */
public class Heros {
//===============================constructor====================================
    static{
        herosMap = Heros.initHeroes();
        heroesList = Heros.intiHeroesList();
    }
//==================================public======================================
//=================================private======================================
    /**
     * m2w: this private static init methods serves as a static init block, 
     * which creates a map of heroes using their name as keys. ps: I only included
     * 10 heroes for the sake of simplicity(my favs).
     * @return initialized map of heros
     */
    private static HashMap<String, Hero> initHeroes(){
        HashMap<String, Hero> herosObj = new HashMap<String, Hero>();
        herosObj.put("ashe", new Hero("ashe"));
        herosObj.put("anivia", new Hero("anivia"));
        herosObj.put("cassiopia", new Hero("cassiopia"));
        herosObj.put("teemo", new Hero("teemo"));
        herosObj.put("udyr", new Hero("udyr"));
        herosObj.put("warwick", new Hero("warwick"));
        herosObj.put("irelia", new Hero("irelia"));
        herosObj.put("alistar", new Hero("alistar"));
        herosObj.put("renekton", new Hero("renekton"));
        herosObj.put("evelynn", new Hero("evelynn"));
        return herosObj;
    }
    
    private static ArrayList<Hero> intiHeroesList(){
        ArrayList<Hero> heroesListObj = new ArrayList<Hero>();
        heroesListObj.addAll(herosMap.values());
        return heroesListObj;
    }
//==============================instance vars===================================
    public static HashMap<String, Hero> herosMap;
    public static ArrayList<Hero> heroesList;
//============================setters & getters=================================
}
