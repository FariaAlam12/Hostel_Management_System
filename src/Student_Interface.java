

import java.awt.Toolkit;//for setting the upper left corner image


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Student_Interface extends javax.swing.JFrame {
 Connection conn;
   Statement statement;
   ResultSet resultSet,resultSetPass;
   ResultSetMetaData resultsetMetaData;
   String id;
    public Student_Interface() {
        initComponents();
    }
    public Student_Interface(ResultSet res) {
        initComponents();
        
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        try{
            conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Student_Interface");
                 statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
              
                 resultSet=res;
                 resultSetPass=res;
                
                
            }
            
            
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
        
        showInfo();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        yourInfoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        ID_Title = new javax.swing.JLabel();
        IdLabel = new javax.swing.JLabel();
        Email_Title = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        Dept_Tiltle = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        Regularity_Title = new javax.swing.JLabel();
        regularityLabel = new javax.swing.JLabel();
        DOB_Tiitle = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        father_Title = new javax.swing.JLabel();
        fatherLabel = new javax.swing.JLabel();
        Mother_Title = new javax.swing.JLabel();
        motherLabel = new javax.swing.JLabel();
        Home_Title = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        Gender_Title = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        phoneno_Title = new javax.swing.JLabel();
        phonennoLabel = new javax.swing.JLabel();
        Alternate_Title = new javax.swing.JLabel();
        AlternateLabel = new javax.swing.JLabel();
        room_Title = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        complaincancelBtnLabel = new javax.swing.JLabel();
        addmealBtnLabel = new javax.swing.JLabel();
        seeBillLabel = new javax.swing.JLabel();
        logOutLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fullPanel.setBackground(new java.awt.Color(255, 255, 255));
        fullPanel.setLayout(null);

        headerPanel.setBackground(new java.awt.Color(24, 44, 97));

        yourInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        yourInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        yourInfoLabel.setText("Your Information");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yourinformation.png"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(yourInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(yourInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fullPanel.add(headerPanel);
        headerPanel.setBounds(0, 0, 740, 170);

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fullPanel.add(nameLabel);
        nameLabel.setBounds(20, 160, 320, 40);

        ID_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ID_Title.setText("ID:");
        fullPanel.add(ID_Title);
        ID_Title.setBounds(20, 240, 20, 30);

        IdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        IdLabel.setText("id");
        fullPanel.add(IdLabel);
        IdLabel.setBounds(130, 240, 90, 30);

        Email_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Email_Title.setText("Email:");
        fullPanel.add(Email_Title);
        Email_Title.setBounds(20, 283, 40, 30);

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setText("email");
        fullPanel.add(emailLabel);
        emailLabel.setBounds(130, 280, 150, 30);

        Dept_Tiltle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dept_Tiltle.setText("Dept:");
        fullPanel.add(Dept_Tiltle);
        Dept_Tiltle.setBounds(20, 330, 50, 30);

        deptLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deptLabel.setText("dept");
        fullPanel.add(deptLabel);
        deptLabel.setBounds(130, 330, 80, 30);

        Regularity_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Regularity_Title.setText("Regularity :");
        fullPanel.add(Regularity_Title);
        Regularity_Title.setBounds(20, 370, 80, 30);

        regularityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        regularityLabel.setText("reg");
        fullPanel.add(regularityLabel);
        regularityLabel.setBounds(130, 370, 120, 30);

        DOB_Tiitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DOB_Tiitle.setText("Date Of Birth:");
        fullPanel.add(DOB_Tiitle);
        DOB_Tiitle.setBounds(20, 420, 90, 30);

        dobLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dobLabel.setText("dob");
        fullPanel.add(dobLabel);
        dobLabel.setBounds(130, 420, 140, 30);

        father_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        father_Title.setText("Father's Name:");
        fullPanel.add(father_Title);
        father_Title.setBounds(370, 240, 90, 30);

        fatherLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fatherLabel.setText("fa");
        fullPanel.add(fatherLabel);
        fatherLabel.setBounds(520, 240, 130, 30);

        Mother_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Mother_Title.setText("Mother's Name:");
        fullPanel.add(Mother_Title);
        Mother_Title.setBounds(370, 280, 100, 30);

        motherLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherLabel.setText("mom");
        fullPanel.add(motherLabel);
        motherLabel.setBounds(520, 280, 150, 30);

        Home_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Home_Title.setText("Home Address:");
        fullPanel.add(Home_Title);
        Home_Title.setBounds(370, 330, 100, 30);

        homeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        homeLabel.setText("home");
        fullPanel.add(homeLabel);
        homeLabel.setBounds(520, 330, 180, 30);

        Gender_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Gender_Title.setText("Gender:");
        fullPanel.add(Gender_Title);
        Gender_Title.setBounds(20, 460, 70, 30);

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        genderLabel.setText("gen");
        fullPanel.add(genderLabel);
        genderLabel.setBounds(130, 460, 70, 30);

        phoneno_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneno_Title.setText("Phone No:");
        fullPanel.add(phoneno_Title);
        phoneno_Title.setBounds(370, 370, 100, 30);

        phonennoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phonennoLabel.setText("ph");
        fullPanel.add(phonennoLabel);
        phonennoLabel.setBounds(520, 370, 170, 30);

        Alternate_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Alternate_Title.setText("Alternate Phone No:");
        fullPanel.add(Alternate_Title);
        Alternate_Title.setBounds(370, 420, 130, 30);

        AlternateLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AlternateLabel.setText("alt");
        fullPanel.add(AlternateLabel);
        AlternateLabel.setBounds(520, 420, 160, 30);

        room_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        room_Title.setText("Room No:");
        fullPanel.add(room_Title);
        room_Title.setBounds(20, 510, 80, 20);

        roomLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roomLabel.setText("ro");
        fullPanel.add(roomLabel);
        roomLabel.setBounds(130, 510, 80, 20);

        jPanel1.setBackground(new java.awt.Color(24, 44, 97));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Activities");

        complaincancelBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/complainBtn.png"))); // NOI18N
        complaincancelBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        complaincancelBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                complaincancelBtnLabelMouseClicked(evt);
            }
        });

        addmealBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addmeal.png"))); // NOI18N
        addmealBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addmealBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addmealBtnLabelMouseClicked(evt);
            }
        });

        seeBillLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seebill.png"))); // NOI18N
        seeBillLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seeBillLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeBillLabelMouseClicked(evt);
            }
        });

        logOutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logOutFromStudent.png"))); // NOI18N
        logOutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seeBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addmealBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complaincancelBtnLabel))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(complaincancelBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addmealBtnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(seeBillLabel)
                .addGap(10, 10, 10)
                .addComponent(logOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fullPanel.add(jPanel1);
        jPanel1.setBounds(0, 560, 740, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void complaincancelBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complaincancelBtnLabelMouseClicked
        ComplainInterface CI=new ComplainInterface(id,resultSetPass);
        this.setVisible(false);
        CI.setVisible(true);
    }//GEN-LAST:event_complaincancelBtnLabelMouseClicked

    private void addmealBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addmealBtnLabelMouseClicked
       MenuSelection MS=new MenuSelection(id);
       MS.setVisible(true);
    }//GEN-LAST:event_addmealBtnLabelMouseClicked

    private void seeBillLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeBillLabelMouseClicked
        Student_Bill_details sbd=new Student_Bill_details(id);
       sbd.setVisible(true);
    }//GEN-LAST:event_seeBillLabelMouseClicked

    private void logOutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutLabelMouseClicked
          LogIn LI=new LogIn();
          this.setVisible(false);
          LI.setVisible(true);
    }//GEN-LAST:event_logOutLabelMouseClicked







    void showInfo()
    {
        
     try {
         resultSet.next();
         String name=resultSet.getString("S_Name");
         id=resultSet.getString("S_ID");
         String email=resultSet.getString("S_Email");
         String dept=resultSet.getString("S_Dept");
         String regularity=resultSet.getString("S_Regularity_Status");
         String father=resultSet.getString("S_Father_Name");
         String mother=resultSet.getString("S_Mother_Name");
         String gender=resultSet.getString("S_Gender");
         String address=resultSet.getString("S_Home_Address");
         String roomno=resultSet.getString("Room_No");
         
         //java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
         java.sql.Date sDate=resultSet.getDate("S_DOB");
         java.util.Date utilDate = new java.util.Date(sDate.getTime());
         SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd,yyyy");
         
         String DOB_String = sdf1.format(utilDate);
         //Counting rows of incoming contact table 
         String query2=String.format("select count(*) as c from Student_Information SI inner join Student_Contact SC on SI.S_ID='%s' and SI.S_ID=SC.S_ID",id);
         resultSet = statement.executeQuery(query2);
         resultSet.next();
         int rowcount=resultSet.getInt("c");
         
         //For fetching info from Student_contact table
         
         String query3=String.format("select SC.phone_no from Student_Information SI inner join Student_Contact SC on SI.S_ID='%s' and SI.S_ID=SC.S_ID",id);
          resultSet = statement.executeQuery(query3);
         
          int i=0;
          String phn1="",altphn="";
          while(resultSet.next())
          {
              if(i==0)
              {
                  phn1=resultSet.getString("phone_no");
              }
              else 
              {
                  altphn=resultSet.getString("phone_no");
              }
              i++;
          }
          
          //System.out.println(phn1);
         // System.out.println(altphn);
          
         //Setting on corresponding label
         nameLabel.setText(name);
         IdLabel.setText(id);
         emailLabel.setText(email);
         deptLabel.setText(dept);
         regularityLabel.setText(regularity);
         dobLabel.setText(DOB_String);
         genderLabel.setText(gender);
         fatherLabel.setText(father);
         motherLabel.setText(mother);
         homeLabel.setText(address);
         roomLabel.setText(roomno);
         
         if(rowcount==1)
         {
             phonennoLabel.setText(phn1);
             Alternate_Title.setVisible(false);
              AlternateLabel.setVisible(false);
         }
         else
         {
             phonennoLabel.setText(phn1);
             AlternateLabel.setText(altphn);
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Student_Interface.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
     
     
    }
    
    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlternateLabel;
    private javax.swing.JLabel Alternate_Title;
    private javax.swing.JLabel DOB_Tiitle;
    private javax.swing.JLabel Dept_Tiltle;
    private javax.swing.JLabel Email_Title;
    private javax.swing.JLabel Gender_Title;
    private javax.swing.JLabel Home_Title;
    private javax.swing.JLabel ID_Title;
    private javax.swing.JLabel IdLabel;
    private javax.swing.JLabel Mother_Title;
    private javax.swing.JLabel Regularity_Title;
    private javax.swing.JLabel addmealBtnLabel;
    private javax.swing.JLabel complaincancelBtnLabel;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel fatherLabel;
    private javax.swing.JLabel father_Title;
    private javax.swing.JPanel fullPanel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logOutLabel;
    private javax.swing.JLabel motherLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phonennoLabel;
    private javax.swing.JLabel phoneno_Title;
    private javax.swing.JLabel regularityLabel;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel room_Title;
    private javax.swing.JLabel seeBillLabel;
    private javax.swing.JLabel yourInfoLabel;
    // End of variables declaration//GEN-END:variables
}
