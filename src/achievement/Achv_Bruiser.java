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
public class Achv_Bruiser extends Achievement {
//===============================constructor====================================
    public Achv_Bruiser(){
        super("Bruiser");
    }
//================================public========================================    
//=================================private======================================
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int currGameDmg = player.getCurrStats().getphysical_dmg();
        if(currGameDmg >= 500){
            return true;
        }
        return false;
    }

    /**
     * m2w: 
     * @param player 
     * @lastupdate 8/20/12 3:38 PM
     */
    @Override
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(!this.isRewarded() && super.isFulfilled()){
            player.setInfluencePoints(player.getInfluencePoints()+300);
            this.setRewarded(true);
        }
    }
//==============================instance vars===================================
//============================setters & getters=================================


}
