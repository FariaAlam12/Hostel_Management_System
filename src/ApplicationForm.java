/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ApplicationForm extends javax.swing.JFrame {

    /**
     * Creates new form ApplicationForm
     */
    public ApplicationForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fulllpanel = new javax.swing.JPanel();
        upperpanel = new javax.swing.JPanel();
        upperlabel = new javax.swing.JLabel();
        nametitle = new javax.swing.JLabel();
        idlabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        deptitle = new javax.swing.JLabel();
        reglabel = new javax.swing.JLabel();
        phonenotitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fatherlabel = new javax.swing.JLabel();
        motherlabel = new javax.swing.JLabel();
        genderlabel = new javax.swing.JLabel();
        addresslabel = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        namefeild = new javax.swing.JTextField();
        idfeild = new javax.swing.JTextField();
        emailfeild = new javax.swing.JTextField();
        phonofeild = new javax.swing.JTextField();
        alternatefeild = new javax.swing.JTextField();
        fatherfeild = new javax.swing.JTextField();
        motherfeild = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        deptcombobox = new javax.swing.JComboBox<>();
        regularitycombobox = new javax.swing.JComboBox<>();
        gendercombobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fulllpanel.setBackground(new java.awt.Color(255, 255, 255));
        fulllpanel.setLayout(null);

        upperpanel.setBackground(new java.awt.Color(71, 179, 155));

        upperlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        upperlabel.setForeground(new java.awt.Color(255, 255, 255));
        upperlabel.setText("Fill Up The Required Info");

        javax.swing.GroupLayout upperpanelLayout = new javax.swing.GroupLayout(upperpanel);
        upperpanel.setLayout(upperpanelLayout);
        upperpanelLayout.setHorizontalGroup(
            upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperpanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(upperlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        upperpanelLayout.setVerticalGroup(
            upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperpanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(upperlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        fulllpanel.add(upperpanel);
        upperpanel.setBounds(0, 0, 790, 90);

        nametitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nametitle.setText("Name:");
        fulllpanel.add(nametitle);
        nametitle.setBounds(50, 140, 60, 30);

        idlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idlabel.setText("ID:");
        fulllpanel.add(idlabel);
        idlabel.setBounds(50, 193, 60, 20);

        emaillabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emaillabel.setText("Email:");
        fulllpanel.add(emaillabel);
        emaillabel.setBounds(50, 233, 50, 20);

        deptitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deptitle.setText("Department:");
        fulllpanel.add(deptitle);
        deptitle.setBounds(50, 270, 90, 30);

        reglabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reglabel.setText("Regularity Status:");
        fulllpanel.add(reglabel);
        reglabel.setBounds(50, 315, 110, 20);

        phonenotitle.setBackground(new java.awt.Color(255, 255, 255));
        phonenotitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phonenotitle.setText("Phone Number:");
        fulllpanel.add(phonenotitle);
        phonenotitle.setBounds(50, 350, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Alternative Phone Number:");
        fulllpanel.add(jLabel1);
        jLabel1.setBounds(50, 385, 180, 30);

        fatherlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fatherlabel.setText("Father's Name:");
        fulllpanel.add(fatherlabel);
        fatherlabel.setBounds(50, 440, 150, 20);

        motherlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherlabel.setText("Mother's Name:");
        fulllpanel.add(motherlabel);
        motherlabel.setBounds(50, 480, 100, 20);

        genderlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        genderlabel.setText("Gender:");
        fulllpanel.add(genderlabel);
        genderlabel.setBounds(50, 520, 80, 20);

        addresslabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addresslabel.setText("Address: ");
        fulllpanel.add(addresslabel);
        addresslabel.setBounds(50, 580, 80, 15);

        submitBtn.setText("Submit");
        fulllpanel.add(submitBtn);
        submitBtn.setBounds(340, 660, 140, 40);

        namefeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(namefeild);
        namefeild.setBounds(280, 140, 350, 30);

        idfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(idfeild);
        idfeild.setBounds(280, 189, 350, 30);

        emailfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(emailfeild);
        emailfeild.setBounds(280, 229, 350, 30);

        phonofeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(phonofeild);
        phonofeild.setBounds(280, 359, 350, 30);

        alternatefeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(alternatefeild);
        alternatefeild.setBounds(280, 400, 350, 30);

        fatherfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(fatherfeild);
        fatherfeild.setBounds(280, 440, 350, 30);

        motherfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fulllpanel.add(motherfeild);
        motherfeild.setBounds(280, 479, 350, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        fulllpanel.add(jScrollPane1);
        jScrollPane1.setBounds(280, 560, 350, 50);

        deptcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "EECE", "CE", "ME", "AE", "NSE", "IPE", "PME" }));
        fulllpanel.add(deptcombobox);
        deptcombobox.setBounds(280, 271, 350, 30);

        regularitycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Irregular", " " }));
        fulllpanel.add(regularitycombobox);
        regularitycombobox.setBounds(280, 320, 350, 30);

        gendercombobox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gendercombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male", " " }));
        fulllpanel.add(gendercombobox);
        gendercombobox.setBounds(280, 520, 350, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fulllpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fulllpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addresslabel;
    private javax.swing.JTextField alternatefeild;
    private javax.swing.JComboBox<String> deptcombobox;
    private javax.swing.JLabel deptitle;
    private javax.swing.JTextField emailfeild;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JTextField fatherfeild;
    private javax.swing.JLabel fatherlabel;
    private javax.swing.JPanel fulllpanel;
    private javax.swing.JComboBox<String> gendercombobox;
    private javax.swing.JLabel genderlabel;
    private javax.swing.JTextField idfeild;
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField motherfeild;
    private javax.swing.JLabel motherlabel;
    private javax.swing.JTextField namefeild;
    private javax.swing.JLabel nametitle;
    private javax.swing.JLabel phonenotitle;
    private javax.swing.JTextField phonofeild;
    private javax.swing.JLabel reglabel;
    private javax.swing.JComboBox<String> regularitycombobox;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel upperlabel;
    private javax.swing.JPanel upperpanel;
    // End of variables declaration//GEN-END:variables
}
