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
        super("Big Winner", 300);
    }
//================================public========================================    
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int totalWin = player.getHisStats().getTotal_wins();
        if(totalWin>=200){
            return true;
        }
        return false;
    }
//=================================private======================================
//==============================instance vars===================================
//============================setters & getters=================================
}