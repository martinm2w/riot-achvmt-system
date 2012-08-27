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
        super("Bruiser", 50);
    }
//================================public========================================    
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int currGameDmg = player.getCurrStats().getphysical_dmg();
        if(currGameDmg >= 500){
            return true;
        }
        return false;
    }
//=================================private======================================
//==============================instance vars===================================
//============================setters & getters=================================


}
