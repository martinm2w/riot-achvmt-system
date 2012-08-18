/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import util.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public class Player {
//===============================constructor====================================
    public Player(PlayerInfo info){
        this.setInfo(info);
        hisStats = new HistoryStats();
    }
//==================================utils=======================================
//==============================instance vars===================================
    private PlayerInfo info;
    private HistoryStats hisStats;
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
