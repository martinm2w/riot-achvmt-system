/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package process;

import game.*;
import java.util.*;
import player.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class MatchProcess {
//===============================constructor====================================
//==================================public======================================
    public static void main(String[] args){
        MatchProcess mp = new MatchProcess();
        ArrayList<Player> blue_team = mp.createBlueTeam();
        ArrayList<Player> purple_team = mp.createPurpleTeam();
        Game game = new Game(purple_team, blue_team);
        game.gameStart();
        game.gameEnd();
        System.out.println(blue_team.get(0).getInfo().getGameID());
        System.out.println(blue_team.get(0).getCurrStats().getCsCount());
        if(game.hasEnded()){
            mp.printGameSummary(game);
        }
    }
//=================================private======================================
    /**
     * m2w : this is just making the class tidy. wrapper method of creating blue
     * @return the list of blue team players
     * @lastupdate 8/22/12 9:54 PM
     */
    private ArrayList<Player> createBlueTeam(){
        ArrayList<Player> blue_team = new ArrayList<Player>();
        for(int i = 1; i <=5; i++){
            PlayerInfo info = new PlayerInfo("blue"+i+"FN", "blue"+i+"LN", "blue"+i+"Email", "blue"+i+"ID", "blue"+i+"PW" , "blue"+i+"gameID");
            Player player = new Player(info);
            blue_team.add(player);
        }
        return blue_team;
    }
    
    /**
     * m2w : this is just making the class tidy. wrapper method of creating purple
     * @return the list of purple team player.
     * @lastupdate 8/22/12 9:54 PM
     */
    private ArrayList<Player> createPurpleTeam(){
        ArrayList<Player> purple_team = new ArrayList<Player>();
        for(int i = 1; i <=5; i++){
            PlayerInfo info = new PlayerInfo("purple"+i+"FN", "purple"+i+"LN", "purple"+i+"Email", "purple"+i+"ID", "purple"+i+"PW" , "purple"+i+"gameID");
            Player player = new Player(info);
            purple_team.add(player);
        }
        return purple_team;
    }
    
    private void printGameSummary(Game game){
        
        
        
        System.out.println("========================================================================================");
        System.out.println("\t SummonerID \t K\\D\\A \t Items \t CS count \t towers taken\t");
        for(int i = 0; i < 5; i++){
            Player blueP = game.getBlue_team().get(i);
            //info
            String bluePgameID = blueP.getInfo().getGameID();
            
            String killString = Integer.toString(blueP.getCurrStats().getKills());
            String deathString = Integer.toString(blueP.getCurrStats().getDeaths());
            String assistString = Integer.toString(blueP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(blueP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(blueP.getCurrStats().getTowersTaken());
                    
            //stats
            System.out.print("\t" + bluePgameID + "\t" + kdaString + "\t" + "my items..." + "\t" + CsString + "\t" + towersTaken + "\t\n");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        for(int i = 0; i < 5; i++){
            Player PurpleP = game.getPurple_team().get(i);
            //info
            String PurplePgameID = PurpleP.getInfo().getGameID();
            
            String killString = Integer.toString(PurpleP.getCurrStats().getKills());
            String deathString = Integer.toString(PurpleP.getCurrStats().getDeaths());
            String assistString = Integer.toString(PurpleP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(PurpleP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(PurpleP.getCurrStats().getTowersTaken());
                    
            //stats
            System.out.print("\t" + PurplePgameID + "\t" + kdaString + "\t" + "my items..." + "\t" + CsString + "\t" + towersTaken + "\t\n");
        }
        System.out.println("========================================================================================");
    }
//==============================instance vars===================================
//============================setters & getters=================================
}
