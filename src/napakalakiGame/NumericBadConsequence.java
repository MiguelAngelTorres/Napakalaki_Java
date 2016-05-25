package napakalakiGame;

import java.util.ArrayList;


public class NumericBadConsequence extends BadConsequence{
    int nHiddenTreasures;
    int nVisibleTreasures;
    NumericBadConsequence(String text, int level, int nVisible, int nHidden){
        super(text,level) ;
        nHiddenTreasures = nHidden;
        nVisibleTreasures = nVisible;
    }
    @Override
    public boolean isEmpty(){
        if(nHiddenTreasures == 0 && nVisibleTreasures == 0){
            return true;
        }
    return false;       
    }
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    @Override
    public void substractHiddenTreasure(Treasure t){
        nHiddenTreasures -= 1;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        nVisibleTreasures -= 1;
    }
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        int vres, hres;
        int nvisible = v.size();
        int nhidden = h.size();
        if(nvisible < nVisibleTreasures){
            vres = nvisible;
        }else{
            vres = nVisibleTreasures;
        }
        if(nhidden < nHiddenTreasures){
            hres = nhidden;
        }else{
            hres = nHiddenTreasures;
        }
        BadConsequence res = new NumericBadConsequence(text+"(MODIFICADO)",0,vres,hres);
        return res;
    }
    public String toString(){
        return text + "\n\tNiveles perdidos: " + levels + "\n\tTesoros visibles: " + nVisibleTreasures + "\n\tTesoros ocultos: " + nHiddenTreasures;
    }
}
