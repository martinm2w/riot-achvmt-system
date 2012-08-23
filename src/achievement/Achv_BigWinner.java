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
public class Achv_BigWinner extends Achievement{
//===============================constructor====================================
    public Achv_BigWinner(){
        super("Big Winner");
    }
//================================public========================================    
    @Override
    public void checkAchvCriteria(Player player) {
        if(player ==null) return;
        int totalWin = player.getHisStats().getTotal_wins();
        if(totalWin>=200){
            super.setFulfilled(true);
        }
    }

    /**
     * 
     * @param player 
     * @lastupdate 8/20/12 3:37 PM
     */
    @Override
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(super.isFulfilled()){
            player.setInfluencePoints(player.getInfluencePoints()+100);
        }
    }
//=================================private======================================
//==============================instance vars===================================
//============================setters & getters=================================
}