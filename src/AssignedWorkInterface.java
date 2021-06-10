
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class AssignedWorkInterface extends javax.swing.JFrame {

    String id;
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData resultsetMetaData;
    public AssignedWorkInterface() {
        initComponents();
    }
    public AssignedWorkInterface(String idd) {
        initComponents();
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();
        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            { 
                System.out.println("Connection Sucessful in Assigned Work Interface");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            }    
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
        id=idd;
        showData();
    }
    
    void showData()
    {
       DefaultTableModel model;
       model=(DefaultTableModel) assignedworklisttable.getModel(); 
       String query1=String.format("select RI.S_ID,SI.Room_No,RI.Issue_Descr,RI.Issue_Cost from Student_Information SI inner join Response_Issue RI on SI.S_ID=RI.S_ID and RI.issue_status=1");
        try {
            resultSet = statement.executeQuery(query1);
            String stuid,sturoom,issue;
            int cost;
            while(resultSet.next())
           {
               stuid=resultSet.getString("S_ID");
               sturoom=resultSet.getString("Room_No");
               issue=resultSet.getString("Issue_Descr");
               model.insertRow(model.getRowCount(),new Object[]{stuid,sturoom,issue,"",false});
           }
        } catch (SQLException ex) {
            Logger.getLogger(AssignedWorkInterface.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assignedworklisttable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Assigned Work List");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 40, 142, 36);

        assignedworklisttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Room No", "Issue Description", "Issue Cost", "Solve Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(assignedworklisttable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 870, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AssignedWorkInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignedWorkInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignedWorkInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignedWorkInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignedWorkInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignedworklisttable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
