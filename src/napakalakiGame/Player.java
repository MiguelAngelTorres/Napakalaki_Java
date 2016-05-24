/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import GUI.Dice;
import java.util.ArrayList;

public class Player {
    static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    public boolean infight = false;
    private ArrayList<Treasure> visibleTreasure;
    private ArrayList<Treasure> hiddenTreasure; 
    private BadConsequence pendingBadConsequence ;
    
    public Player(Player p){
        name = p.getName();
        level = p.getLevels();
        dead = p.isDead();
        visibleTreasure = p.getVisibleTreasures();
        hiddenTreasure = p.getHiddenTreasures();
        pendingBadConsequence = p.pendingBadConsequence;
    }
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    protected boolean shouldConvert(){
        Dice dado = Dice.getInstance();
        if(dado.nextNumber("Has perdido el combate.","Saca un 6 para convertirte en Sectario") == 6){
            return true;
        }
        return false;
    }
    public Player(String name){
        this.visibleTreasure = new ArrayList();
        this.hiddenTreasure = new ArrayList();
        this.name = name;
        level = 1;
    }
    public String getName(){
        return name ; 
    }
    private void bringToLive(){
        dead = false;
    }
    protected int getCombatLevel(){
        int clevel = 0;
        for (Treasure i : visibleTreasure){
            clevel += i.getBonus();
        }
        clevel += getLevels();
        return clevel;
    }
    private void incrementLevels(int l){
        level+=l;
    }
    private void decrementLevels(int l){
        level-=l;
        if(level < 1){
            level = 1;
        }
    }
    void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();
            for(int i = 0; i<nTreasures ; i++){
                Treasure treas = dealer.nextTreasure();
                hiddenTreasure.add(treas);
            }
        }
    }
    private void applyBadConsequence(Monster m){
        BadConsequence bads = m.getBadConsequence();
        decrementLevels(bads.getLevels());
        BadConsequence pendingBad = bads.adjustToFitTreasureLists(visibleTreasure,hiddenTreasure);
        setPendingBadConsequence(pendingBad);
    }
    private boolean canMakeTreasureVisible(Treasure t){
        boolean res = true; 
        int manos = 0;
        for(Treasure i : visibleTreasure){
            if(i.getType() == TreasureKind.ONEHAND){
                manos += 1;
            }
            if(i.getType() == t.getType()){
                res = false;
            }
        }
        if(t.getType() == TreasureKind.BOTHHANDS && manos != 0){
            res = false;
        }
        if(t.getType() == TreasureKind.ONEHAND && manos == 1){
            res = true;
        }
    return res;
    }
    private int howManyVisibleTreasures(TreasureKind tKind){
        int n = 0;
        for(Treasure i:visibleTreasure){
            if(i.getType() == tKind){
                n++;
            }
        }
    return n;
    }
    private void dieIfNoTreasures(){
        if(hiddenTreasure.isEmpty() && visibleTreasure.isEmpty()){
            dead = true;
        }        
    }
    public boolean isDead(){
        return dead;
    }
    public ArrayList<Treasure> getHiddenTreasures(){
       return hiddenTreasure; 
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasure;
    }
    public CombatResult combat(Monster m){
        CombatResult res;
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        if(myLevel>monsterLevel){
            applyPrize(m);
            if(level >= MAXLEVEL){
                res = CombatResult.WINGAME;
            }else{
                res = CombatResult.WIN;
            }
        }else{
           applyBadConsequence(m);
           if(shouldConvert())
               res = CombatResult.LOSEANDCONVERT;
           else
               res = CombatResult.LOSE ;
        }
    return res;
    }
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasure.add(t);
            hiddenTreasure.remove(t);
        }
    }
    public void discardVisibleTreasure(Treasure t){
        visibleTreasure.remove(t);
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        if(pendingBadConsequence!=null && !(pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasure.remove(t);
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
         if(pendingBadConsequence!=null && !(pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
         dieIfNoTreasures();
    }
    public boolean validState(){
        boolean valid = false;
        if(pendingBadConsequence == null && visibleTreasure.size() <= 4){
            valid = true;
        }else{
            if(pendingBadConsequence.isEmpty() && visibleTreasure.size() <= 4)
                valid = true;
        }
    return valid;    
    }
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dado = Dice.getInstance();
        bringToLive();
        Treasure treas = dealer.nextTreasure();
        hiddenTreasure.add(treas);
        int number = dado.nextNumber("Tira el dado para determinar tus tesoros.","1=1 Tesoro, 2-5=2 Tesoros, 6=3 Tesoros ");
        if(number > 1){
            hiddenTreasure.add(dealer.nextTreasure());
        }
        if(number == 6){
            hiddenTreasure.add(dealer.nextTreasure());
        }
    }
    public int getLevels(){
        return level;
    }
    public void discardAllTreasures(){
        for(Treasure treas : visibleTreasure){
            discardVisibleTreasure(treas);
        }
        for(Treasure treas : hiddenTreasure){
            discardHiddenTreasure(treas);
        }
    }
    public String toString(){
        return name+"("+level+")"+" que esta muerto:"+dead+"\n\tVisibles: "+visibleTreasure+"\n\tHidden: "+hiddenTreasure+"\nPending:"+pendingBadConsequence;
    }
}
