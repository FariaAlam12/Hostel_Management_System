
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Office_Employee_Interface extends javax.swing.JFrame {

    
   Connection conn;
   Statement statement;
   ResultSet resultSet,resultSet2;
   String St_id,stuff_id;
   int total_cost=0,total_breakfast=0,total_lunch=0,total_dinner=0;
     public Office_Employee_Interface() {
        initComponents();
     }
    public Office_Employee_Interface(String idd) {
        initComponents();
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        
        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Office_Employee_Interface");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            }
            
            
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
        stuff_id=idd;
        showdata();
    }

     void showdata()
    {
        ///For Mill tabele
        DefaultTableModel model,model2;
        model=(DefaultTableModel) MillDetailTable.getModel(); 
        String query=String.format("select * from Student_Mill");
       try {
           resultSet = statement.executeQuery(query);
          
           int BS,LS,DS,total;
           while(resultSet.next())
           {
               St_id=resultSet.getString("S_ID");
               total=resultSet.getInt("Total");
               BS=resultSet.getInt("Breakfast_Status");
               LS=resultSet.getInt("Launch_Status");
               DS=resultSet.getInt("Dinner_Status");
                String B_take="                         ✘",L_take="                         ✘",D_take="                         ✘";
               if(BS==1)
               {
                   B_take="                         ✓";
                   total_breakfast++;
               }
               if(LS==1)
               {
                   L_take="                         ✓";
                   total_lunch++;
               }
               if(DS==1)
               {
                   D_take="                        ✓";
                   total_dinner++;
               }
               total_cost+=total;
                model.insertRow(model.getRowCount(),new Object[]{St_id,total,B_take,L_take,D_take});
               
           }
            model.insertRow(model.getRowCount(),new Object[]{"Total Calculation",total_cost,total_breakfast+"",total_lunch+"",total_dinner+""});
           
       } catch (SQLException ex) {
           Logger.getLogger(Office_Employee_Interface.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       //For Seat cancel table 
         model2=(DefaultTableModel) seatcanceltable.getModel();
         String query2=String.format("select S_ID,Issue_Descr from Response_Issue where Stuff_ID='%s' and Issue_Status=1",stuff_id);
         
       try {
           resultSet = statement.executeQuery(query2);
           String s_id,issue_des;
            while(resultSet.next())
           {
               s_id=resultSet.getString("S_ID");
               issue_des=resultSet.getString("Issue_Descr");
               model2.insertRow(model2.getRowCount(),new Object[]{s_id,issue_des,false});
           }
          
       } catch (SQLException ex) {
           Logger.getLogger(Office_Employee_Interface.class.getName()).log(Level.SEVERE, null, ex);
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
        MillDetailTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seatcanceltable = new javax.swing.JTable();
        CancelRequestUpdateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Student Mill Details");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 30, 200, 40);

        MillDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Total Cost", "Breakfast", "Lunch", "Dinner"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MillDetailTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 80, 870, 220);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seat Calcellation Requests:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 350, 210, 40);

        seatcanceltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "Reason", "Approved"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(seatcanceltable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 420, 490, 150);

        CancelRequestUpdateBtn.setText("Update");
        CancelRequestUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelRequestUpdateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CancelRequestUpdateBtn);
        CancelRequestUpdateBtn.setBounds(300, 633, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelRequestUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelRequestUpdateBtnActionPerformed
        String query3=String.format("select count(*) as c from Response_Issue where Stuff_ID='%s' and Issue_Status=1",stuff_id);
       try {
           resultSet = statement.executeQuery(query3);
           resultSet.next();
           int no_of_row=resultSet.getInt("c");
           
           for(int i=0;i<no_of_row;i++)
            {
               
                String stuid= ((String)seatcanceltable.getValueAt(i,0)).toString();
                
                 Boolean chk= ((Boolean)seatcanceltable.getValueAt(i,2)).booleanValue();
                 if(chk)
                 {
                      String query4=String.format("update Response_Issue set Issue_Status=2 where S_ID='%s'",stuid);
                      resultSet2 = statement.executeQuery(query4);
                 }
                 else
                 {
                      String query4=String.format("update Response_Issue set Issue_Status=3 where S_ID='%s'",stuid);
                      resultSet2 = statement.executeQuery(query4);
                 }
            }
       } catch (SQLException ex) {
           Logger.getLogger(Office_Employee_Interface.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }//GEN-LAST:event_CancelRequestUpdateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Office_Employee_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Office_Employee_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Office_Employee_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Office_Employee_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Office_Employee_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelRequestUpdateBtn;
    private javax.swing.JTable MillDetailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable seatcanceltable;
    // End of variables declaration//GEN-END:variables
}
