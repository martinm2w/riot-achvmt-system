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
     * for simplicity, ignored that total blue kill should equals to total purple deaths.
     */
    public void gameStart(){
        /*generate winner*/
        int winRand = (int)Math.random()*10;
        if(winRand >= 5) blueWins = true;
        
        if(blueWins){//if blue team wins, given blue team 20 more kills
            setTotalBlueKills((int)Math.random()*50+20);
            setTotalPurpleKills((int)Math.random()*50);
        }else{//else give purple team 20 more kills.
            setTotalBlueKills((int)Math.random()*50);
            setTotalPurpleKills((int)Math.random()*50+20);
        }
        
        /* KDAs*/
        int blueKillsLeft = getTotalBlueKills();     //these 2 "left" vars are for assigning each players kills. substracting players kills from it each time.
        int purpleKillsLeft = getTotalPurpleKills(); //
        int blueDeathsLeft = getTotalPurpleKills();  //these 2 are for the deaths for each player.
        int purpleDeathsLeft = getTotalBlueKills();  //total blue kills should match total purple deaths.
                                                //assists will generate randomly between 0-20
        int towersTakenBlue = 11;
        int towersTakenPurple = 11;
                                               
        /*blue team*/
        this.setBlueCurrStats(blueKillsLeft, blueDeathsLeft, towersTakenBlue);
        /*purple team*/
        this.setPurpleCurrStats(purpleKillsLeft, purpleDeathsLeft, towersTakenPurple);
    }
    
    /**
     * m2w: this method sets the game status to hasEnded.
     */
    public void gameEnd(){
        this.setHasEnded(true);

    }
//=================================private======================================
    private void setBlueCurrStats(int blueKillsLeft, int blueDeathsLeft, int towersTakenBlue){
        for(int i = 0; i < this.getBlue_team().size(); i ++){
            Player p = this.getBlue_team().get(i);
            
            /*dmg*/
            int physical_dmg = (int)Math.random()*200000;
            int physical_hits_num = (int)Math.random()*2000;
            int physical_miss_num = (int)Math.random()*1000; // misses are set at most half of hits
            int spell_cast_num = (int)Math.random()*1500;
            int spell_dmg = (int)Math.random()*200000;
            int csCount = (int)Math.random()*400;            // should be related to game time, omitted for simplicity here.
            
            /*KDAs*/
            int kills = (int)Math.random()*blueKillsLeft; 
            blueKillsLeft -= kills;
            int deaths = (int)Math.random()*blueDeathsLeft;
            blueDeathsLeft -= deaths;
            int towersTaken = (int)Math.random()*towersTakenBlue;
            towersTakenBlue -= towersTaken;
            int assists = (int)Math.random()*20;
            
            int first_hit_kills = (int)Math.random()*kills; //
            int time_played = this.getElapsedTime();
            int exp_earned = (int)Math.random()*200;
            int ip_earned = (int)Math.random()*100;
            if(blueWins){//if blue wins , get more exp and ip
                exp_earned+=200;
                ip_earned+=100;
            }
//            System.out.println(p.getCurrStats());
            PlayerCurrGameStats curStats = new PlayerCurrGameStats(physical_dmg, physical_hits_num, physical_miss_num, spell_cast_num, spell_dmg, kills, deaths, assists, first_hit_kills, time_played, exp_earned, ip_earned, Heros.heroesList.get(i), csCount, towersTaken);
            p.setCurrStats(curStats);
        }
    }
    
    private void setPurpleCurrStats(int purpleKillsLeft, int purpleDeathsLeft, int towersTakenPurple){
        for(int i = 0; i < this.getPurple_team().size(); i ++){
            Player p = this.getPurple_team().get(i);
            
            /*dmg*/
            int physical_dmg = (int)Math.random()*200000;
            int physical_hits_num = (int)Math.random()*2000;
            int physical_miss_num = (int)Math.random()*1000; // misses are set at most half of hits
            int spell_cast_num = (int)Math.random()*1500;
            int spell_dmg = (int)Math.random()*200000;
            int csCount = (int)Math.random()*400;            // should be related to game time, omitted for simplicity here.
            
            /*KDAs*/
            int kills = (int)Math.random()*purpleKillsLeft; 
            purpleDeathsLeft -= kills;
            int deaths = (int)Math.random()*purpleDeathsLeft;
            purpleDeathsLeft -= deaths;
            int towersTaken = (int)Math.random()*towersTakenPurple;
            towersTakenPurple -= towersTaken;
            int assists = (int)Math.random()*20;
            
            int first_hit_kills = (int)Math.random()*kills; //
            int time_played = this.getElapsedTime();
            int exp_earned = (int)Math.random()*200;
            int ip_earned = (int)Math.random()*100;
            if(!blueWins){//if blue lost, purple wins, get more ip and exp.
                exp_earned+=200;
                ip_earned+=100;
            }
            
            PlayerCurrGameStats curStats = new PlayerCurrGameStats(physical_dmg, physical_hits_num, physical_miss_num, spell_cast_num, spell_dmg, kills, deaths, assists, first_hit_kills, time_played, exp_earned, ip_earned, Heros.heroesList.get(i), csCount, towersTaken);
            p.setCurrStats(curStats);
        }
    }
//==============================instance vars===================================
    private ArrayList<Player> purple_team;
    private ArrayList<Player> blue_team;
    private boolean hasEnded = false;
    private int elapsedTime =  (int)(Math.random()*(40)) + 20; //no surrender before 20
    private boolean blueWins = false;
    private int totalBlueKills = 0;
    private int totalPurpleKills = 0;
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
    public boolean hasEnded() {
        return hasEnded;
    }

    /**
     * @param hasEnded the hasEnded to set
     */
    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    /**
     * @return the elapsedTime
     */
    public int getElapsedTime() {
        return elapsedTime;
    }

    /**
     * @param elapsedTime the elapsedTime to set
     */
    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    /**
     * @return the totalBlueKills
     */
    public int getTotalBlueKills() {
        return totalBlueKills;
    }

    /**
     * @param totalBlueKills the totalBlueKills to set
     */
    public void setTotalBlueKills(int totalBlueKills) {
        this.totalBlueKills = totalBlueKills;
    }

    /**
     * @return the totalPurpleKills
     */
    public int getTotalPurpleKills() {
        return totalPurpleKills;
    }

    /**
     * @param totalPurpleKills the totalPurpleKills to set
     */
    public void setTotalPurpleKills(int totalPurpleKills) {
        this.totalPurpleKills = totalPurpleKills;
    }
}
