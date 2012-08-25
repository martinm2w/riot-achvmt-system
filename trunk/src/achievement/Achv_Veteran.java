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
        super("Veteran");
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

    /**
     * m2w: 
     * @param player current player
     * @lastupdate 8/20/12 3:37 PM
     */
    @Override
    public void rewardIfFullfilled(Player player) {
        if(player == null) return;
        if(!this.isRewarded() && super.isFulfilled()){
            player.setInfluencePoints(player.getInfluencePoints()+200);
            this.setRewarded(true);
        }
    }
//==============================instance vars===================================
//============================setters & getters=================================
}
