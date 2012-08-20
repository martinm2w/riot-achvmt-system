/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import achievement.*;
import java.util.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class PlayerHistoryStats {
//===============================constructor====================================
    public PlayerHistoryStats(){
        
    }
//================================public========================================        
//=================================private======================================
//==============================instance vars===================================
    //for simplisity all instance vars are initialized by value;
    private int games_played = 0;
    private int total_time_played = 0;
    
    private int total_kills = 0;
    private int total_deaths = 0;
    private int total_assists = 0;
    private int max_kills = 0;
    private int max_deaths = 0;
    private int double_kills = 0;
    private int tripple_kills = 0;
    private int quadra_kills = 0;
    private int penta_kills = 0;
    
    private int total_towers_takedowns = 0;
    private int total_wins=0;
    private int total_losses=0;
    private int total_monster_kills=0;
    private int total_minion_kills=0;
    
    private int total_physical_dmg=0;
    private int total_magic_dmg=0;
    private int largest_crit_dmg=0;
    private int total_gold_earned=0;
    private int healing_done=0;
    
    private int highest_killing_spree=0;
    private HashMap<String, Integer> heros_used_times = new  HashMap<String, Integer>();//omitted hero kda in the actual ranked stats tab.
//============================setters & getters=================================

    /**
     * @return the games_played
     */
    public int getGames_played() {
        return games_played;
    }

    /**
     * @param games_played the games_played to add
     */
    public void addGames_played(int games_played) {
        this.games_played = games_played;
    }

    /**
     * @return the total_time_played
     */
    public int getTotal_time_played() {
        return total_time_played;
    }

    /**
     * @param total_time_played the total_time_played to add
     */
    public void addTotal_time_played(int total_time_played) {
        this.total_time_played = total_time_played;
    }

    /**
     * @return the total_kills
     */
    public int getTotal_kills() {
        return total_kills;
    }

    /**
     * @param total_kills the total_kills to add
     */
    public void addTotal_kills(int total_kills) {
        this.total_kills = total_kills;
    }

    /**
     * @return the total_deaths
     */
    public int getTotal_deaths() {
        return total_deaths;
    }

    /**
     * @param total_deaths the total_deaths to add
     */
    public void addTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    /**
     * @return the total_assists
     */
    public int getTotal_assists() {
        return total_assists;
    }

    /**
     * @param total_assists the total_assists to add
     */
    public void addTotal_assists(int total_assists) {
        this.total_assists = total_assists;
    }

    /**
     * @return the max_kills
     */
    public int getMax_kills() {
        return max_kills;
    }

    /**
     * @param max_kills the max_kills to add
     */
    public void addMax_kills(int max_kills) {
        this.max_kills = max_kills;
    }

    /**
     * @return the max_deaths
     */
    public int getMax_deaths() {
        return max_deaths;
    }

    /**
     * @param max_deaths the max_deaths to add
     */
    public void addMax_deaths(int max_deaths) {
        this.max_deaths = max_deaths;
    }

    /**
     * @return the double_kills
     */
    public int getDouble_kills() {
        return double_kills;
    }

    /**
     * @param double_kills the double_kills to add
     */
    public void addDouble_kills(int double_kills) {
        this.double_kills = double_kills;
    }

    /**
     * @return the tripple_kills
     */
    public int getTripple_kills() {
        return tripple_kills;
    }

    /**
     * @param tripple_kills the tripple_kills to add
     */
    public void addTripple_kills(int tripple_kills) {
        this.tripple_kills = tripple_kills;
    }

    /**
     * @return the quadra_kills
     */
    public int getQuadra_kills() {
        return quadra_kills;
    }

    /**
     * @param quadra_kills the quadra_kills to add
     */
    public void addQuadra_kills(int quadra_kills) {
        this.quadra_kills = quadra_kills;
    }

    /**
     * @return the penta_kills
     */
    public int getPenta_kills() {
        return penta_kills;
    }

    /**
     * @param penta_kills the penta_kills to add
     */
    public void addPenta_kills(int penta_kills) {
        this.penta_kills = penta_kills;
    }

    /**
     * @return the total_towers_takedowns
     */
    public int getTotal_towers_takedowns() {
        return total_towers_takedowns;
    }

    /**
     * @param total_towers_takedowns the total_towers_takedowns to add
     */
    public void addTotal_towers_takedowns(int total_towers_takedowns) {
        this.total_towers_takedowns = total_towers_takedowns;
    }

    /**
     * @return the total_wins
     */
    public int getTotal_wins() {
        return total_wins;
    }

    /**
     * @param total_wins the total_wins to add
     */
    public void addTotal_wins(int total_wins) {
        this.total_wins = total_wins;
    }

    /**
     * @return the total_losses
     */
    public int getTotal_losses() {
        return total_losses;
    }

    /**
     * @param total_losses the total_losses to add
     */
    public void addTotal_losses(int total_losses) {
        this.total_losses = total_losses;
    }

    /**
     * @return the total_monster_kills
     */
    public int getTotal_monster_kills() {
        return total_monster_kills;
    }

    /**
     * @param total_monster_kills the total_monster_kills to add
     */
    public void addTotal_monster_kills(int total_monster_kills) {
        this.total_monster_kills = total_monster_kills;
    }

    /**
     * @return the total_minion_kills
     */
    public int getTotal_minion_kills() {
        return total_minion_kills;
    }

    /**
     * @param total_minion_kills the total_minion_kills to add
     */
    public void addTotal_minion_kills(int total_minion_kills) {
        this.total_minion_kills = total_minion_kills;
    }

    /**
     * @return the total_physical_dmg
     */
    public int getTotal_physical_dmg() {
        return total_physical_dmg;
    }

    /**
     * @param total_physical_dmg the total_physical_dmg to add
     */
    public void addTotal_physical_dmg(int total_physical_dmg) {
        this.total_physical_dmg = total_physical_dmg;
    }

    /**
     * @return the total_magic_dmg
     */
    public int getTotal_magic_dmg() {
        return total_magic_dmg;
    }

    /**
     * @param total_magic_dmg the total_magic_dmg to add
     */
    public void addTotal_magic_dmg(int total_magic_dmg) {
        this.total_magic_dmg = total_magic_dmg;
    }

    /**
     * @return the largest_crit_dmg
     */
    public int getLargest_crit_dmg() {
        return largest_crit_dmg;
    }

    /**
     * @param largest_crit_dmg the largest_crit_dmg to add
     */
    public void addLargest_crit_dmg(int largest_crit_dmg) {
        this.largest_crit_dmg = largest_crit_dmg;
    }

    /**
     * @return the total_gold_earned
     */
    public int getTotal_gold_earned() {
        return total_gold_earned;
    }

    /**
     * @param total_gold_earned the total_gold_earned to add
     */
    public void addTotal_gold_earned(int total_gold_earned) {
        this.total_gold_earned = total_gold_earned;
    }

    /**
     * @return the healing_done
     */
    public int getHealing_done() {
        return healing_done;
    }

    /**
     * @param healing_done the healing_done to add
     */
    public void addHealing_done(int healing_done) {
        this.healing_done = healing_done;
    }

    /**
     * @return the highest_killing_spree
     */
    public int getHighest_killing_spree() {
        return highest_killing_spree;
    }

    /**
     * @param highest_killing_spree the highest_killing_spree to add
     */
    public void addHighest_killing_spree(int highest_killing_spree) {
        this.highest_killing_spree = highest_killing_spree;
    }

    /**
     * @return the heros_used_times
     */
    public HashMap<String, Integer> getHeros_used_times() {
        return heros_used_times;
    }

    /**
     * @param heros_used_times the heros_used_times to add
     */
    public void addHeros_used_times(HashMap<String, Integer> heros_used_times) {
        this.heros_used_times = heros_used_times;
    }
}
