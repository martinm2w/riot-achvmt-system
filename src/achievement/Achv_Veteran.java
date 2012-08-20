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
    public void checkAchvCriteria(Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rewardIfFullfilled(Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//==============================instance vars===================================
//============================setters & getters=================================
}
