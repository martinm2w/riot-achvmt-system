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
    public boolean checkAchvCriteria(PlayerHistoryStats hisStats) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rewardIfFullfilled() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//===============================constructor====================================
//================================public========================================    
//=================================private======================================
//==============================instance vars===================================
//============================setters & getters=================================
}
