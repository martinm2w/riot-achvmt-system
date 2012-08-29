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
    public void updatePlayerHistoryStats(PlayerCurrGameStats currStats){
        games_played += 1;
        total_time_played += currStats.getTime_played();
        total_kills += currStats.getKills();
        total_deaths += currStats.getDeaths();
        total_assists += currStats.getAssists();
        max_kills = (currStats.getKills() > max_kills) ? currStats.getKills() : max_kills;
        int currMaxDeath = (int)(Math.random()*(currStats.getDeaths()));
        max_deaths = (currMaxDeath > max_deaths) ? currMaxDeath : max_deaths;
        int currMaxDoubleKill = currStats.getKills()/2;
        double_kills = (int)(Math.random()*currMaxDoubleKill);
        int currMaxTrippleKill = currStats.getKills()/3;
        tripple_kills = (int)(Math.random()*currMaxTrippleKill);
        int currMaxQuadraKill = currStats.getKills()/4;
        quadra_kills = (int)(Math.random()*currMaxQuadraKill);
        int currMaxPentaKill = currStats.getKills()/5;
        penta_kills = (int)(Math.random()*currMaxPentaKill);
        total_towers_takedowns += currStats.getTowersTaken();
        if(currStats.hasWon()) {
            total_wins += 1;
        }else{
            total_losses += 1;
        }
        total_cs += currStats.getCsCount();
        total_physical_dmg += currStats.getphysical_dmg();
        total_spell_dmg += currStats.getspell_dmg();
        int currAveDmg = (int)(currStats.getphysical_dmg() / currStats.getPhysical_hits_num());
        largest_crit_dmg =  ( (currAveDmg*3) > largest_crit_dmg ) ? currAveDmg*3 : largest_crit_dmg;
        total_gold_earned += currStats.getCsCount()*25;
        healing_done += (int)(Math.random()*1000);
        int currMaxKillSpree = (int)(Math.random()*(currStats.getKills()));
        highest_killing_spree = (currMaxKillSpree> highest_killing_spree) ? currMaxKillSpree : highest_killing_spree;
        Integer currTimes = champions_used_times.get(currStats.getChampion_used().getChampionName());
        if(currTimes == null){
            champions_used_times.put(currStats.getChampion_used().getChampionName(), 1);
        }else{
            champions_used_times.put(currStats.getChampion_used().getChampionName(), currTimes++);
        }
        
        
    }
    
    public void clear(){
        games_played = 0;
        total_time_played = 0;

        total_kills = 0;
        total_deaths = 0;
        total_assists = 0;
        max_kills = 0;
        max_deaths = 0;
        double_kills = 0;
        tripple_kills = 0;
        quadra_kills = 0;
        penta_kills = 0;

        total_towers_takedowns = 0;
        total_wins=0;
        total_losses=0;
        total_cs=0;

        total_physical_dmg=0;
        total_spell_dmg=0;
        largest_crit_dmg=0;
        total_gold_earned=0;
        healing_done=0;

        highest_killing_spree=0;
        champions_used_times = new HashMap<String, Integer>();
    }
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
    private int total_cs=0;
    
    private int total_physical_dmg=0;
    private int total_spell_dmg=0;
    private int largest_crit_dmg=0;
    private int total_gold_earned=0;
    private int healing_done=0;
    
    private int highest_killing_spree=0;
    private HashMap<String, Integer> champions_used_times = new HashMap<String, Integer>();//omitted champion kda in the actual ranked stats tab.
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
    public int getTotal_cs() {
        return total_cs;
    }

    /**
     * @param total_monster_kills the total_monster_kills to add
     */
    public void addTotal_monster_kills(int total_monster_kills) {
        this.total_cs = total_monster_kills;
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
        return total_spell_dmg;
    }

    /**
     * @param total_magic_dmg the total_magic_dmg to add
     */
    public void addTotal_magic_dmg(int total_magic_dmg) {
        this.total_spell_dmg = total_magic_dmg;
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
     * @return the champions_used_times
     */
    public HashMap<String, Integer> getChampions_used_times() {
        return champions_used_times;
    }

    /**
     * @param champions_used_times the champions_used_times to add
     */
    public void addChampions_used_times(HashMap<String, Integer> champions_used_times) {
        this.champions_used_times = champions_used_times;
    }
}
