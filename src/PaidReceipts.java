
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PaidReceipts extends javax.swing.JFrame {

   Connection conn;
   Statement statement,statement2;
   ResultSet resultSet,resultSet2,resultSet3;
   ResultSetMetaData resultsetMetaData;
    public PaidReceipts() {
        initComponents();
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        
        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Paid Receipt Interface");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                statement2=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            }
            
            
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
        showData();
    }
    
    void showData()
    {
        DefaultTableModel model;
        model=(DefaultTableModel) PaidReceiptTable.getModel(); 
        model.setRowCount(0);
        imageLabel.setIcon(null);
        String query=String.format("select S_ID,RECEIPT from Bills where RECEIPT IS NOT NULL");
       try {
           resultSet=statement.executeQuery(query);
           while(resultSet.next())
           {
               String stu_id=resultSet.getString("S_ID");
                model.insertRow(model.getRowCount(),new Object[]{stu_id,"",false});

           }
         
         
          //PaidReceiptTable.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor("201914049"));
       } catch (SQLException ex) {
           Logger.getLogger(PaidReceipts.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        PaidReceiptTable = new javax.swing.JTable();
        imageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        viewreceiptLabel = new javax.swing.JLabel();
        clearbilllabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(857, 479));

        jPanel1.setBackground(new java.awt.Color(27, 124, 161));
        jPanel1.setLayout(null);

        PaidReceiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Paid Amount", "View Receipt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PaidReceiptTable.setRowHeight(30);
        jScrollPane1.setViewportView(PaidReceiptTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 530, 360);
        jPanel1.add(imageLabel);
        imageLabel.setBounds(630, 30, 340, 618);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Paid Bill List");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 170, 30);

        viewreceiptLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewreceipt.png"))); // NOI18N
        viewreceiptLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewreceiptLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewreceiptLabelMouseClicked(evt);
            }
        });
        jPanel1.add(viewreceiptLabel);
        viewreceiptLabel.setBounds(60, 480, 150, 40);

        clearbilllabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clearbill.png"))); // NOI18N
        clearbilllabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbilllabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearbilllabelMouseClicked(evt);
            }
        });
        jPanel1.add(clearbilllabel);
        clearbilllabel.setBounds(260, 480, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewreceiptLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewreceiptLabelMouseClicked
             String query=String.format("select count(*) as c from Bills where RECEIPT IS NOT NULL");
             try {
             resultSet = statement.executeQuery(query);
             resultSet.next();
             int rowcount=resultSet.getInt("c");
             for(int i=0;i<rowcount;i++)
             {
                Boolean chk= ((Boolean)PaidReceiptTable.getValueAt(i,2)).booleanValue();
                if(chk)
                {
                    String studidd= ((String)PaidReceiptTable.getValueAt(i,0)).toString();
                    String query1=String.format("select RECEIPT from Bills where S_ID='%s'",studidd);
                    resultSet2= statement2.executeQuery(query1);
                    resultSet2.next();
                    byte[] img = resultSet2.getBytes("RECEIPT");  
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    imageLabel.setIcon(newImage);
                    
                    break;
                }
            }
       } catch (SQLException ex) {
           Logger.getLogger(PaidReceipts.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_viewreceiptLabelMouseClicked

    private void clearbilllabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbilllabelMouseClicked
        int response = JOptionPane.showConfirmDialog(null, "Are you Confirm?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            String query=String.format("select count(*) as c from Bills where RECEIPT IS NOT NULL");
       try {
           resultSet = statement.executeQuery(query);
           resultSet.next();
           int rowcount=resultSet.getInt("c");
            for(int i=0;i<rowcount;i++)
            {
                Boolean chk= ((Boolean)PaidReceiptTable.getValueAt(i,2)).booleanValue();
                if(chk)
                {
                    String studidd= ((String)PaidReceiptTable.getValueAt(i,0)).toString();
                    Integer paid_amount= (Integer)PaidReceiptTable.getValueAt(i, 1);
                    
                    
                    
                    String query1=String.format("select * from Bills where S_ID='%s'",studidd);
                    resultSet2= statement2.executeQuery(query1);
                    resultSet2.next();
                    int hall_bill,mess_bill,laundry_bill,fine,additional_bill;
                    hall_bill=resultSet2.getInt("Hall_Bill");
                    mess_bill=resultSet2.getInt("Mess_Bill");
                    laundry_bill=resultSet2.getInt("Laundary_Bill");
                    fine=resultSet2.getInt("Fine");
                    additional_bill=resultSet2.getInt("Additional_Bill"); 
                    if(paid_amount>0)
                    {
                        if(paid_amount>=hall_bill)
                        {
                            paid_amount-=hall_bill;
                            hall_bill=0;
                        }
                        else
                        {
                            hall_bill-=paid_amount;
                            paid_amount=0;
                        }      
                    }
                    
                    if(paid_amount>0)
                    {
                        if(paid_amount>=mess_bill)
                        {
                            paid_amount-=mess_bill;
                            mess_bill=0;
                        }
                        else
                        {
                            mess_bill-=paid_amount;
                            paid_amount=0;
                        }      
                    }
                    
                    if(paid_amount>0)
                    {
                        if(paid_amount>=laundry_bill)
                        {
                            paid_amount-=laundry_bill;
                            laundry_bill=0;
                        }
                        else
                        {
                            laundry_bill-=paid_amount;
                            paid_amount=0;
                        }      
                    }
                    
                    if(paid_amount>0)
                    {
                        if(paid_amount>=fine)
                        {
                            paid_amount-=fine;
                            fine=0;
                        }
                        else
                        {
                            fine-=paid_amount;
                            paid_amount=0;
                        }      
                    }
                    
                    if(paid_amount>0)
                    {
                        if(paid_amount>=additional_bill)
                        {
                            paid_amount-=additional_bill;
                            additional_bill=0;
                        }
                        else
                        {
                            additional_bill-=paid_amount;
                            paid_amount=0;
                        }      
                    }
                    
                    String query2=String.format("update Bills set Hall_Bill=%d,Mess_Bill=%d,Laundary_Bill=%d,Fine=%d,Additional_Bill=%d,RECEIPT=null where S_ID='%s'",hall_bill,mess_bill,laundry_bill,fine,additional_bill,studidd);
                    resultSet3= statement2.executeQuery(query2);
                    
                    break;
                }
            }
            showData();
       } catch (SQLException ex) {
           Logger.getLogger(PaidReceipts.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
    }//GEN-LAST:event_clearbilllabelMouseClicked

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
            java.util.logging.Logger.getLogger(PaidReceipts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaidReceipts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaidReceipts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaidReceipts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaidReceipts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PaidReceiptTable;
    private javax.swing.JLabel clearbilllabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel viewreceiptLabel;
    // End of variables declaration//GEN-END:variables
}