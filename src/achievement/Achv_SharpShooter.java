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
public class Achv_SharpShooter extends Achievement {
    
    public Achv_SharpShooter(){
        super("SharpShooter");
    }

    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int totalHit = player.getCurrStats().getPhysical_hits_num();
        int totalMiss = player.getCurrStats().getPhysical_miss_num();
        double accuracy = (double)totalHit / (double)(totalHit+totalMiss);
        if(accuracy >= 0.75){
            return true;
        }
        return false;
    }

    /**
     * m2w: reward 50 ip if fulfilled sharpshooter
     * @param player 
     * @lastupdate 8/20/12 3:37 PM
     */
    @Override
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(!this.isRewarded() && super.isFulfilled()){
            player.setInfluencePoints(player.getInfluencePoints() + 50);
            this.setRewarded(true);
        }
    }
//===============================constructor====================================
//================================public========================================    
//=================================private======================================
//==============================instance vars===================================
//============================setters & getters=================================
}
