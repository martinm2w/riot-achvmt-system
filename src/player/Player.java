/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import achievement.*;
import heroes.*;
import java.util.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Player {
//===============================constructor====================================
    public Player(PlayerInfo info){
        this.setInfo(info);
        hisStats = new PlayerHistoryStats();
        Achv_handler = new AchievementsHandler();
    }
//================================public========================================
    
//=================================private======================================

//==============================instance vars===================================
    private PlayerInfo info;
    private PlayerHistoryStats hisStats;
    private PlayerCurrGameStats currStats; 
    private AchievementsHandler Achv_handler;
    
    private int level = 1;
    private int curr_level_exp = 0;
    private int next_level_exp = 280;
    private int cummulative_exp = 0;
    private int riotPoints;
    private int influencePoints;
    
    private ArrayList<Hero> heroList; 
    private ArrayList<SommonerSpell> sSpells;
    
//============================setters & getters=================================

    /**
     * @return the info
     */
    public PlayerInfo getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(PlayerInfo info) {
        this.info = info;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the curr_level_exp
     */
    public int getCurr_level_exp() {
        return curr_level_exp;
    }

    /**
     * @param curr_level_exp the curr_level_exp to set
     */
    public void setCurr_level_exp(int curr_level_exp) {
        this.curr_level_exp = curr_level_exp;
    }

    /**
     * @return the next_level_exp
     */
    public int getNext_level_exp() {
        return next_level_exp;
    }

    /**
     * @param next_level_exp the next_level_exp to set
     */
    public void setNext_level_exp(int next_level_exp) {
        this.next_level_exp = next_level_exp;
    }

    /**
     * @return the riotPoints
     */
    public int getRiotPoints() {
        return riotPoints;
    }

    /**
     * @param riotPoints the riotPoints to set
     */
    public void setRiotPoints(int riotPoints) {
        this.riotPoints = riotPoints;
    }

    /**
     * @return the influencePoints
     */
    public int getInfluencePoints() {
        return influencePoints;
    }

    /**
     * @param influencePoints the influencePoints to set
     */
    public void setInfluencePoints(int influencePoints) {
        this.influencePoints = influencePoints;
    }

    /**
     * @return the heroList
     */
    public ArrayList<Hero> getHeroList() {
        return heroList;
    }

    /**
     * @param heroList the heroList to set
     */
    public void setHeroList(ArrayList<Hero> heroList) {
        this.heroList = heroList;
    }

    /**
     * @return the sSpells
     */
    public ArrayList<SommonerSpell> getsSpells() {
        return sSpells;
    }

    /**
     * @param sSpells the sSpells to set
     */
    public void setsSpells(ArrayList<SommonerSpell> sSpells) {
        this.sSpells = sSpells;
    }

    /**
     * @return the cummulative_exp
     */
    public int getCummulative_exp() {
        return cummulative_exp;
    }

    /**
     * @param cummulative_exp the cummulative_exp to set
     */
    public void setCummulative_exp(int cummulative_exp) {
        this.cummulative_exp = cummulative_exp;
    }

    /**
     * @return the hisStats
     */
    public PlayerHistoryStats getHisStats() {
        return hisStats;
    }

    /**
     * @param hisStats the hisStats to set
     */
    public void setHisStats(PlayerHistoryStats hisStats) {
        this.hisStats = hisStats;
    }

    /**
     * @return the Achv_handler
     */
    public AchievementsHandler getAchvHandler() {
        return Achv_handler;
    }

    /**
     * @param Achv_handler the Achv_handler to set
     */
    public void setAchv_handler(AchievementsHandler Achv_handler) {
        this.Achv_handler = Achv_handler;
    }

    /**
     * @return the currStats
     */
    public PlayerCurrGameStats getCurrStats() {
        if(currStats == null){
            System.out.println("The player: " + this.getInfo().getGameID() + "'s current game stats is empty, play a game first!");
        }
        return currStats;
    }

    /**
     * @param currStats the currStats to set
     */
    public void setCurrStats(PlayerCurrGameStats currStats) {
        this.currStats = currStats;
    }
}
