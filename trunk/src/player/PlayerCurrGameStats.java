/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import heroes.Hero;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class PlayerCurrGameStats {
//===============================constructor====================================
    public PlayerCurrGameStats(){

    }
//================================public========================================    
//=================================private======================================
    /**
     * m2w: the current game stats should be passed to the java platform system to update the user profile/stats.
     * @param physical_dmg
     * @param physical_hits_num
     * @param spell_cast_num
     * @param spell_dmg
     * @param kills
     * @param assists
     * @param first_hit_kills
     * @param time_played 
     * @lasteupdate 8/17/12 10:29 PM
     */
    public void updatePlayerCurrGameStats(int physical_dmg, int physical_hits_num, int physical_miss_num, int spell_cast_num, int spell_dmg, int kills, int assists, int first_hit_kills, int time_played, int exp_earned, int ip_earned, Hero hero_used){
        this.setAssists(assists);
        this.setFirst_hit_kills(first_hit_kills);
        this.setKills(kills);
        this.setphysical_dmg(physical_dmg);
        this.setPhysical_hits_num(physical_hits_num);
        this.setPhysical_miss_num(physical_miss_num);
        this.setSpell_cast_num(spell_cast_num);
        this.setspell_dmg(spell_dmg);
        this.setTime_played(time_played);
        this.setExp_earned(exp_earned);
        this.setHero_used(hero_used);
        this.setIp_earned(ip_earned);
    }
    
//==============================instance vars===================================
    private Hero hero_used; //simulating the real game that you can see hero's portaits in the match result (can use HeroObj.getHeroProtrait()).
    private int physical_dmg;
    private int physical_hits_num;
    private int physical_miss_num;
    private int spell_cast_num;
    private int spell_dmg;
    
    private int kills;
    private int assists;
    private int first_hit_kills;
    
    private int time_played;
    private int exp_earned;
    private int ip_earned;
    
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
     * @return the hero_used
     */
    public Hero getHero_used() {
        return hero_used;
    }

    /**
     * @param hero_used the hero_used to set
     */
    public void setHero_used(Hero hero_used) {
        this.hero_used = hero_used;
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
}