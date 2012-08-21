/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package heroes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class Hero {
//===============================constructor====================================
    public Hero(String heroName){
        this.setHeroName(heroName);
    }
//==================================public======================================
//=================================private======================================
//==============================instance vars===================================
    private String heroName;
    private String lore = "some lore of " + heroName;
    private String tipsAndItems = "use me wisely";
    private ArrayList<Ability> abilities;//omitted for simplicity
    private BufferedImage art;//omitted for simplicity
    private BufferedImage portait;//omitted for simplicity
//============================setters & getters=================================

    /**
     * @return the heroName
     */
    public String getHeroName() {
        return heroName;
    }

    /**
     * @param heroName the heroName to set
     */
    public void setHeroName(String heroName) {
        this.heroName = heroName;
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

    /**
     * @return the abilities
     */
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    /**
     * @param abilities the abilities to set
     */
    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

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
