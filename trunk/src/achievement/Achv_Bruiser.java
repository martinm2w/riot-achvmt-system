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
    public boolean checkAchvCriteria(PlayerHistoryStats hisStats) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rewardIfFullfilled() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//==============================instance vars===================================
//============================setters & getters=================================


}
