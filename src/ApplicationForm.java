
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ApplicationForm extends javax.swing.JFrame {

   Connection conn;
   Statement statement;
   ResultSet resultSet;
   ResultSetMetaData resultsetMetaData;
   String name,id,email,phone,altphone,father,mother,add;
   int flag=1;
    public ApplicationForm() {
        initComponents();
        
        OracleConnection OC=new OracleConnection();
        String[] stringArray = OC.connection();

        try{
           conn=DriverManager.getConnection(stringArray[0],stringArray[1],stringArray[2]);
            if(conn!=null)
            {
                
                System.out.println("Connection Sucessful in Application Form");
                statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   
            }
            
            
        }catch(SQLException e){
            System.out.println("Connection failed");
        }
       
        name_invalid.setVisible(false);
        id_invalid.setVisible(false);
        email_invalid.setVisible(false);
        phn_invalid.setVisible(false);
        altphn_invalid.setVisible(false);
        father_invalid.setVisible(false);
        mother_invalid.setVisible(false);
        address_invalid.setVisible(false);
        warning.setVisible(false);
    }

   
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
        phonefeild = new javax.swing.JTextField();
        alternatefeild = new javax.swing.JTextField();
        fatherfeild = new javax.swing.JTextField();
        motherfeild = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressarea = new javax.swing.JTextArea();
        deptcombobox = new javax.swing.JComboBox<>();
        regularitycombobox = new javax.swing.JComboBox<>();
        gendercombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        id_invalid = new javax.swing.JLabel();
        name_invalid = new javax.swing.JLabel();
        email_invalid = new javax.swing.JLabel();
        phn_invalid = new javax.swing.JLabel();
        altphn_invalid = new javax.swing.JLabel();
        father_invalid = new javax.swing.JLabel();
        mother_invalid = new javax.swing.JLabel();
        address_invalid = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();

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
                .addContainerGap(661, Short.MAX_VALUE))
        );
        upperpanelLayout.setVerticalGroup(
            upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperpanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(upperlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        fulllpanel.add(upperpanel);
        upperpanel.setBounds(0, 0, 980, 90);

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
        phonenotitle.setBounds(50, 360, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Date Of Birth:");
        fulllpanel.add(jLabel1);
        jLabel1.setBounds(50, 450, 180, 30);

        fatherlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fatherlabel.setText("Father's Name:");
        fulllpanel.add(fatherlabel);
        fatherlabel.setBounds(50, 500, 150, 20);

        motherlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motherlabel.setText("Mother's Name:");
        fulllpanel.add(motherlabel);
        motherlabel.setBounds(50, 550, 100, 20);

        genderlabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        genderlabel.setText("Gender:");
        fulllpanel.add(genderlabel);
        genderlabel.setBounds(50, 680, 80, 20);

        addresslabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addresslabel.setText("Address: ");
        fulllpanel.add(addresslabel);
        addresslabel.setBounds(50, 620, 80, 15);

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        fulllpanel.add(submitBtn);
        submitBtn.setBounds(340, 730, 140, 40);

        namefeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namefeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                namefeildFocusLost(evt);
            }
        });
        fulllpanel.add(namefeild);
        namefeild.setBounds(280, 140, 350, 30);

        idfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idfeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idfeildFocusLost(evt);
            }
        });
        fulllpanel.add(idfeild);
        idfeild.setBounds(280, 189, 350, 30);

        emailfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailfeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailfeildFocusLost(evt);
            }
        });
        fulllpanel.add(emailfeild);
        emailfeild.setBounds(280, 229, 350, 30);

        phonefeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phonefeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phonefeildFocusLost(evt);
            }
        });
        fulllpanel.add(phonefeild);
        phonefeild.setBounds(280, 359, 350, 30);

        alternatefeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        alternatefeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                alternatefeildFocusLost(evt);
            }
        });
        fulllpanel.add(alternatefeild);
        alternatefeild.setBounds(280, 400, 350, 30);

        fatherfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fatherfeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fatherfeildFocusLost(evt);
            }
        });
        fulllpanel.add(fatherfeild);
        fatherfeild.setBounds(280, 500, 350, 30);

        motherfeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        motherfeild.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                motherfeildFocusLost(evt);
            }
        });
        fulllpanel.add(motherfeild);
        motherfeild.setBounds(280, 550, 350, 30);

        addressarea.setColumns(20);
        addressarea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressarea.setRows(5);
        addressarea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressareaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(addressarea);

        fulllpanel.add(jScrollPane1);
        jScrollPane1.setBounds(280, 600, 350, 50);

        deptcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "EECE", "CE", "ME", "AE", "NSE", "IPE", "PME" }));
        fulllpanel.add(deptcombobox);
        deptcombobox.setBounds(280, 271, 350, 30);

        regularitycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Irregular", " " }));
        fulllpanel.add(regularitycombobox);
        regularitycombobox.setBounds(280, 320, 350, 30);

        gendercombobox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gendercombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male", " " }));
        fulllpanel.add(gendercombobox);
        gendercombobox.setBounds(280, 670, 350, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Alternative Phone Number:");
        fulllpanel.add(jLabel2);
        jLabel2.setBounds(50, 400, 180, 30);

        jDateChooser1.setDateFormatString("DD-MON-YY");
        fulllpanel.add(jDateChooser1);
        jDateChooser1.setBounds(280, 450, 350, 30);

        id_invalid.setForeground(new java.awt.Color(255, 0, 0));
        id_invalid.setText("idd");
        fulllpanel.add(id_invalid);
        id_invalid.setBounds(660, 200, 220, 14);

        name_invalid.setForeground(new java.awt.Color(255, 0, 0));
        name_invalid.setText("nam");
        fulllpanel.add(name_invalid);
        name_invalid.setBounds(660, 150, 220, 14);

        email_invalid.setForeground(new java.awt.Color(255, 0, 0));
        email_invalid.setText("email");
        fulllpanel.add(email_invalid);
        email_invalid.setBounds(660, 240, 260, 14);

        phn_invalid.setForeground(new java.awt.Color(255, 0, 0));
        phn_invalid.setText("phn");
        fulllpanel.add(phn_invalid);
        phn_invalid.setBounds(660, 370, 250, 14);

        altphn_invalid.setForeground(new java.awt.Color(255, 0, 0));
        altphn_invalid.setText("altphn");
        fulllpanel.add(altphn_invalid);
        altphn_invalid.setBounds(660, 410, 310, 14);

        father_invalid.setForeground(new java.awt.Color(255, 0, 0));
        father_invalid.setText("father");
        fulllpanel.add(father_invalid);
        father_invalid.setBounds(660, 510, 300, 14);

        mother_invalid.setForeground(new java.awt.Color(255, 0, 0));
        mother_invalid.setText("mother");
        fulllpanel.add(mother_invalid);
        mother_invalid.setBounds(660, 560, 280, 14);

        address_invalid.setForeground(new java.awt.Color(255, 0, 0));
        address_invalid.setText("address");
        fulllpanel.add(address_invalid);
        address_invalid.setBounds(660, 620, 290, 14);

        warning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("* One of the required field is incomplete");
        fulllpanel.add(warning);
        warning.setBounds(570, 740, 300, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fulllpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fulllpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
       // String name= namefeild.getText();
     //   String id = idfeild.getText();
      //  String email= emailfeild.getText();
      
        String dept=deptcombobox.getSelectedItem().toString();
        String reg=regularitycombobox.getSelectedItem().toString();
        java.util.Date date=jDateChooser1.getDate();
        java.sql.Date sDate = new java.sql.Date(date.getTime()); 
        String gen=gendercombobox.getSelectedItem().toString();
        
        
       // String phone= phonefeild.getText();
       // String altphone = alternatefeild.getText();
       // String father= fatherfeild.getText();
       // String mother= motherfeild.getText();
        
      //  String add=addressarea.getText();
        
        // Convert to sql date
        
        
        int flag=1;
        JFrame f=new JFrame(); 
        /*
        //  Checking Name format
        for(int i=0;i<name.length();i++)
        {
            if ((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || (name.charAt(i)=='.')|| (name.charAt(i)==' ') )
            {
                continue;
            }
            else
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Format of name is incorrect","Alert",JOptionPane.WARNING_MESSAGE);
                namefeild.setText("");
                break;
            }
        }
        
        //  Checking ID format
        for(int i=0;i<id.length();i++)
        {
            if (id.charAt(i)>='0' && id.charAt(i)<='9')
            {
                continue;
            }
            else
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Id should contain only number","Alert",JOptionPane.WARNING_MESSAGE);
                idfeild.setText("");
                break;
            }
        }
        
        //  Checking Email format
        if(! email.contains("@gmail.com"))
        {
            flag=0;
            JOptionPane.showMessageDialog(f,"Format of email is incorrect","Alert",JOptionPane.WARNING_MESSAGE);
            emailfeild.setText("");
        }
        
        //  Checking Phone Number format
        if(phone.length()==11)
        {
            String phnstrt="";
            phnstrt=phnstrt+phone.charAt(0);
            phnstrt=phnstrt+phone.charAt(1);
            phnstrt=phnstrt+phone.charAt(2);
            if(!(phnstrt!="013"|| phnstrt!="015"||phnstrt!="016"|| phnstrt!="017"||phnstrt!="018"|| phnstrt!="019"))
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Invalid format of phone number","Alert",JOptionPane.WARNING_MESSAGE);
                phonefeild.setText("");
            }
        }
        
       
        else
        {
            flag=0;
            JOptionPane.showMessageDialog(f,"Phone number should contain 11 digit","Alert",JOptionPane.WARNING_MESSAGE);
            phonefeild.setText("");
        }
        
        
        //  Checking Alternative Phone Number format
        if(altphone.length()>0)
        {
            String altphnstrt="";
            altphnstrt=altphnstrt+altphone.charAt(0);
            altphnstrt=altphnstrt+altphone.charAt(1);
            altphnstrt=altphnstrt+altphone.charAt(2);
            if(!(altphnstrt!="013"|| altphnstrt!="015"||altphnstrt!="016"|| altphnstrt!="017"||altphnstrt!="018"|| altphnstrt!="019"))
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Invalid format of alternate phone number","Alert",JOptionPane.WARNING_MESSAGE);
                alternatefeild.setText("");
            }
        }
       

        //  Checking Father's Name format
        for(int i=0;i<father.length();i++)
        {
            if ((father.charAt(i)>='A' && father.charAt(i)<='Z')||(father.charAt(i)>='a' && father.charAt(i)<='z')||father.charAt(i)=='.'|| father.charAt(i)==' ')
            {
                continue;
            }
            else
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Format of Father's name is incorrect","Alert",JOptionPane.PLAIN_MESSAGE);
                fatherfeild.setText("");
                break;
            }
        }
        
        //  Checking mother's Name format
        for(int i=0;i<mother.length();i++)
        {
            if ((mother.charAt(i)>='A' && mother.charAt(i)<='Z')||(mother.charAt(i)>='a' && mother.charAt(i)<='z')||mother.charAt(i)=='.'|| mother.charAt(i)==' ')
            {
                continue;
            }
            else
            {
                flag=0;
                JOptionPane.showMessageDialog(f,"Format of Mother's name is incorrect","Alert",JOptionPane.WARNING_MESSAGE);
                motherfeild.setText("");
                break;
            }
        }
        
               
        */
        
        
         if(name.isEmpty() || id.isEmpty() || email.isEmpty() || phone.isEmpty() || father.isEmpty() || mother.isEmpty() || add.isEmpty())
         {
                
                //flag=0;
                warning.setVisible(true);
                //JOptionPane.showMessageDialog(f,"One of the required field is empty","Alert",JOptionPane.WARNING_MESSAGE);
         }
         
        
        else
        {
            warning.setVisible(false);
            String query=String.format("insert into student_information values('%s','%s','@'||hall_pass_seq.nextval||'#','%s','%s','%s','%s','%s',to_date('%tF %n','yyyy-mm-dd'),'%s','%s','0','NA')",id,name,email,dept,reg,father,mother,sDate,gen,add);
            
            
            try {
                id_invalid.setVisible(false);
                resultSet = statement.executeQuery(query);
                this.setVisible(false);
                JOptionPane.showMessageDialog(f,"Application Received!!!");
            } catch (SQLException ex) {
                //System.out.println("Failed to insert");
                id_invalid.setText("ID already exist");
                id_invalid.setVisible(true);
                //JOptionPane.showMessageDialog(f,"ID already exist","Alert",JOptionPane.WARNING_MESSAGE);
                idfeild.setText("");
                //Logger.getLogger(ApplicationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            ///Phone no insert
             String query3="insert into Student_Contact values(?,?)";
            try {
                PreparedStatement ps=conn.prepareStatement(query3);
                 ps.setString(1,id);
                 ps.setString(2,phone);
                 ps.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Phone no not inserted");
                Logger.getLogger(ApplicationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ///AlternativePhone no insert(if any)
            if(altphone.length()>0)
            {
                 String query4="insert into Student_Contact values(?,?)";
                try {
                    PreparedStatement ps2=conn.prepareStatement(query4);
                      ps2.setString(1,id);
                    ps2.setString(2,altphone);
                    ps2.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println("Alt Phone no not inserted");
                    Logger.getLogger(ApplicationForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            
       }
       
       
        
//        System.out.println("Name: "+name);
//        System.out.println("ID: "+id);
//        System.out.println("email: "+email);
//        System.out.println("dept: "+dept);
//        System.out.println("reg: "+reg);
//        System.out.println("phone: "+phone);
//        System.out.println("altphone: "+altphone);
//        System.out.println("father: "+father);
//        System.out.println("mother: "+mother);      
//        System.out.println("Gender: "+gen);
//        System.out.println("Address: "+add);  
//          System.out.println("Date "+s_dob);
    }//GEN-LAST:event_submitBtnActionPerformed

    private void namefeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namefeildFocusLost
         name_invalid.setVisible(false);
         name= namefeild.getText();
         if(name.length()==0)
         {
             
             name_invalid.setText("* Name is a required field");
             name_invalid.setVisible(true);
         }
         else
         {
            for(int i=0;i<name.length();i++)
            {
                if ((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z') || (name.charAt(i)=='.')|| (name.charAt(i)==' ') )
                {
                    name_invalid.setVisible(false);
                    continue;
                }
                else
                {
                    name_invalid.setText("* Name format is wrong");
                    name_invalid.setVisible(true);
                    namefeild.setText("");
                    break;
                }
            }
         }
    }//GEN-LAST:event_namefeildFocusLost

    private void idfeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idfeildFocusLost
        id_invalid.setVisible(false);
        id = idfeild.getText();
        if(id.length()==0)
         {
             id_invalid.setText("* ID is a required field");
             id_invalid.setVisible(true);
         }
        else
        {
            if(id.length()==9)
            {
                for(int i=0;i<id.length();i++)
                {
                    if (id.charAt(i)>='0' && id.charAt(i)<='9')
                    {   
                        id_invalid.setVisible(false);
                        continue;
                    }
                    else
                    {
                        id_invalid.setText("* ID must have only digits");
                        id_invalid.setVisible(true);
                        idfeild.setText("");
                        break;
                    }
                }
            }
            else
            {
                id_invalid.setText("* ID must consist 9 digit");
                id_invalid.setVisible(true);
            }  
        }
    }//GEN-LAST:event_idfeildFocusLost

    private void emailfeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailfeildFocusLost
        email_invalid.setVisible(false);
        email= emailfeild.getText();
        if(email.length()==0)
         {
             email_invalid.setText("* Email is a required field");
             email_invalid.setVisible(true);
         }
        else
        {
            if(! email.contains("@gmail.com"))
            {
                email_invalid.setText("* Email must end with @gmail.com");
                email_invalid.setVisible(true);
                emailfeild.setText("");
            }
            else
            {
                email_invalid.setVisible(false);
            }
        }
    }//GEN-LAST:event_emailfeildFocusLost

    private void phonefeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phonefeildFocusLost
        phn_invalid.setVisible(false);
        phone= phonefeild.getText();
        if(phone.length()==0)
        {
            phn_invalid.setText("* Phone no is a required field");
            phn_invalid.setVisible(true);
        }
        else if(phone.length()==11)
        {
            String phnstrt="";
            phnstrt=phnstrt+phone.charAt(0);
            phnstrt=phnstrt+phone.charAt(1);
            phnstrt=phnstrt+phone.charAt(2);
            if(!(phnstrt!="013"||phnstrt!="014"|| phnstrt!="015"||phnstrt!="016"|| phnstrt!="017"||phnstrt!="018"|| phnstrt!="019"))
            {
                 phn_invalid.setText("Invalid format of phone number");
                 phn_invalid.setVisible(true); 
                 phonefeild.setText("");
            }
            else
            {
                phn_invalid.setVisible(false); 
            }
        }
        else
        {
            phn_invalid.setText("Phone number should contain 11 digit");
            phn_invalid.setVisible(true); 
            phonefeild.setText("");
        }
            
    }//GEN-LAST:event_phonefeildFocusLost

    private void alternatefeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alternatefeildFocusLost
        altphn_invalid.setVisible(false);
        altphone = alternatefeild.getText();
        if(altphone.length()>0)
        {
            if(altphone.length()==11)
            {
                String altphnstrt="";
                altphnstrt=altphnstrt+altphone.charAt(0);
                altphnstrt=altphnstrt+altphone.charAt(1);
                altphnstrt=altphnstrt+altphone.charAt(2);
                if(!(altphnstrt!="013"||altphnstrt!="014"|| altphnstrt!="015"||altphnstrt!="016"|| altphnstrt!="017"||altphnstrt!="018"|| altphnstrt!="019"))
                {
                    altphn_invalid.setText("Invalid format of alternative phone number");
                    altphn_invalid.setVisible(true); 
                    alternatefeild.setText("");
                }
                else if(phone.equals(altphone))
                {
                    altphn_invalid.setText("Phone no and alternative phone no can't be same");
                    altphn_invalid.setVisible(true); 
                    alternatefeild.setText("");
                }
                else
                {
                    altphn_invalid.setVisible(false); 
                }
            }
            else
            {
                altphn_invalid.setText("Phone number should contain 11 digit");
                altphn_invalid.setVisible(true); 
                alternatefeild.setText("");
            }  
        }
        else
        {
            altphn_invalid.setVisible(false); 
        }
    }//GEN-LAST:event_alternatefeildFocusLost

    private void fatherfeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fatherfeildFocusLost
        father_invalid.setVisible(false);
        father= fatherfeild.getText();
        
        if(father.length()==0)
         {
             father_invalid.setText("* Father's Name is a required field");
             father_invalid.setVisible(true);
         }
         else
         {
            for(int i=0;i<father.length();i++)
            {
                if ((father.charAt(i)>='A' && father.charAt(i)<='Z') || (father.charAt(i)>='a' && father.charAt(i)<='z') || (father.charAt(i)=='.')|| (father.charAt(i)==' ') )
                {
                    father_invalid.setVisible(false);
                    continue;
                }
                else
                {
                    father_invalid.setText("* Name format is wrong");
                    father_invalid.setVisible(true);
                    fatherfeild.setText("");
                    break;
                }
            }
         }
    }//GEN-LAST:event_fatherfeildFocusLost

    private void motherfeildFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motherfeildFocusLost
        mother_invalid.setVisible(false);
        mother= motherfeild.getText();
        
        if(mother.length()==0)
         {
             mother_invalid.setText("* Mother's Name is a required field");
             mother_invalid.setVisible(true);
         }
         else
         {
            for(int i=0;i<mother.length();i++)
            {
                if ((mother.charAt(i)>='A' && mother.charAt(i)<='Z') || (mother.charAt(i)>='a' && mother.charAt(i)<='z') || (mother.charAt(i)=='.')|| (mother.charAt(i)==' ') )
                {
                    mother_invalid.setVisible(false);
                    continue;
                }
                else
                {
                    mother_invalid.setText("* Name format is wrong");
                    mother_invalid.setVisible(true);
                    motherfeild.setText("");
                    break;
                }
            }
         }
    }//GEN-LAST:event_motherfeildFocusLost

    private void addressareaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressareaFocusLost
        address_invalid.setVisible(false);
        add=addressarea.getText();
        if(add.length()==0)
        {
            address_invalid.setText("* Address is a required field");
            address_invalid.setVisible(true);
        }
        else
        {
            address_invalid.setVisible(false);
        }
    }//GEN-LAST:event_addressareaFocusLost

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
    private javax.swing.JLabel address_invalid;
    private javax.swing.JTextArea addressarea;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JTextField alternatefeild;
    private javax.swing.JLabel altphn_invalid;
    private javax.swing.JComboBox<String> deptcombobox;
    private javax.swing.JLabel deptitle;
    private javax.swing.JLabel email_invalid;
    private javax.swing.JTextField emailfeild;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JLabel father_invalid;
    private javax.swing.JTextField fatherfeild;
    private javax.swing.JLabel fatherlabel;
    private javax.swing.JPanel fulllpanel;
    private javax.swing.JComboBox<String> gendercombobox;
    private javax.swing.JLabel genderlabel;
    private javax.swing.JLabel id_invalid;
    private javax.swing.JTextField idfeild;
    private javax.swing.JLabel idlabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mother_invalid;
    private javax.swing.JTextField motherfeild;
    private javax.swing.JLabel motherlabel;
    private javax.swing.JLabel name_invalid;
    private javax.swing.JTextField namefeild;
    private javax.swing.JLabel nametitle;
    private javax.swing.JLabel phn_invalid;
    private javax.swing.JTextField phonefeild;
    private javax.swing.JLabel phonenotitle;
    private javax.swing.JLabel reglabel;
    private javax.swing.JComboBox<String> regularitycombobox;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel upperlabel;
    private javax.swing.JPanel upperpanel;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
