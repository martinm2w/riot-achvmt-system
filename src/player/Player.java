/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import Champion.*;
import achievement.*;
import java.util.*;

/**
 * m2w: this class is used to create each player's Objects, with different player
 *      info, its current stats and history stats are empty while the new player
 *      instance is created.
 *      ------------------------------------------------------------------------
 *      It contains several instance vars:
 *      1. player's IP, RP, EXP, and Level, etc, these game related info are saved
 *          for each player.
 *      2. PlayerInfo object: this was passed in while creating the Player Objects,
 *          which contains information about the player, like names, IDs, etc.
 *      3. Player's PlayerCurrGameStats Object, containing generated info for the 
 *          game just finished.
 *      4. Player's PlayerHistoryStats, containing history stats of the player, such
 *          as total kills and total deaths.
 *      5. An AchievementsHandler Object, contains all achievement info for the player,
 *          and handles the update, check, and reward on the achievements.
 *          
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Player {
//===============================constructor====================================
    /**
     * m2w: pass in a PlayerInfo to create player object, history and Achv_handlers 
     *      are new, current game stats is null at this point, after a match it will
     *      be assigned.
     * @param info 
     */
    public Player(PlayerInfo info){
        this.setInfo(info);
        hisStats = new PlayerHistoryStats();
        Achv_handler = new AchievementsHandler();
    }
//================================public========================================
    /**
     * m2w: this method update player's exp and Ip after each game, if current exp
     *      exceeds next_level_exp(required exp for leveling up) then will level up,
     *      then next required level up EXP will increase.
     *      total exp earned is omitted for simplicity.
     */
    public void updatePlayerIPandExp(){
        curr_level_exp += currStats.getExp_earned(); //adding current game earned exp
        if(curr_level_exp > next_level_exp){        // if curr exp is enough for leveling up.
            level ++;                               // increase level, 
            curr_level_exp -= next_level_exp;       // last level earned exp was subtracted.
            next_level_exp += level*500;            // requirment increase after level up.
        }
        //ip
        influencePoints += currStats.getIp_earned(); // increased ip after the game.
    }
    
    /**
     * m2w: this is the "stats(gameID)" command that was called in MatchProcess class, prints player info,
     *      player last game stats, history stats.
     */
    public void printPlayerInfoAndStats(){
        System.out.println("========================================================================================");
        System.out.println("Player game ID[" + this.getInfo().getGameID() + "],            Current level[" + this.getLevel() + "],            Current IP[" + this.getInfluencePoints() + "],            RP[" + this.getRiotPoints() + "].");
        System.out.println();
        System.out.println("-------------- Player Info ----------------");
        System.out.println("First Name[" + info.getFirstName() + "],            Last Name[" + info.getLastName() + "]");
        System.out.println("Game ID[" + info.getGameID() + "],              \t Login ID[" + info.getLoginID() + "],      \t Email[" + info.getEmail()+"]");
        System.out.println();
        if(currStats != null) {
            System.out.println("------------ Last game Stats --------------");
            System.out.println("Champion[" + currStats.getChampion_used().getChampionName() + "],           \tGame Time: [" + currStats.getTime_played() + "]          \tCS Count[" + currStats.getCs_Count() + "],");
            System.out.println("Kills[" + currStats.getKills() + "],                \tDeaths[" + currStats.getDeaths() + "],               \tAssists[" + currStats.getAssists() + "],              \tFirstHitKills[" +currStats.getFirst_hit_kills()+ "]" );
            System.out.println("Physical Dmg[" +currStats.getphysical_dmg()+ "],      \tPhysical Hits["+ currStats.getPhysical_hits_num() +"],       \tPhysical Misses["+currStats.getPhysical_miss_num()+"]");
            System.out.println("Spell Dmg[" + currStats.getspell_dmg() + "],            \tSpell Casts["+ currStats.getSpell_cast_num() + "],            \tTowers Taken[" + currStats.getTowers_taken() + "]");
            System.out.println("Exp Earned["+ currStats.getExp_earned() + "],            \tGame IP Earned[" + currStats.getIp_earned() + "]");
            System.out.println();
        }else{
            System.out.println("------------ Last game Stats --------------");
            System.out.println("### No Last Game Stats Found, Play a Game First! ###");
            System.out.println();
        }
        System.out.println("------------- History Stats --------------");
        System.out.println("Games Played[" + hisStats.getGames_played() + "],          \tTotal Game Time: [" + hisStats.getTotal_time_played() + "],      \tTotal Wins[" + hisStats.getTotal_wins() + "],");
        System.out.println("Total losses[" + hisStats.getTotal_losses() + "],          \tTotal CS: [" + hisStats.getTotal_cs() + "],          \tTotal Gold Earned[" +hisStats.getTotal_gold_earned()+ "]");
        System.out.println("Total Kills[" + hisStats.getTotal_kills() + "],            \tTotal Deaths[" + hisStats.getTotal_deaths() + "],            \tTotal Assists[" + hisStats.getTotal_assists()+ "]");
        System.out.println("Max Kills[" + hisStats.getMax_kills() + "],            \tMax Deaths[" + hisStats.getMax_deaths() + "],            \tDouble Kills[" + hisStats.getDouble_kills()+ "]");
        System.out.println("Double Kills[" + hisStats.getDouble_kills() + "],          \tTripple Kills[" + hisStats.getTripple_kills() + "],           \tQuadra Kills[" + hisStats.getQuadra_kills()+ "]");
        System.out.println("Penta Kills[" + hisStats.getPenta_kills() + "],          \tTotal Towers[" + hisStats.getTotal_towers_takedowns() + "],          \tQuadra Kills[" + hisStats.getQuadra_kills()+ "]");
        System.out.println("Total Physical dmg[" + hisStats.getTotal_physical_dmg() + "],\tLargest Crit Dmg [" + hisStats.getLargest_crit_dmg() + "],     \tHealing Done[" + hisStats.getHealing_done()+ "]");
        System.out.println("========================================================================================");
        System.out.println();
    }
//=================================private======================================
//==============================instance vars===================================
    private PlayerInfo info;                    //player info, first name , last name , email, etc.
    private PlayerHistoryStats hisStats;        //player histroy info, total kills, total games, total times,  etc.
    private PlayerCurrGameStats currStats;      //player current/last game stats, kills, dmg, hits, towers, etc.
    private AchievementsHandler Achv_handler;   //player's achievements, are they rewarded, are they fulfilled, etc.
    
    private int level = 1;                      //player's level, starting at 1.
    private int curr_level_exp = 0;             //player's current level earned exp, starting at 0
    //need to change this                   
    private int next_level_exp = 480;           //exp required for level up.
    private int riotPoints;                     //player's riot points.
    private int influencePoints;                //player's influence points.
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
