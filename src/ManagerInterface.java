

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class ManagerInterface extends javax.swing.JFrame {
    
   Connection conn;
   Statement statement,statement2;
   ResultSet resultSet,resultSet2,resultSet3,resultSet6,resultSet4,resultSet7,resultSet5,resultSetPass;
   
   ResultSetMetaData resultsetMetaData;
   int rowcount;
   String StuffId,StuffIdpassed;
    public ManagerInterface() {
        initComponents();
    }

    public ManagerInterface(String Stuff_ID) {
        initComponents();
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        //this.resultSetPass=Res;
        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Manager Interface");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                statement2=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                StuffIdpassed=Stuff_ID;
            }
            
            
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
        
        showInfo();
        
    }
    
    void showInfo()
    {     // Show Info for apllicant
       String query=String.format("select count(*) as c from Student_Information where S_Status='0'");
       try {
           resultSet = statement.executeQuery(query);
           resultSet.next();
           rowcount=resultSet.getInt("c");
           DefaultTableModel model;
           model=(DefaultTableModel) pendinglist.getModel(); 
           model.setRowCount(0);
           query=String.format("select * from student_information where S_Status='0'");
           resultSet = statement.executeQuery(query);
           
           
           
           String name,id,email,dept,regularity,father,mother,gender,address,DOB_String;
           while(resultSet.next())
           {
                name=resultSet.getString("S_Name");
                id=resultSet.getString("S_ID");
                email=resultSet.getString("S_Email");
                dept=resultSet.getString("S_Dept");
                regularity=resultSet.getString("S_Regularity_Status");
                father=resultSet.getString("S_Father_Name");
                mother=resultSet.getString("S_Mother_Name");
                gender=resultSet.getString("S_Gender");
                address=resultSet.getString("S_Home_Address");
                
                java.sql.Date sDate=resultSet.getDate("S_DOB");
                java.util.Date utilDate = new java.util.Date(sDate.getTime());
                SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd,yyyy");
                
                DOB_String = sdf1.format(utilDate);
                
                model.insertRow(model.getRowCount(),new Object[]{id,name,email,dept,regularity,father,mother,DOB_String,gender,address,"--Select Room--",false});
           }
           
           TableColumn stuffColumn = pendinglist.getColumnModel().getColumn(10);
           JComboBox comboBox = new JComboBox();
            String query4=String.format("select Room_No from Room_Information where Cur_No_Seat<4 and Room_No!='NA'");
               resultSet5 = statement2.executeQuery(query4);
               while(resultSet5.next())
               {
                   String room_no=resultSet5.getString("Room_No");
                 
                   comboBox.addItem(room_no);
               }
                stuffColumn.setCellEditor(new DefaultCellEditor(comboBox));
           

       } catch (SQLException ex) {
           Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
       // Show info for issue
       DefaultTableModel model2;
       model2=(DefaultTableModel) issueTable.getModel(); 
       model2.setRowCount(0);
       String query2=String.format("select RI.S_ID,RI.Issue_Name,RI.Issue_Descr,SI.Room_No from Student_Information SI inner join Response_Issue RI on SI.S_ID=RI.S_ID and ri.issue_status=0");
       
   //    String query2=String.format("select count(*) as c from Student_Information SI inner join Response_Issue RI on SI.S_ID=RI.S_ID and ri.issue_status=0");
       
       try {
          resultSet4 = statement2.executeQuery(query2);
       
            String stuid,issuename,issuedescription,roomno;
            TableColumn stuffColumn = issueTable.getColumnModel().getColumn(4);
             JComboBox comboBox = new JComboBox();
           while(resultSet4.next())
           {    

               stuid=resultSet4.getString("S_ID");
               issuename=resultSet4.getString("Issue_Name");
               issuedescription=resultSet4.getString("Issue_Descr");
               roomno=resultSet4.getString("Room_No");
               model2.insertRow(model2.getRowCount(),new Object[]{stuid,roomno,issuename,issuedescription,"     --Select Stuff-- "});

               String query4=String.format("select Stuff_ID from Stuff_Information where Manager_ID='101914004'");
               resultSet5 = statement.executeQuery(query4);
               while(resultSet5.next())
               {
                   String stuff_name=resultSet5.getString("Stuff_ID");
                 
                   comboBox.addItem(stuff_name);
               }
                stuffColumn.setCellEditor(new DefaultCellEditor(comboBox));
           }
          
           
           
           
       } catch (SQLException ex) {
           //Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
          
       }
   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendinglist = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gotoprofile = new javax.swing.JLabel();
        vacantRoomBtnLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addStudentBtnLabel = new javax.swing.JLabel();
        addbillBtnLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showstufflistBtnLabel = new javax.swing.JLabel();
        assignedWorkBtnLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(27, 124, 161));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seat Applicant List");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 110, 210, 40);

        pendinglist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Dept", "Regularity", "Father's Name", "Mother's Name", "Date of Birth", "Gender", "Home Address", "Assigned Room No", "Granted"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendinglist.setGridColor(new java.awt.Color(255, 255, 255));
        pendinglist.setRowHeight(30);
        jScrollPane1.setViewportView(pendinglist);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 160, 1180, 230);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Complain Or Seat Cancellation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 530, 360, 20);

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Room No", "Issue Name", "Issue Description", "Stuff ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(issueTable);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 570, 930, 280);

        jPanel2.setBackground(new java.awt.Color(24, 44, 97));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your Assigned Works");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManagerUpperPanelIcon.png"))); // NOI18N

        gotoprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profileIcon.png"))); // NOI18N
        gotoprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gotoprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoprofileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 621, Short.MAX_VALUE)
                .addComponent(gotoprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gotoprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1230, 105);

        vacantRoomBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vacantroom.png"))); // NOI18N
        vacantRoomBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vacantRoomBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vacantRoomBtnLabelMouseClicked(evt);
            }
        });
        jPanel1.add(vacantRoomBtnLabel);
        vacantRoomBtnLabel.setBounds(60, 430, 180, 50);

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("See vacant Rooms");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 400, 100, 30);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Selected Student");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(430, 410, 140, 20);

        addStudentBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addMealCose.png"))); // NOI18N
        addStudentBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudentBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStudentBtnLabelMouseClicked(evt);
            }
        });
        jPanel1.add(addStudentBtnLabel);
        addStudentBtnLabel.setBounds(450, 430, 70, 80);

        addbillBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addbills.png"))); // NOI18N
        addbillBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addbillBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbillBtnLabelMouseClicked(evt);
            }
        });
        jPanel1.add(addbillBtnLabel);
        addbillBtnLabel.setBounds(720, 430, 130, 60);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add Bills or FIne:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(720, 410, 190, 20);

        showstufflistBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/showStuffList.png"))); // NOI18N
        showstufflistBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showstufflistBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showstufflistBtnLabelMouseClicked(evt);
            }
        });
        jPanel1.add(showstufflistBtnLabel);
        showstufflistBtnLabel.setBounds(970, 600, 160, 50);

        assignedWorkBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AssignedWork.png"))); // NOI18N
        assignedWorkBtnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assignedWorkBtnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignedWorkBtnLabelMouseClicked(evt);
            }
        });
        jPanel1.add(assignedWorkBtnLabel);
        assignedWorkBtnLabel.setBounds(970, 660, 130, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vacantRoomBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vacantRoomBtnLabelMouseClicked
         VacantRoomList vr=new VacantRoomList();
        vr.setVisible(true);
    }//GEN-LAST:event_vacantRoomBtnLabelMouseClicked

    private void addStudentBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStudentBtnLabelMouseClicked
        int response = JOptionPane.showConfirmDialog(null, "Are you Confirm?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
       
        for(int i=0;i<rowcount;i++)
        {
            String idd= ((String)pendinglist.getValueAt(i,0)).toString();
            String S_name= ((String)pendinglist.getValueAt(i,1)).toString();
            String mail= ((String)pendinglist.getValueAt(i,2)).toString();
            String room_noo=((String)pendinglist.getValueAt(i,10)).toString();
          
            Boolean chk= ((Boolean)pendinglist.getValueAt(i,11)).booleanValue();
            int count_seat=0;
            if(chk && !room_noo.equals("--Select Room--"))
            {   
                
                
                
            
                // Updating student information table
                String query=String.format("update student_information set S_Status='1',Room_No='%s',S_Pass='%s' where S_ID='%s'",room_noo,idd,idd);
              
                try {
                    resultSet = statement.executeQuery(query);
                    // Fetching current seat no of assigned room
                      String query2=String.format("select Cur_No_Seat from Room_Information where Room_No='%s'",room_noo);
                      resultSet2 = statement.executeQuery(query2);
                      resultSet2.next();
                    count_seat=resultSet2.getInt("Cur_No_Seat");
                   
                        // Using procedure to update room information table
                         CallableStatement cstmt = null;
                           try {
                                 String SQL = "{call incre (?, ?)}";
                                 cstmt = conn.prepareCall (SQL);
                                cstmt.setString(1,room_noo);
                                cstmt.setInt(2,count_seat);
                              
                                 cstmt.execute();
   
                            }
                            catch (SQLException e) {
   
                                }
                            finally {
                                try {
                                    cstmt.close();
                                } catch (SQLException ex) {
                                     Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }
         
                      String message="Hello Dear "+S_name+",\n"+"Congratulations.Your Application for hall seat has been approved.\nYour login id : "+idd
                                +"\nYour Login pass : "+idd+"\nYour Room No: "+room_noo
                                 +"\nYou can change your pass later\nThanks \nBest Regards\nPseudo Hall Authority";
                      String sub="Seat Allotment Confirmation";
                      SendEmail SE=new SendEmail();
                      SE.main(mail,sub,message);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
            else if(((chk==false) && !room_noo.equals("--Select Room--"))||((chk==true) && room_noo.equals("--Select Room--")))
            {
               JFrame f;
               f=new JFrame();  
               JOptionPane.showMessageDialog(f,"Select the fields properly.","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        JFrame f=new JFrame();  
        JOptionPane.showMessageDialog(f,"Added To Database"); 
        }
         
      
      showInfo();
    }//GEN-LAST:event_addStudentBtnLabelMouseClicked

    private void addbillBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbillBtnLabelMouseClicked
        MonthlyBillAdd MDA=new MonthlyBillAdd(StuffIdpassed);
        this.setVisible(false);
        MDA.setVisible(true);
    }//GEN-LAST:event_addbillBtnLabelMouseClicked

    private void gotoprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoprofileMouseClicked
      Stuff_Interface SI= new Stuff_Interface(StuffIdpassed);
      this.setVisible(false);
      SI.setVisible(true);
    }//GEN-LAST:event_gotoprofileMouseClicked

    private void showstufflistBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showstufflistBtnLabelMouseClicked
        StuffListInterface sl=new StuffListInterface();
        sl.setVisible(true);
        
    }//GEN-LAST:event_showstufflistBtnLabelMouseClicked

    private void assignedWorkBtnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignedWorkBtnLabelMouseClicked
       int response = JOptionPane.showConfirmDialog(null, "Are you Confirm?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
        
        String query=String.format("select count(*) as c from Response_Issue where Issue_Status=0");
       try {
           resultSet = statement.executeQuery(query);
            resultSet.next();
           int no_of_row=resultSet.getInt("c");
          
           for(int i=0;i<no_of_row;i++)
           {
               
               String stuid= ((String)issueTable.getValueAt(i,0)).toString();
          
            
            String stuffid=((String)issueTable.getValueAt(i,4)).toString();
            //stuffid=stuffid.substring(1);
            if(!stuffid.equals("     --Select Stuff-- "))
             {
               
                String query5=String.format("update Response_Issue set Issue_Status=1,Stuff_ID='%s' where S_ID='%s'",stuffid,stuid);
                resultSet6 = statement.executeQuery(query5);
                 

             }
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
        JFrame f=new JFrame();  
         JOptionPane.showMessageDialog(f,"Assigned To Stuff"); 
     showInfo();    
    }//GEN-LAST:event_assignedWorkBtnLabelMouseClicked

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
            java.util.logging.Logger.getLogger(ManagerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addStudentBtnLabel;
    private javax.swing.JLabel addbillBtnLabel;
    private javax.swing.JLabel assignedWorkBtnLabel;
    private javax.swing.JLabel gotoprofile;
    private javax.swing.JTable issueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pendinglist;
    private javax.swing.JLabel showstufflistBtnLabel;
    private javax.swing.JLabel vacantRoomBtnLabel;
    // End of variables declaration//GEN-END:variables
}
