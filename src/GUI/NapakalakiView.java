package GUI;


import javax.swing.JPanel;
import napakalakiGame.CombatResult;
import napakalakiGame.Monster;
import napakalakiGame.Napakalaki;
import napakalakiGame.Player;
public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel;
    
    public NapakalakiView() {
        initComponents();
        Mensaje1.setText("Equípate y pulsa conocer monstruo cuando estés preparado.");
        Mensaje2.setText("No podrás volver a cambiar tu equipo");
        combat.setEnabled(false);
        nextTurn.setEnabled(false);
        combat.setVisible(false);
        nextTurn.setVisible(false);
    }
    private void fillcurrentPlayerPanel(JPanel aPanel, Player p){
        aPanel.removeAll();
        
        PlayerView aPlayerView = new PlayerView();
        aPlayerView.setNapakalaki(napakalakiModel);
        aPlayerView.setPlayer(p);
        aPlayerView.setVisible(true);
        aPanel.add(aPlayerView);
        
        aPanel.repaint();
        aPanel.revalidate();
    } 
    private void fillcurrentMonsterPanel(JPanel aPanel, Monster m){
        aPanel.removeAll();
        
        MonsterView aMonsterView = new MonsterView();
        aMonsterView.setMonster(m);
        aMonsterView.setVisible(true);
        aPanel.setVisible(false);
        aPanel.add(aMonsterView);
        
        aPanel.repaint();
        aPanel.revalidate();
    } 
    public void setNapakalaki(Napakalaki game){
        napakalakiModel = game;
        this.fillcurrentPlayerPanel(currentPlayer, napakalakiModel.getCurrentPlayer());
        this.fillcurrentMonsterPanel(currentMonster, napakalakiModel.getCurrentMonster());
        repaint();
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        currentPlayer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        meetMonster = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        Mensaje1 = new javax.swing.JLabel();
        currentMonster = new javax.swing.JPanel();
        Mensaje2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
        jLabel1.setText("Jugador actual");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 245, 25);

        currentPlayer.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        getContentPane().add(currentPlayer);
        currentPlayer.setBounds(10, 20, 1290, 340);

        jLabel2.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
        jLabel2.setText("Monstruo actual");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 370, 245, 25);

        meetMonster.setText("Concer al monstruo");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });
        getContentPane().add(meetMonster);
        meetMonster.setBounds(1100, 560, 170, 80);

        combat.setText("Luchar");
        combat.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });
        getContentPane().add(combat);
        combat.setBounds(900, 560, 160, 80);

        nextTurn.setText("Siguiente turno");
        nextTurn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });
        getContentPane().add(nextTurn);
        nextTurn.setBounds(680, 560, 160, 80);

        Mensaje1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mensaje1.setForeground(new java.awt.Color(200, 0, 0));
        getContentPane().add(Mensaje1);
        Mensaje1.setBounds(680, 450, 600, 20);

        currentMonster.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        getContentPane().add(currentMonster);
        currentMonster.setBounds(10, 390, 630, 300);

        Mensaje2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mensaje2.setForeground(new java.awt.Color(200, 0, 0));
        getContentPane().add(Mensaje2);
        Mensaje2.setBounds(680, 480, 600, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        Mensaje1.setText("Espero que estés preparado para luchar contra esta bestia.");
        Mensaje2.setText("");
        napakalakiModel.getCurrentPlayer().infight = true;
        this.setNapakalaki(napakalakiModel);
        currentMonster.setVisible(true); 
        combat.setEnabled(true);
        combat.setVisible(true);
        meetMonster.setEnabled(false);
        meetMonster.setVisible(false);
        repaint();
    }//GEN-LAST:event_meetMonsterActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult res = napakalakiModel.developCombat();
        if(CombatResult.WIN == res){
            Mensaje1.setText("Equípate y pulsa conocer monstruo cuando estés preparado.");
            Mensaje2.setText("No podrás volver a cambiar tu equipo");
        }else if(CombatResult.LOSE == res){
            Mensaje1.setText("¡Que deshonra! Has perdido la batalla.");
            Mensaje2.setText("Tendrás que hacer frente a las consecuencias");
        }else if(CombatResult.WINGAME == res){
            Mensaje1.setText("¡Enhorabuena novato!");
            Mensaje2.setText("HAS GANADO");
        }  
        napakalakiModel.getCurrentPlayer().infight = false;
        setNapakalaki(napakalakiModel);
        nextTurn.setEnabled(true);
        nextTurn.setVisible(true);
        combat.setEnabled(false);
        combat.setVisible(false);
        meetMonster.setEnabled(false);
        meetMonster.setVisible(false);
        repaint();

    }//GEN-LAST:event_combatActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        if(!napakalakiModel.nextTurn()){
            Mensaje1.setText("Tienes algún mal rollo pendiente, no puedes continuar.");
            Mensaje2.setText("");
        }else{
            Mensaje1.setText("Por hoy ya has hecho suficiente.");
            Mensaje2.setText("Espera a tu siguiente turno");
        }
        setNapakalaki(napakalakiModel);
        repaint();
    }//GEN-LAST:event_nextTurnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mensaje1;
    private javax.swing.JLabel Mensaje2;
    private javax.swing.JButton combat;
    private javax.swing.JPanel currentMonster;
    private javax.swing.JPanel currentPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton meetMonster;
    private javax.swing.JButton nextTurn;
    // End of variables declaration//GEN-END:variables
}
