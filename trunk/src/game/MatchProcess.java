/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import game.*;
import java.io.*;
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
        InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        MatchProcess mp = new MatchProcess();
        boolean endProcess = false;
            System.out.println("Welcome To m2w's LOL simulation program");
            try {
                while(endProcess != true){
                    System.out.println("Please enter how many games want to play: (if you wish to end the process plz enter \"end\"");
                    String gameCount = bufRead.readLine();

                    int gameCountint = Integer.parseInt(gameCount);
                    for(int i = 0; i < gameCountint; i++){
                    System.out.println("+++Game " + (i+1) + " +++");
                    mp.oneMatch();
                    //after match should print each players achievements if earned.
                    }
                }
               System.out.println("Please enter which player(ID)'s stats you wish to examine: ");
               String playerGameID = bufRead.readLine();
               //get which player, and prints its stats
          }
          catch (IOException err) {
               System.out.println("Error reading line");
          }
          catch(NumberFormatException err) {
               System.out.println("Error Converting Number");
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
            PlayerInfo info = new PlayerInfo("blue"+i+"FN", "blue"+i+"LN", "blue"+i+"Email", "blue"+i+"ID", "blue"+i+"PW" , "b"+i+"");
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
            PlayerInfo info = new PlayerInfo("purple"+i+"FN", "purple"+i+"LN", "purple"+i+"Email", "purple"+i+"ID", "purple"+i+"PW" , "p"+i+"");
            Player player = new Player(info);
            purple_team.add(player);
        }
        return purple_team;
    }
    
    private void printGameSummary(Game game){
        if(game.isBlueWins()){
            System.out.println("blue team won");
        }else{
            System.out.println("purple team won");
        }
        System.out.println("blue total kills: " + game.getTotalBlueKills());
        System.out.println("purple total kills: " + game.getTotalPurpleKills());
        System.out.println("========================================================================================");
        System.out.println("ID      K\\D\\A     Items     CS count    towers \t");
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
            System.out.print("" + bluePgameID + "\t" + kdaString + "\t" + "my items" + "\t" + CsString + "\t" + towersTaken + " \t\n");
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
            System.out.print("" + PurplePgameID + "\t" + kdaString + "\t" + "my items" + "\t" + CsString + "\t" + towersTaken + " \t\n");
        }
        System.out.println("========================================================================================");
        System.out.println();
    }
    
    private void calAndPrintAchievements(Game game){
        
    }
    
    private void oneMatch(){
        ArrayList<Player> blue_team = this.createBlueTeam();
        ArrayList<Player> purple_team = this.createPurpleTeam();
        Game game = new Game(purple_team, blue_team);
        game.gameStart();
        game.gameEnd();
        if(game.hasEnded()){
            this.printGameSummary(game);
            this.calAndPrintAchievements(game);
        }
    }
//==============================instance vars===================================
//============================setters & getters=================================
}
