package Champion;

import java.util.*;

/**
 * m2w: this class contains the available champion list for each players. (it's only
 *      used when creating each player's CurrGameStats Object.)
 *      There are two static variables in this class:
 *      1. championsMap: for searching champion Object by name string.
 *      2. championesList: only for giving different champs for each player while 
 *          creating their CurrGameStats.
 * @author ruobo
 * @lastupdate Aug 20, 2012 
 */
public class Champions {
//===============================constructor====================================
    static{
        championsMap = Champions.initChampiones();
        championesList = Champions.intiChampionesList();
    }
//==================================public======================================
//=================================private======================================
    /**
     * m2w: this private static init methods serves as a static init block, 
     * which creates a map of championes using their name as keys. ps: I only included
     * 10 championes for the sake of simplicity(my favs).
     * @return initialized map of champions
     */
    private static HashMap<String, Champion> initChampiones(){
        HashMap<String, Champion> championsObj = new HashMap<String, Champion>();
        championsObj.put("ashe", new Champion("ashe"));
        championsObj.put("anivia", new Champion("anivia"));
        championsObj.put("cassiopia", new Champion("cassiopia"));
        championsObj.put("teemo", new Champion("teemo"));
        championsObj.put("udyr", new Champion("udyr"));
        championsObj.put("warwick", new Champion("warwick"));
        championsObj.put("irelia", new Champion("irelia"));
        championsObj.put("alistar", new Champion("alistar"));
        championsObj.put("renekton", new Champion("renekton"));
        championsObj.put("evelynn", new Champion("evelynn"));
        return championsObj;
    }
    
    private static ArrayList<Champion> intiChampionesList(){
        ArrayList<Champion> championesListObj = new ArrayList<Champion>();
        championesListObj.addAll(championsMap.values());
        return championesListObj;
    }
//==============================instance vars===================================
    public static HashMap<String, Champion> championsMap; //for searching champion Object by name string. (later use)
    public static ArrayList<Champion> championesList;   //for giving different champs for each player while creating their CurrGameStats.
//============================setters & getters=================================
}
