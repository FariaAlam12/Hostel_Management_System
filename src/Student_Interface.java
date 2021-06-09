

import java.awt.Toolkit;//for setting the upper left corner image


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Student_Interface extends javax.swing.JFrame {
 Connection conn;
   Statement statement;
   ResultSet resultSet;
   ResultSetMetaData resultsetMetaData;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(740, 590));

        fullPanel.setBackground(new java.awt.Color(255, 255, 255));
        fullPanel.setLayout(null);

        headerPanel.setBackground(new java.awt.Color(71, 179, 155));

        yourInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        yourInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        yourInfoLabel.setText("Your Information");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(yourInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(yourInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        fullPanel.add(headerPanel);
        headerPanel.setBounds(0, 0, 740, 130);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void showInfo()
    {
        
     try {
         resultSet.next();
         String name=resultSet.getString("S_Name");
         String id=resultSet.getString("S_ID");
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
    private javax.swing.JLabel deptLabel;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel fatherLabel;
    private javax.swing.JLabel father_Title;
    private javax.swing.JPanel fullPanel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel motherLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phonennoLabel;
    private javax.swing.JLabel phoneno_Title;
    private javax.swing.JLabel regularityLabel;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel room_Title;
    private javax.swing.JLabel yourInfoLabel;
    // End of variables declaration//GEN-END:variables
}
