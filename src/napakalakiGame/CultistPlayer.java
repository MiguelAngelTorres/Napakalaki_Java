/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import static java.lang.Math.round;

/**
 *
 * @author Windows
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers += 1 ; 
    }
    @Override
    protected int getCombatLevel(){
        int aux = super.getCombatLevel();
        aux = aux + round(aux/2 - 49/100) + myCultistCard.getGainedLevels() ;
    return aux;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistsPlayer();
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    public String toString(){
        return "[CULTIST PLAYER]\n" + super.toString();
    }
}
