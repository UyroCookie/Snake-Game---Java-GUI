
import java.awt.Image;
import javax.swing.ImageIcon;

public class MainScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainScreen.class.getName());

    public MainScreen() {
        initComponents();
        Image i = new ImageIcon(this.getClass().getResource("Snake_Game_Icon.png")).getImage();
        this.setIconImage(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenu = new javax.swing.JPanel();
        Start_Button = new javax.swing.JButton();
        Credits_Button = new javax.swing.JButton();
        Exit_Button = new javax.swing.JButton();
        MainScreen_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake Game");
        setResizable(false);

        MainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Start_Button.setText("Start Button");
        Start_Button.addActionListener(this::Start_ButtonActionPerformed);
        MainMenu.add(Start_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 130, 50));

        Credits_Button.setText("Credits");
        Credits_Button.addActionListener(this::Credits_ButtonActionPerformed);
        MainMenu.add(Credits_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 130, 50));

        Exit_Button.setText("Exit");
        Exit_Button.addActionListener(this::Exit_ButtonActionPerformed);
        MainMenu.add(Exit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 130, 50));

        MainScreen_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MainMenu.png"))); // NOI18N
        MainMenu.add(MainScreen_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Credits_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Credits_ButtonActionPerformed
        Credits c = new Credits();
        c.show();
        dispose();
    }//GEN-LAST:event_Credits_ButtonActionPerformed

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void Start_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Start_ButtonActionPerformed
        new GameFrame();
        dispose();
    }//GEN-LAST:event_Start_ButtonActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Credits_Button;
    private javax.swing.JButton Exit_Button;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JLabel MainScreen_Background;
    private javax.swing.JButton Start_Button;
    // End of variables declaration//GEN-END:variables
}
