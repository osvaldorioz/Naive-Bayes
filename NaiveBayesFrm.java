 
package uc.unidad.cuatro.nb.frame;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import uc.unidad.cuatro.nb.classifiers.NaiveBayes;
import uc.unidad.cuatro.nb.dataobjects.NaiveBayesKnowledgeBase;


/**
 *
 * @author OR501695
 */
public class NaiveBayesFrm extends javax.swing.JFrame {
    Map<String, URL> trainingFiles = new HashMap<>();
    Map<String, String[]> trainingExamples = new HashMap<>();
    NaiveBayes nb = new NaiveBayes();
    NaiveBayesKnowledgeBase knowledgeBase = null;
    private ImageIcon master;
    
    /**
     * Creates new form NaiveBayesFrm
     */
    public NaiveBayesFrm() {
        initComponents();
        
        master = new javax.swing.ImageIcon(getClass().getResource("/diccionarios/paste.jpeg"));
        Image img = master.getImage();
        Image newimg = img.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        master = new ImageIcon(newimg);
        this.jButton2.setIcon(master);
        
        trainingFiles.put("Русский язык", NaiveBayesFrm.class.getResource("/diccionarios/ruso"));
        trainingFiles.put("English language", NaiveBayesFrm.class.getResource("/diccionarios/english"));
        trainingFiles.put("Langue française", NaiveBayesFrm.class.getResource("/diccionarios/french"));
        trainingFiles.put("Deutsche Sprache", NaiveBayesFrm.class.getResource("/diccionarios/deutch"));
        trainingFiles.put("Español", NaiveBayesFrm.class.getResource("/diccionarios/español"));
        try{
            for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
                trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
            }
        }catch(IOException err){}
        
        nb.setChiCuadradaCriticalValue(6.63); //0.01 pvalue
        nb.train(trainingExamples);
        
        knowledgeBase = nb.getKnowledgeBase();
        nb = new NaiveBayes(knowledgeBase);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Naive-Bayes MMED17027");

        jButton1.setText("Determinar el lenguaje del texto");
        jButton1.setToolTipText("Presione el botón");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setActionCommand("<Not Set>");

        jLabel1.setText("Ingrese una frase: ");

        jLabel2.setText("...");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diccionarios/paste.jpeg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String output = nb.predict(this.jTextField1.getText());
        
        this.jLabel2.setText("La oración " + this.jTextField1.getText() + 
                " está escrita en " + output);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jTextField1.paste();
             
    }//GEN-LAST:event_jButton2ActionPerformed

    private String[] readLines(URL url) throws IOException {

        Reader fileReader = new InputStreamReader(url.openStream(), Charset.forName("UTF-8"));
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
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
            java.util.logging.Logger.getLogger(NaiveBayesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NaiveBayesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NaiveBayesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NaiveBayesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NaiveBayesFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
