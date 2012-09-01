/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import Champion.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * m2w: This class contains all stats for the current/last game. Every Player instance
 *      have-a PlayerCurrGameStats Object. The object was passed to each player after 
 *      each run of the game.
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class PlayerCurrGameStats {
//===============================constructor====================================
    /**
     * m2w: the current game stats should be passed to the java platform to update the user's stats.
     * @param physical_dmg
     * @param physical_hits_num
     * @param physical_miss_num
     * @param spell_cast_num
     * @param spell_dmg
     * @param kills
     * @param deaths
     * @param assists
     * @param first_hit_kills
     * @param time_played
     * @param exp_earned
     * @param ip_earned
     * @param champion_used
     * @param csCount
     * @param towersTaken
     * @param won 
     * @lastupdate 8/26/12 10:46 AM
     */
    public PlayerCurrGameStats(HashMap<String, Object> currStatsMap){
        this.setAssists((int)currStatsMap.get("assists"));
        this.setFirst_hit_kills((int)currStatsMap.get("first_hit_kills"));
        this.setKills((int)currStatsMap.get("kills"));
        this.setDeaths((int)currStatsMap.get("deaths"));
        this.setphysical_dmg((int)currStatsMap.get("physical_dmg"));
        this.setPhysical_hits_num((int)currStatsMap.get("physical_hits_num"));
        this.setPhysical_miss_num((int)currStatsMap.get("physical_miss_num"));
        this.setSpell_cast_num((int)currStatsMap.get("spell_cast_num"));
        this.setspell_dmg((int)currStatsMap.get("spell_dmg"));
        this.setTime_played((int)currStatsMap.get("time_played"));
        this.setExp_earned((int)currStatsMap.get("exp_earned"));
        this.setChampion_used((Champion)currStatsMap.get("champion_used"));
        this.setIp_earned((int)currStatsMap.get("ip_earned"));
        this.setCs_Count((int)currStatsMap.get("cs_count"));
        this.setTowers_taken((int)currStatsMap.get("towers_taken"));
        this.setWon((boolean)currStatsMap.get("won"));
    }
//================================public========================================    
//=================================private======================================
//==============================instance vars===================================
    private Champion champion_used; //simulating the real game that you can see champion's portaits in the match result (can use ChampionObj.getChampionProtrait()).
    private int physical_dmg;       
    private int physical_hits_num;
    private int physical_miss_num;
    private int spell_cast_num;
    private int spell_dmg;
    
    private int kills;
    private int deaths;
    private int assists;
    private int first_hit_kills;
    private int cs_count;            //monster+minion kills
    private int towers_taken;
    
    private int time_played;
    private int exp_earned;
    private int ip_earned;
    
    private boolean won = false;
    //    private ArrayList<SommonerSpell> sSpells; //omitted for simplicity
//============================setters & getters=================================

    /**
     * @return the physical_dmg
     */
    public int getphysical_dmg() {
        return physical_dmg;
    }

    /**
     * @param physical_dmg the physical_dmg to set
     */
    public void setphysical_dmg(int physical_dmg) {
        this.physical_dmg = physical_dmg;
    }

    /**
     * @return the physical_hits_num
     */
    public int getPhysical_hits_num() {
        return physical_hits_num;
    }

    /**
     * @param physical_hits_num the physical_hits_num to set
     */
    public void setPhysical_hits_num(int physical_hits_num) {
        this.physical_hits_num = physical_hits_num;
    }

    /**
     * @return the spell_cast_num
     */
    public int getSpell_cast_num() {
        return spell_cast_num;
    }

    /**
     * @param spell_cast_num the spell_cast_num to set
     */
    public void setSpell_cast_num(int spell_cast_num) {
        this.spell_cast_num = spell_cast_num;
    }

    /**
     * @return the spell_dmg
     */
    public int getspell_dmg() {
        return spell_dmg;
    }

    /**
     * @param spell_dmg the spell_dmg to set
     */
    public void setspell_dmg(int spell_dmg) {
        this.spell_dmg = spell_dmg;
    }

    /**
     * @return the kills
     */
    public int getKills() {
        return kills;
    }

    /**
     * @param kills the kills to set
     */
    public void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @param assists the assists to set
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * @return the first_hit_kills
     */
    public int getFirst_hit_kills() {
        return first_hit_kills;
    }

    /**
     * @param first_hit_kills the first_hit_kills to set
     */
    public void setFirst_hit_kills(int first_hit_kills) {
        this.first_hit_kills = first_hit_kills;
    }

    /**
     * @return the time_played
     */
    public int getTime_played() {
        return time_played;
    }

    /**
     * @param time_played the time_played to set
     */
    public void setTime_played(int time_played) {
        this.time_played = time_played;
    }

    /**
     * @return the champion_used
     */
    public Champion getChampion_used() {
        return champion_used;
    }

    /**
     * @param champion_used the champion_used to set
     */
    public void setChampion_used(Champion champion_used) {
        this.champion_used = champion_used;
    }

    /**
     * @return the exp_earned
     */
    public int getExp_earned() {
        return exp_earned;
    }

    /**
     * @param exp_earned the exp_earned to set
     */
    public void setExp_earned(int exp_earned) {
        this.exp_earned = exp_earned;
    }

    /**
     * @return the ip_earned
     */
    public int getIp_earned() {
        return ip_earned;
    }

    /**
     * @param ip_earned the ip_earned to set
     */
    public void setIp_earned(int ip_earned) {
        this.ip_earned = ip_earned;
    }

    /**
     * @return the physical_miss_num
     */
    public int getPhysical_miss_num() {
        return physical_miss_num;
    }

    /**
     * @param physical_miss_num the physical_miss_num to set
     */
    public void setPhysical_miss_num(int physical_miss_num) {
        this.physical_miss_num = physical_miss_num;
    }

    /**
     * @return the deaths
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * @param deaths the deaths to set
     */
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    /**
     * @return the csCount
     */
    public int getCs_Count() {
        return cs_count;
    }

    /**
     * @param csCount the csCount to set
     */
    public void setCs_Count(int csCount) {
        this.cs_count = csCount;
    }

    /**
     * @return the towersTaken
     */
    public int getTowers_taken() {
        return towers_taken;
    }

    /**
     * @param towersTaken the towersTaken to set
     */
    public void setTowers_taken(int towersTaken) {
        this.towers_taken = towersTaken;
    }

    /**
     * @return the won
     */
    public boolean hasWon() {
        return won;
    }

    /**
     * @param won the won to set
     */
    public void setWon(boolean won) {
        this.won = won;
    }
}
