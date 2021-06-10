
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ManagerInterface extends javax.swing.JFrame {
    
   Connection conn;
   Statement statement;
   ResultSet resultSet,resultSet2,resultSet3,resultSet4;
   
   ResultSetMetaData resultsetMetaData;
   int rowcount;
   
    public ManagerInterface() {
        initComponents();
    }

    public ManagerInterface(String ID) {
        initComponents();
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        
        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Manager Interface");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
           query=String.format("select * from student_information where S_Status='0'");
           resultSet = statement.executeQuery(query);
           
           resultsetMetaData =resultSet.getMetaData();
           
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
                
                model.insertRow(model.getRowCount(),new Object[]{id,name,email,dept,regularity,father,mother,DOB_String,gender,address," ",false});
           }

       } catch (SQLException ex) {
           Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
       // Show info for issue
       DefaultTableModel model2;
       model2=(DefaultTableModel) issueTable.getModel(); 
       String query2=String.format("select RI.S_ID,RI.Issue_Name,RI.Issue_Descr,SI.Room_No from Student_Information SI inner join Response_Issue RI on SI.S_ID=RI.S_ID and ri.issue_status=0");
       try {
           resultSet4 = statement.executeQuery(query2);
            String stuid,issuename,issuedescription,roomno;
           while(resultSet4.next())
           {
               stuid=resultSet4.getString("S_ID");
               issuename=resultSet4.getString("Issue_Name");
               issuedescription=resultSet4.getString("Issue_Descr");
               roomno=resultSet4.getString("Room_No");
               model2.insertRow(model2.getRowCount(),new Object[]{stuid,roomno,issuename," ",issuedescription});
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
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
        addStdBtn = new javax.swing.JButton();
        vacantRoomButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        assignworkbtn = new javax.swing.JButton();
        stufflistbtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("Seat Applicant List");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 40, 130, 40);

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
        jScrollPane1.setViewportView(pendinglist);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 150, 1180, 300);

        addStdBtn.setText("Add Selected Students");
        addStdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStdBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addStdBtn);
        addStdBtn.setBounds(500, 490, 190, 23);

        vacantRoomButton.setText("Vacant Rooms");
        vacantRoomButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vacantRoomButtonMouseClicked(evt);
            }
        });
        jPanel1.add(vacantRoomButton);
        vacantRoomButton.setBounds(310, 490, 160, 23);

        jLabel2.setText("Student Complain Or Seat Cancellation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 520, 220, 20);

        assignworkbtn.setText("Assign Work");
        assignworkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignworkbtnActionPerformed(evt);
            }
        });
        jPanel1.add(assignworkbtn);
        assignworkbtn.setBounds(540, 880, 110, 23);

        stufflistbtn.setText("Show Stuff List");
        stufflistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stufflistbtnActionPerformed(evt);
            }
        });
        jPanel1.add(stufflistbtn);
        stufflistbtn.setBounds(340, 880, 120, 23);

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Room No", "Issue Name", "Stuff ID", "Issue Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(issueTable);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(40, 560, 930, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Add All the approved students
    private void addStdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStdBtnActionPerformed
        
        for(int i=0;i<rowcount;i++)
        {
            String idd= ((String)pendinglist.getValueAt(i,0)).toString();
            String room_noo=((String)pendinglist.getValueAt(i,10)).toString();
            room_noo=room_noo.substring(1);  // Removing extra space for the front of the string
            Boolean chk= ((Boolean)pendinglist.getValueAt(i,11)).booleanValue();
            int count_seat=0;
            if(chk)
            {
                // Updating student information table
                String query=String.format("update student_information set S_Status='1',Room_No='%s' where S_ID='%s'",room_noo,idd);
              
                try {
                    resultSet = statement.executeQuery(query);
                    // Fetching current seat no of assigned room
                      String query2=String.format("select Cur_No_Seat from Room_Information where Room_No='%s'",room_noo);
                      resultSet2 = statement.executeQuery(query2);
                      resultSet2.next();
                    count_seat=resultSet2.getInt("Cur_No_Seat");
                    System.out.println(count_seat);
                    count_seat++;
                    String query3=String.format("update Room_Information set Cur_No_Seat='%d' where Room_No='%s'",count_seat,room_noo);
                    resultSet3 = statement.executeQuery(query3);
                    
                        // Using procedure to update room information table
//                      String query3=String.format("DECLARE\n" +
//                       "rooms Room_Information.Room_No%TYPE:='%s';\n" +
//                       "value Integer :='%d';"
//                              + "BEGIN\n" +
//                       "incre('%s','%d');\n" +
//                       "END ",room_noo,count_seat,room_noo,count_seat);
//                        resultSet3 = statement.executeQuery(query3);


                    
                } catch (SQLException ex) {
                    Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_addStdBtnActionPerformed

    private void vacantRoomButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vacantRoomButtonMouseClicked
        VacantRoomList vr=new VacantRoomList();
        vr.setVisible(true);
    }//GEN-LAST:event_vacantRoomButtonMouseClicked

    private void stufflistbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stufflistbtnActionPerformed
        StuffListInterface sl=new StuffListInterface();
        sl.setVisible(true);
    }//GEN-LAST:event_stufflistbtnActionPerformed

    private void assignworkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignworkbtnActionPerformed
      String query=String.format("select count(*) as c from Response_Issue where Issue_Status=0");
       try {
           resultSet = statement.executeQuery(query);
            resultSet.next();
           int no_of_row=resultSet.getInt("c");
           System.out.println(no_of_row);
           for(int i=0;i<no_of_row;i++)
           {
               //Object ob = issueTable.getModel().getValueAt(i,3);
               String stuffid=((String)issueTable.getValueAt(i,3)).toString();
               System.out.println(stuffid);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ManagerInterface.class.getName()).log(Level.SEVERE, null, ex);
       }
          
        
    }//GEN-LAST:event_assignworkbtnActionPerformed

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
    private javax.swing.JButton addStdBtn;
    private javax.swing.JButton assignworkbtn;
    private javax.swing.JTable issueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pendinglist;
    private javax.swing.JButton stufflistbtn;
    private javax.swing.JButton vacantRoomButton;
    // End of variables declaration//GEN-END:variables
}
