/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player;

import achievement.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Player {
//===============================constructor====================================
    public Player(PlayerInfo info){
        this.setInfo(info);
        hisStats = new PlayerHistoryStats();
        Achv_handler = new Achievements_handler();
    }
//================================public========================================
    
//=================================private======================================
    private void checkAchvAfterGame(){
        this.Achv_handler.updateAchvmntsStats(hisStats);
        this.Achv_handler.checkFulfilledAchvmnts();
    }
//==============================instance vars===================================
    private PlayerInfo info;
    private PlayerHistoryStats hisStats;
    private Achievements_handler Achv_handler;
//============================setters & getters=================================

    /**
     * @return the info
     */
    public PlayerInfo getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(PlayerInfo info) {
        this.info = info;
    }
}
