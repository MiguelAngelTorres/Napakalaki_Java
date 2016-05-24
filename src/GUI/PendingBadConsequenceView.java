package GUI;
import napakalakiGame.BadConsequence;

public class PendingBadConsequenceView extends javax.swing.JPanel {
    BadConsequence pendingBadConsequenceView; 
    public PendingBadConsequenceView() {
        initComponents();
    }

    public void setPendingBadConsequence(BadConsequence bads){
        pendingBadConsequenceView = bads;
        if(pendingBadConsequenceView != null){
            pending.setText(pendingBadConsequenceView.toString());
            repaint();
        }else{
            pending.setText("No hay nada pendiente.");
            repaint();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pending = new javax.swing.JTextArea();

        pending.setColumns(20);
        pending.setRows(2);
        jScrollPane1.setViewportView(pending);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pending;
    // End of variables declaration//GEN-END:variables
}
