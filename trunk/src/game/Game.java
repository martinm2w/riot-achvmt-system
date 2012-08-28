package game;

import java.util.*;
import player.*;
import heroes.*;

/**
 * m2w: this class simulates the game client, the Java Platfrom passes in Game setup,
 *      and runs the client. This class shares the same Player Objects (both teams) 
 *      as the MatchProcess class, passed in when creating Game instance.
 * -----------------------------------------------------------------------------
 *      this class has 3 major methods:
 *      1. gameStart() : starts the game, generating current game stats for each player
 *          in their CurrGameStats Objects.
 *
 *      2. gameEnd(): set the game status as hasEnded.
 *      3. printGameSummary() : Prints each games summary after each game run. Similar
 *          to the actual game summary format.
 * -----------------------------------------------------------------------------
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Game {
//===============================constructor====================================
    /**
     * m2w: both team players Objects are passed in from MatchProcess when creating a
     *      new game.
     * @param blue_team
     * @param purple_team 
     */
    public Game(ArrayList<Player> blue_team, ArrayList<Player> purple_team){
        this.setBlue_team(blue_team);
        this.setPurple_team(purple_team);
    }
//================================public========================================        
    /**
     * m2w: This method simulates the game process, generate each player's behavior for end game results.
     *      This method has a few simulation features:
     *      1. won team will have more kills.
     *      2. total blue team kills will match total purple team deaths
     *      3. player will at least have 1 physical hit, for sharpshooter achievements won't be getting
     *         a divided by 0 exception.
     *      4. both team will have 11 as the max number of towers taken down, and the team winning will
     *         have at least 5 towers taken down, in order to reach the nexus.(not sure if inhibitors are 
     *          counted as towers too, assuming they're not)
     *      5. no surrender before 20 mins. at most 1:05 long.
     *      6. more random generation explanation will be included in the comment after the calculation .
     * @lastupdate: 8/27/12 9:37 PM
     */
    public void gameStart(){
        /*generate winner*/
        int winRand = (int)(Math.random()*10);
        if(winRand >= 5) setBlueWins(true);
        
        /*generate towers and kills*/
        int towersTakenBlue = 0;
        int towersTakenPurple = 0;
        if(isBlueWins()){
            //if blue team wins, given blue team 20 more kills
            setTotalBlueKills((int)(Math.random()*50)+20);
            setTotalPurpleKills((int)(Math.random()*50));
            //if blue wins will have at least 5 towers down.
            towersTakenBlue = (int)(Math.random()*6)+5;
            towersTakenPurple = (int)(Math.random()*11);
        }else{
            //else give purple team 20 more kills.
            setTotalBlueKills((int)(Math.random()*50));
            setTotalPurpleKills((int)(Math.random()*50)+20);
            
            //if purple wins will have at least 5 towers down.
            towersTakenPurple = (int)(Math.random()*6)+5;
            towersTakenBlue = (int)(Math.random()*11);
        }

        /* KDAs*/
        int blueKillsLeft = getTotalBlueKills();     //these 2 "left" vars are for assigning each players kills. substracting players kills from it each time.
        int purpleKillsLeft = getTotalPurpleKills(); //
        int blueDeathsLeft = getTotalPurpleKills();  //these 2 are for the deaths for each player.
        int purpleDeathsLeft = getTotalBlueKills();  //total blue kills should match total purple deaths.
                                                //assists will generate randomly between 0-20
        
                                               
        /*generating blue team stats*/
        this.setBlueCurrStats(blueKillsLeft, blueDeathsLeft, towersTakenBlue);
        /*generating purple team stats*/
        this.setPurpleCurrStats(purpleKillsLeft, purpleDeathsLeft, towersTakenPurple);
    }
    
    /**
     * m2w: this method sets the game status to hasEnded.
     * @lastupdate 8/27/12 9:52 PM
     */
    public void gameEnd(){
        this.setHasEnded(true);
    }
    
    /**
     * m2w: this is the 3rd step in the run game command in MatchProcess class. 
     *      This method prints out current game summaries.
     * @lastupdate 8/27/12 9:55 PM
     */
    public void printGameSummary(){
        if(this.isBlueWins()){
            System.out.println("blue team won");
        }else{
            System.out.println("purple team won");
        }
        System.out.println("blue total kills: " + this.getTotalBlueKills());
        System.out.println("purple total kills: " + this.getTotalPurpleKills());
        System.out.println("========================================================================================");
        System.out.println("Hero            ID       K\\D\\A           Items          CS count       towers \t");
        
        /*get blue's stats from their CurrGameStats Object and print them*/
        for(int i = 0; i < 5; i++){
            Player blueP = this.getBlue_team().get(i);
            String bluePgameID = blueP.getInfo().getGameID();
            String hero = blueP.getCurrStats().getHero_used().getHeroName();
            
            String killString = Integer.toString(blueP.getCurrStats().getKills());
            String deathString = Integer.toString(blueP.getCurrStats().getDeaths());
            String assistString = Integer.toString(blueP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(blueP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(blueP.getCurrStats().getTowersTaken());
                    
            System.out.print( hero + "    \t" + bluePgameID + "    \t" + kdaString + "    \t" + "items" + "    \t" + CsString + "        \t" + towersTaken + "    \t\n");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        /*get purple's stats from their CurrGameStats Object and print them*/
        for(int i = 0; i < 5; i++){
            Player PurpleP = this.getPurple_team().get(i);
            String PurplePgameID = PurpleP.getInfo().getGameID();
            String hero = PurpleP.getCurrStats().getHero_used().getHeroName();
            
            String killString = Integer.toString(PurpleP.getCurrStats().getKills());
            String deathString = Integer.toString(PurpleP.getCurrStats().getDeaths());
            String assistString = Integer.toString(PurpleP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(PurpleP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(PurpleP.getCurrStats().getTowersTaken());
                    
            //stats
            System.out.print( hero + "    \t" + PurplePgameID + "    \t" + kdaString + "    \t" + "items" + "    \t" + CsString + "        \t" + towersTaken + "    \t\n");
        }
        System.out.println("========================================================================================");
        System.out.println();
    }
    
//=================================private======================================
    private void setBlueCurrStats(int blueKillsLeft, int blueDeathsLeft, int towersTakenBlue){
        for(int i = 0; i < this.getBlue_team().size(); i ++){
            Player p = this.getBlue_team().get(i);
            
            /*dmg*/
            int physical_dmg = (int)(Math.random()*200000);
            int physical_hits_num = (int)(Math.random()*2000) + 1;              // suppose at least 1 hit
            int physical_miss_num = (int)(Math.random()*1000);                  // misses are set at most half of hits
            int spell_cast_num = (int)(Math.random()*800);                      // is set less than physical hits
            int spell_dmg = (int)(Math.random()*200000);                        // spell dmg should be related to hero's type in reality, ingored for simplicity.
            int csCount = (int)(Math.random()*400);                             // should be related to game time, omitted for simplicity here.
            
            /*KDAs*/
            int kills = (i == this.getBlue_team().size()-1) ? blueKillsLeft : (int)(Math.random()*blueKillsLeft); 
            blueKillsLeft -= kills;
            int deaths = (i == this.getBlue_team().size()-1) ? blueKillsLeft : (int)(Math.random()*blueDeathsLeft);
            blueDeathsLeft -= deaths;
            int towersTaken = (i == this.getBlue_team().size()-1) ? towersTakenBlue : (int)(Math.random()*towersTakenBlue);
            towersTakenBlue -= towersTaken;
            int assists = (int)(Math.random()*20);
            
            int first_hit_kills = (int)(Math.random()*kills); //
            int time_played = this.getElapsedTime();
            int exp_earned = (int)(Math.random()*100);
            int ip_earned = (int)(Math.random()*100);
            
            boolean won = false;
            if(isBlueWins()){//if blue wins , get more exp and ip
                exp_earned+=100;
                ip_earned+=100;
                won = true;
            }
            //create currstats object, give it to each player
            PlayerCurrGameStats curStats = new PlayerCurrGameStats(physical_dmg, physical_hits_num, physical_miss_num, spell_cast_num, spell_dmg, kills, deaths, assists, first_hit_kills, time_played, exp_earned, ip_earned, Heros.heroesList.get(i), csCount, towersTaken, won);
            p.setCurrStats(curStats);
        }
    }
    
    private void setPurpleCurrStats(int purpleKillsLeft, int purpleDeathsLeft, int towersTakenPurple){
        for(int i = 0; i < this.getPurple_team().size(); i ++){
            Player p = this.getPurple_team().get(i);
            
            /*dmg*/
            int physical_dmg = (int)(Math.random()*200000);
            int physical_hits_num = (int)(Math.random()*2000) + 1;              // suppose at least 1 hit
            int physical_miss_num = (int)(Math.random()*1000);                  // misses are set at most half of hits
            int spell_cast_num = (int)(Math.random()*800);                      // is set less than physical hits
            int spell_dmg = (int)(Math.random()*200000);                        // spell dmg should be related to hero's type in reality, ingored for simplicity.
            int csCount = (int)(Math.random()*400);                             // should be related to game time, omitted for simplicity here.
            
            /*KDAs*/
            int kills = (i == this.getPurple_team().size()-1)? purpleKillsLeft : (int)(Math.random()*purpleKillsLeft); 
            purpleKillsLeft -= kills;
            int deaths = (i == this.getPurple_team().size()-1) ? purpleDeathsLeft : (int)(Math.random()*purpleDeathsLeft);
            purpleDeathsLeft -= deaths;
            int towersTaken = (i == this.getPurple_team().size()-1) ? towersTakenPurple : (int)(Math.random()*towersTakenPurple);
            towersTakenPurple -= towersTaken;
            int assists = (int)(Math.random()*20);
            
            int first_hit_kills = (int)(Math.random()*kills); //
            int time_played = this.getElapsedTime();
            int exp_earned = (int)(Math.random()*100);
            int ip_earned = (int)(Math.random()*100);
            boolean won = false;
            if(!isBlueWins()){//if blue lost, purple wins, get more ip and exp.
                exp_earned+=100;
                ip_earned+=100;
                won = true;
            }
            //create currstats object, give it to each player
            PlayerCurrGameStats curStats = new PlayerCurrGameStats(physical_dmg, physical_hits_num, physical_miss_num, spell_cast_num, spell_dmg, kills, deaths, assists, first_hit_kills, time_played, exp_earned, ip_earned, Heros.heroesList.get(i), csCount, towersTaken, won);
            p.setCurrStats(curStats);
        }
    }
//==============================instance vars===================================
    private ArrayList<Player> purple_team;
    private ArrayList<Player> blue_team;
    private boolean hasEnded = false;
    private int elapsedTime =  (int)(Math.random()*(45)) + 20; //no surrender before 20
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

    /**
     * @return the blueWins
     */
    public boolean isBlueWins() {
        return blueWins;
    }

    /**
     * @param blueWins the blueWins to set
     */
    public void setBlueWins(boolean blueWins) {
        this.blueWins = blueWins;
    }
}
