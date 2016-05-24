/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

/**
 *
 * @author Windows
 */
public class DeathBadConsequence extends NumericBadConsequence{
    DeathBadConsequence(String text){
        super(text,Player.MAXLEVEL,BadConsequence.MAXTREASURES,BadConsequence.MAXTREASURES);
    }
    @Override
    public String toString(){
        return text;
    }
}
