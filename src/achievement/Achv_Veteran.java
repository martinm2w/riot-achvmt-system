/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package achievement;

import player.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class Achv_Veteran extends Achievement {
//===============================constructor====================================
    public Achv_Veteran(){
        super("Veteran", 200);
    }
//================================public========================================    
//=================================private======================================
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player == null) return false;
        int gamesPlayed = player.getHisStats().getGames_played();
        if(gamesPlayed >= 1000){
            return true;
        }
        return false;
    }
//==============================instance vars===================================
//============================setters & getters=================================
}
