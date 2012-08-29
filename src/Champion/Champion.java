/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Champion;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * m2w: this is the Champion class created for game simulation, in the Java platform,
 *      there only needs to be introduction, information about the champion, the game client
 *      has the real "what does this champion dance look like" programmed.
 *      For simplicity, this class contains a few info on the champion such as names 
 *      and lores and arts etc.
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class Champion {
//===============================constructor====================================
    /**
     * m2w: in this program you only need to pass in a champion's name to create the champion.
     * @param championName 
     */
    public Champion(String championName){
        this.setChampionName(championName);
    }
//==================================public======================================
//=================================private======================================
//==============================instance vars===================================
    private String championName;
    private String lore = "some lore of " + championName;
    private String tipsAndItems = "use me wisely";
//    private ArrayList<Ability> abilities;//omitted for simplicity
    private BufferedImage art;//held empty for simplicity
    private BufferedImage portait;//held empty for simplicity
//============================setters & getters=================================
    /**
     * @return the championName
     */
    public String getChampionName() {
        return championName;
    }

    /**
     * @param championName the championName to set
     */
    public void setChampionName(String championName) {
        this.championName = championName;
    }

    /**
     * @return the lore
     */
    public String getLore() {
        return lore;
    }

    /**
     * @param lore the lore to set
     */
    public void setLore(String lore) {
        this.lore = lore;
    }

    /**
     * @return the tipsAndItems
     */
    public String getTipsAndItems() {
        return tipsAndItems;
    }

    /**
     * @param tipsAndItems the tipsAndItems to set
     */
    public void setTipsAndItems(String tipsAndItems) {
        this.tipsAndItems = tipsAndItems;
    }

//    /**
//     * @return the abilities
//     */
//    public ArrayList<Ability> getAbilities() {
//        return abilities;
//    }
//
//    /**
//     * @param abilities the abilities to set
//     */
//    public void setAbilities(ArrayList<Ability> abilities) {
//        this.abilities = abilities;
//    }

    /**
     * @return the art
     */
    public BufferedImage getArt() {
        return art;
    }

    /**
     * @param art the art to set
     */
    public void setArt(BufferedImage art) {
        this.art = art;
    }

    /**
     * @return the portait
     */
    public BufferedImage getPortait() {
        return portait;
    }

    /**
     * @param portait the portait to set
     */
    public void setPortait(BufferedImage portait) {
        this.portait = portait;
    }
}
