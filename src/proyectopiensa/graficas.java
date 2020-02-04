
package proyectopiensa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class graficas extends javax.swing.JFrame {

    
    public graficas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbconsultas = new javax.swing.JComboBox<>();
        rb3d = new javax.swing.JRadioButton();
        rb2d = new javax.swing.JRadioButton();
        rbbarras = new javax.swing.JRadioButton();
        rbcircular = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblconsultas = new javax.swing.JTable();
        btnejecutar = new javax.swing.JButton();
        btngraficar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbconsultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-seleccione una consulta-", "mostrar tabla proveedores", "agrupar personas", "mostrar tabla genero" }));

        rb3d.setText("3 D");

        rb2d.setText("2 D");

        rbbarras.setText("barras");

        rbcircular.setText("circular");

        tblconsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblconsultas);

        btnejecutar.setText("ejecutar");
        btnejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnejecutarActionPerformed(evt);
            }
        });

        btngraficar.setText("graficar");
        btngraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngraficarActionPerformed(evt);
            }
        });

        btnregresar.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb3d, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb2d, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbbarras, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(rbcircular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btngraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnregresar)))
                .addContainerGap(489, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(cmbconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb3d)
                    .addComponent(rb2d)
                    .addComponent(rbbarras)
                    .addComponent(rbcircular))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregresar))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnejecutarActionPerformed
        DefaultTableModel miModelo;
        
        Dgraficar miGrafica = new Dgraficar();
        int op=cmbconsultas.getSelectedIndex();
        switch(op){
            case 1:
                
                miModelo=miGrafica.mostrarpersona();
                tblconsultas.setModel(miModelo);
                
                break;
                
            case 2:
                
                miModelo=miGrafica.agruparpersona();
                 tblconsultas.setModel(miModelo);
                
                 break;
                 
             case 3:
                
                miModelo=miGrafica.mostrargenero();
                 tblconsultas.setModel(miModelo);
                
                 break; 
             default:
                 JOptionPane.showMessageDialog(rootPane,"seleccione una opcion del combo");
               
            
        
        
        
        
        
        
        
        
        
        
        
        }
        
        
    }//GEN-LAST:event_btnejecutarActionPerformed

    private void btngraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngraficarActionPerformed
        if(rb3d.isSelected()&& rbbarras.isSelected()){
            DefaultCategoryDataset dtsc=new DefaultCategoryDataset();
            for (int i=0;i<tblconsultas.getRowCount();i++){
                dtsc.setValue(Integer.parseInt(tblconsultas.getValueAt(i,0).toString()),tblconsultas.getValueAt(i,1).toString(),tblconsultas.getValueAt(i,2).toString());
                
            }
            JFreeChart ch=ChartFactory.createBarChart3D("Grafica de barras en 3D","Dias","Cantidad",dtsc,PlotOrientation.VERTICAL,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
        }
                if(rb2d.isSelected()&& rbbarras.isSelected()){
            DefaultCategoryDataset dtsc=new DefaultCategoryDataset();
            for (int i=0;i<tblconsultas.getRowCount();i++){
                dtsc.setValue(Integer.parseInt(tblconsultas.getValueAt(i,0).toString()),tblconsultas.getValueAt(i,1).toString(),tblconsultas.getValueAt(i,2).toString());
                
            }
            JFreeChart ch=ChartFactory.createBarChart("Grafica de barras en 2D","Dias","Cantidad",dtsc,PlotOrientation.VERTICAL,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(600,100,500,500);
    }//GEN-LAST:event_btngraficarActionPerformed
   if(rb3d.isSelected()&& rbcircular.isSelected()){
            DefaultPieDataset dtsc=new DefaultPieDataset();
            for (int i=0;i<tblconsultas.getRowCount();i++){
                dtsc.setValue(tblconsultas.getValueAt(i,0).toString(),Integer.parseInt(tblconsultas.getValueAt(i,1).toString()));
                
            }
            JFreeChart ch=ChartFactory.createPieChart3D("Grafica Circular 3D",dtsc,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(500,40,550,400);
            }
   if(rb2d.isSelected()&& rbcircular.isSelected()){
            DefaultPieDataset dtsc=new DefaultPieDataset();
            for (int i=0;i<tblconsultas.getRowCount();i++){
                dtsc.setValue(tblconsultas.getValueAt(i,0).toString(),Integer.parseInt(tblconsultas.getValueAt(i,1).toString()));
                
            }
            JFreeChart ch=ChartFactory.createPieChart("Grafica Circular 2D",dtsc,true,true,false);
            ChartPanel cp=new ChartPanel(ch);
            add(cp);
            cp.setBounds(500,40,550,400);
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graficas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnejecutar;
    private javax.swing.JButton btngraficar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cmbconsultas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb2d;
    private javax.swing.JRadioButton rb3d;
    private javax.swing.JRadioButton rbbarras;
    private javax.swing.JRadioButton rbcircular;
    private javax.swing.JTable tblconsultas;
    // End of variables declaration//GEN-END:variables
}
