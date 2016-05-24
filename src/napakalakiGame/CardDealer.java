/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Windows
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer() ;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultists = new ArrayList();
    }
    private void initCultistsCardDeck(){
        unusedCultists.add(new Cultist("Agarius",1));
        unusedCultists.add(new Cultist("Boletus",2));
        unusedCultists.add(new Cultist("Daldinia",1));
        unusedCultists.add(new Cultist("Bolbitius",2));
        unusedCultists.add(new Cultist("Calvatia",1));
        unusedCultists.add(new Cultist("Dermoloma",1));
    }
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure("A prueba de babas", 2,TreasureKind.ARMOR));   
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.SHOES));   
        unusedTreasures.add(new Treasure("Casco minero", 2,TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,TreasureKind.BOTHHANDS));   
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1,TreasureKind.ARMOR));   
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2,TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de tres cañones", 4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycon",3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a dos manos",3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 0, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 0, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Shogulador", 1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
    }
    private void initMonsterCardDeck(){
        ArrayList<TreasureKind> hidden = new ArrayList();
        ArrayList<TreasureKind> visible = new ArrayList();

        TreasureKind aux = TreasureKind.ARMOR ;
        visible.add(aux) ;
        hidden.add(aux);
        BadConsequence bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0,visible,hidden);
        Prize gj = new Prize(2,1);
        Monster m = new Monster("3 Byakhees de bonanza",8,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.HELMET ;
        visible.add(aux) ;
        hidden.clear();
        bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,visible,hidden);
        gj = new Prize(1,1);
        m = new Monster("Chibithulhu",2,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.SHOES;
        visible.add(aux) ;
        hidden.clear();
        bc = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",0,visible,hidden);
        gj = new Prize(1,1);
        m = new Monster("El sopor de Dunwich",2,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ONEHAND;
        visible.add(aux);
        hidden.add(aux);
        bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,visible,hidden);
        gj = new Prize(4,1);
        m = new Monster("Ángeles de la noche ibicenca",14,bc,gj);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,BadConsequence.MAXTREASURES,0);
        gj = new Prize(3,1);
        m = new Monster("El gorrón en el umbral",10,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ARMOR;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Pierdes la armadura visible",0,visible,hidden);
        gj = new Prize(2,1);
        m = new Monster("H.P Munchcraft",6,bc,gj);
        unusedMonsters.add(m);
       
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ARMOR;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Sientes bihos bajo la ropa. Descarta la armadura visible",0,visible,hidden);
        gj = new Prize(1,1);
        m = new Monster("Bichgooth",2,bc,gj);
        unusedMonsters.add(m);
      
        bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        gj = new Prize(4,2);
        m = new Monster("El rey de la rosa",13,bc,gj);
        unusedMonsters.add(m);
       
        bc = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        gj = new Prize(1,1);
        m = new Monster("La que redacta en las tinieblasl",2,bc,gj);
        unusedMonsters.add(m);
        
        bc = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.");
        gj = new Prize(2,1);
        m = new Monster("Los hondos",8,bc,gj);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        gj = new Prize(2,1);
        m = new Monster("Semillas Cthulhu",4,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ONEHAND;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Te intantas escaquear. Pierdes una mano visible",0,visible,hidden);
        gj = new Prize(3,1);
        m = new Monster("Dameargo",1,bc,gj);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        gj = new Prize(1,1);
        m = new Monster("Polipólipo volante",3,bc,gj);
        unusedMonsters.add(m);
        
        bc = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
        gj = new Prize(3,1);
        m = new Monster("Yskhtihyssg-Goth",12,bc,gj);
        unusedMonsters.add(m);
        
        bc = new DeathBadConsequence("La familia te atrapa.Estas muerto");
        gj = new Prize(4,1);
        m = new Monster("Familia feliz",1,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.BOTHHANDS;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("La quinta directiva primaria te oblica a perder 2 niveles y un tesoro de 2 manos visible",2,visible,hidden);
        gj = new Prize(2,1);
        m = new Monster("Roboggoth",8,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.HELMET;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Te asustas en la noche. Pierdes un casco visible",0,visible,hidden);
        gj = new Prize(1,1);
        m = new Monster("El espia",5,bc,gj);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesores visibles",2,5,0);
        gj = new Prize(1,1);
        m = new Monster("El Lenguas",20,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ONEHAND;
        visible.add(aux);
        hidden.add(aux);
        aux = TreasureKind.BOTHHANDS;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,visible,hidden);
        gj = new Prize(1,1);
        m = new Monster("Bicéfalo",20,bc,gj);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ONEHAND;
        visible.add(aux);
        hidden.clear();
        bc = new SpecificBadConsequence("Pierdes una mano visible",0,visible,hidden);
        gj = new Prize(3,1);
        m = new Monster("El mal indecible impronunciable",20,bc,gj,-2);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Pierdes tus tesoros visibles",0,10,0);
        gj = new Prize(2,1);
        m = new Monster("Testigos Oculares",6,bc,gj,2);
        unusedMonsters.add(m);
        
        bc = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres");
        gj = new Prize(2,5);
        m = new Monster("El gran cthulhu",20,bc,gj,4);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
        gj = new Prize(2,1);
        m = new Monster("Serpiente político",8,bc,gj,-2);
        unusedMonsters.add(m);
        
        hidden = new ArrayList();
        visible = new ArrayList();
        aux = TreasureKind.ONEHAND;
        hidden.add(aux);
        hidden.add(aux);
        hidden.add(TreasureKind.BOTHHANDS);
        visible.add(TreasureKind.HELMET);
        visible.add(TreasureKind.ARMOR);
        bc = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",2,visible,hidden);
        gj = new Prize(3,1);
        m = new Monster("El mal indecible impronunciable",20,bc,gj,-2);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
        gj = new Prize(4,2);
        m = new Monster("Shoggoth",16,bc,gj,-4);
        unusedMonsters.add(m);
        
        bc = new NumericBadConsequence("Pintalabios negro. Pierdes dos niveles.",2,0,0);
        gj = new Prize(4,2);
        m = new Monster("Lolitagooth",2,bc,gj,3);
        unusedMonsters.add(m);
    }
    private void shuffleTreasure(){
        Collections.shuffle(unusedTreasures);
    }
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    public static CardDealer getInstance(){
        return instance;
    }
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            for(Treasure i : usedTreasures){
                unusedTreasures.add(i);
                usedTreasures.remove(i);
            }
            shuffleTreasure();
        }
        return unusedTreasures.remove(0);
    }
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            for(Monster i : usedMonsters){
                unusedMonsters.add(i);
                usedMonsters.remove(i);
            }
            shuffleMonsters();
        }
        return unusedMonsters.remove(0);
    }
    public Cultist nextCultist(){
        return unusedCultists.remove(0);
    }
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    public void initCards(){
        initMonsterCardDeck();
        initTreasureCardDeck();
        initCultistsCardDeck();
        shuffleCultists();
        shuffleTreasure();
        shuffleMonsters();
    }
}
