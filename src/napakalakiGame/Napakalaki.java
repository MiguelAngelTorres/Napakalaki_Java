/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Windows
 */
public class Napakalaki {

    private static Napakalaki instance = new Napakalaki();
    private int currentPlayerIndex ;
    private ArrayList<Player> players ;
    private Player currentPlayer;
    private Monster currentMonster ;
    private CardDealer dealer;
    
    private Napakalaki(){
        currentPlayerIndex = -1;
        players = new ArrayList();
        currentPlayerIndex = 0;
        dealer = CardDealer.getInstance();
    }
    private void initPlayers(ArrayList<String> names){
        for (String name : names){
            Player nuevo = new Player(name) ;
            players.add(nuevo);
        }
    }
    private Player nextPlayer(){
        if(currentPlayerIndex == -1){
            currentPlayerIndex = ThreadLocalRandom.current().nextInt(0,players.size()-1);
        }else{
            currentPlayerIndex = currentPlayerIndex + 1;
            if(currentPlayerIndex >= players.size()){
                currentPlayerIndex = 0;
            }
        }
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }
    private boolean nextTurnAllowed(){
        if(currentPlayer != null){
            return currentPlayer.validState();
        }else{
            return false;
        }
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    public CombatResult developCombat(){
        CombatResult res = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(res == CombatResult.LOSEANDCONVERT){
            players.remove(currentPlayer);
            currentPlayer = new CultistPlayer(currentPlayer,dealer.nextCultist()) ;
            players.add(currentPlayer);
        }
        
     return res;
    }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure treas : treasures){
            currentPlayer.discardVisibleTreasure(treas);
        }
    }
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure treas : treasures){
            currentPlayer.discardHiddenTreasure(treas);
        }
    }
    public void makeTreasureVisible(ArrayList<Treasure> treasures){
        for(Treasure treas : treasures){
            currentPlayer.makeTreasureVisible(treas);
        }
    }
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        dealer.initCards();
        nextTurn();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){
        boolean stateOK = true;
        boolean dead;
        if(currentPlayer != null){
            stateOK=nextTurnAllowed();
        }
        if(stateOK){
            if(currentPlayer != null){
                currentPlayer.setPendingBadConsequence(null);
            }
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    public boolean endOfGame(CombatResult result){
       return result == CombatResult.WIN; 
    }
    
    public static void main(String[] args) {

    }
}
