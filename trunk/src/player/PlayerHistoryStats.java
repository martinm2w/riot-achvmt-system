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
//================================public========================================        
//=================================private======================================
//==============================instance vars===================================
 
    private int games_played;
    private int total_time_played;
    
    private int total_kills;
    private int total_deaths;
    private int total_assists;
    private int max_kills;
    private int max_deaths;
    private int double_kills;
    private int tripple_kills;
    private int quadra_kills;
    private int penta_kills;
    
    private int total_towers_takedowns;
    private int total_wins;
    private int total_losses;
    private int total_monster_kills;
    private int total_minion_kills;
    
    private int total_physical_dmg;
    private int total_magic_dmg;
    private int largest_crit_dmg;
    private int total_gold_earned;
    private int healing_done;
    
    private int highest_killing_spree;
    private HashMap<String, Integer> heros_used_times;//omitted hero kda in the actual ranked stats tab.
//============================setters & getters=================================
}
