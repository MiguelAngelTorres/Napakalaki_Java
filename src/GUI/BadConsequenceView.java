package GUI;

import napakalakiGame.BadConsequence;

public class BadConsequenceView extends javax.swing.JPanel {
    BadConsequence badconsequenceModel ;
    
    public BadConsequenceView() {
        initComponents();
    }

    public void setBadConsequence(BadConsequence b){
        badconsequenceModel = b;
        mensaje.setText(badconsequenceModel.toString());
        repaint();
        revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensaje = new javax.swing.JLabel();

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        mensaje.setText("#DEF#");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}
