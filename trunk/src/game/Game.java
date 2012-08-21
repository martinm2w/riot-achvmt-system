/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.*;
import player.*;
import heroes.*;

/**
 * m2w: this class tends to emulate the game client. 
 * The java platform passes in infos like who the players are, which team their on, which heros they are using.
 * Then the client starts and passes back finished current game stats to the java platform.
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Game {
//===============================constructor====================================
    public Game(ArrayList<Player> purple_team, ArrayList<Player> blue_team){
        this.setBlue_team(blue_team);
        this.setPurple_team(purple_team);
    }
//================================public========================================        
    /**
     * m2w: this method simulates the game process, generate each player's behavior for end game results.
     */
    public void gameStart(){
        /*blue team*/
        for(Player p : blue_team){
            int physical_dmg = (int)Math.random()*200000;
            int physical_hits_num = (int)Math.random()*200000;
            p.getCurrStats().updatePlayerCurrGameStats(physical_dmg, physical_hits_num, physical_miss_num, spell_cast_num, spell_dmg, kills, assists, first_hit_kills, time_played, exp_earned, ip_earned, Heros.heros.get(p));
        }
        /*purple team*/
    }
    
    /**
     * m2w: this method sets the game status to hasEnded.
     */
    public void gameEnd(){
        this.setHasEnded(true);
    }
//=================================private======================================
//==============================instance vars===================================
    private ArrayList<Player> purple_team;
    private ArrayList<Player> blue_team;
    private boolean hasEnded = false;
//============================setters & getters=================================

    /**
     * @return the purple_team
     */
    public ArrayList<Player> getPurple_team() {
        return purple_team;
    }

    /**
     * @param purple_team the purple_team to set
     */
    public void setPurple_team(ArrayList<Player> purple_team) {
        this.purple_team = purple_team;
    }

    /**
     * @return the blue_team
     */
    public ArrayList<Player> getBlue_team() {
        return blue_team;
    }

    /**
     * @param blue_team the blue_team to set
     */
    public void setBlue_team(ArrayList<Player> blue_team) {
        this.blue_team = blue_team;
    }

    /**
     * @return the hasEnded
     */
    public boolean isHasEnded() {
        return hasEnded;
    }

    /**
     * @param hasEnded the hasEnded to set
     */
    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }
}
