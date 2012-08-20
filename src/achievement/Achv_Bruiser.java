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
    public void checkAchvCriteria(Player player) {
        if(player ==null) return;
        int currGameDmg = player.getCurrStats().getphysical_dmg();
        if(currGameDmg >= 500){
            super.setFulfilled(true);
        }
    }

    /**
     * m2w: 
     * @param player 
     * @lastupdate 8/20/12 3:38 PM
     */
    @Override
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(super.isFulfilled()){
            player.setInfluencePoints(player.getInfluencePoints()+300);
        }
    }
//==============================instance vars===================================
//============================setters & getters=================================


}
