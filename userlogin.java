
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class userlogin extends javax.swing.JFrame {

    public userlogin() {
        initComponents();
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(email);
        email.setBounds(170, 150, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background and icons/Webp.net-resizeimage (15).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 230, 50, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background and icons/Webp.net-resizeimage (14).png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 150, 50, 40);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LogIn");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 50, 130, 40);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 330, 130, 30);

        jButton2.setText("New User?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 420, 110, 23);

        pass.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        getContentPane().add(pass);
        pass.setBounds(170, 220, 170, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background and icons/Webp.net-resizeimage (11).jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a=email.getText();
        String b=pass.getText();
        if(a.equals("")||b.equals("")) 
        {
        }
        else
        {
            try {
                
                HttpResponse<String> response=Unirest.get(GlobalData.hostname+"/userlogin")
                        .queryString("username",a)
                        .queryString("password",b)               
                        .asString();
                String ans=response.getBody();
                StringTokenizer st=new StringTokenizer(ans,"+");
                String user=st.nextToken();
                if(response.getBody().equals("Invalid login"))
                {
                   JOptionPane.showMessageDialog(this,"Invalid username/password");
                }
                else
                {
                    GlobalData.nameofuser=user;
                    System.out.println("~~~"+GlobalData.nameofuser);
                    new MusicCategory().setVisible(true);
                }
            } 
            
            catch (UnirestException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new usersignup().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                   new userlogin().setVisible(true);
               }
           });

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
           Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
