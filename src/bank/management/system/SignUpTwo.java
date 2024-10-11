/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import mypkg.Utility;
import java.sql.Statement;
/**
 *
 * @author Mohammed Arshad
 */
public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField pannoJTextField, aadhaarJTextField;
    JComboBox religionJComboBox, categoryJComboBox, incomeJComboBox, qualificationJComboBox, occupationJComboBox, citizenJComboBox, existingJComboBOx;
    JRadioButton citizenYes, citizenNo, existingYes, existingNo;
    JButton nextButton, backButton;
    
    String formNo;
    
    SignUpTwo(String formNo){
        
        this.formNo=formNo;
        System.out.println("this.FormNo= "+formNo);
        setSize(850, 850);
        setLocation(490, 150);
        setTitle("Sign Up Form Two");
        Container container=getContentPane();                                   //or getContentPane().setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        setLayout(null);
        
/*<!--_______________________________________________________________________-->*/
        
        JLabel heading2=new JLabel("Page 2: Additional Details");
        heading2.setFont(new Font("Raleway",Font.BOLD,27));
        heading2.setBounds(260, 100, 350, 35);
        add(heading2);
        
/*<!--_______________________________________________________________________-->*/
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Arial",Font.BOLD,20));
        religion.setBounds(190, 180, 90, 28);
        add(religion);
        
        String religionValue[]={"Hindu","Muslim","Sikh","Christian","Jain","Jews","Zoroast"};
        
        religionJComboBox=new JComboBox(religionValue);
        religionJComboBox.setBounds(370, 180, 280, 28);                              
        religionJComboBox.setBackground(Color.WHITE);
        add(religionJComboBox);

/*<!--_______________________________________________________________________-->*/
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Arial",Font.BOLD,20));
        category.setBounds(190, 230, 150, 28);
        add(category);
        
        String categoryValue[]={"General","OBC","ST","SC","EWS"};
        
        categoryJComboBox=new JComboBox(categoryValue);
        categoryJComboBox.setBounds(370, 230, 280, 28);
        categoryJComboBox.setBackground(Color.WHITE);
        add(categoryJComboBox);

/*<!--_______________________________________________________________________-->*/

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Arial",Font.BOLD,20));
        income.setBounds(190, 280, 150, 28);
        add(income);
        
        String incomeValue[]={"NULL","< 1,50,000","< 2,50,000","< 5,00,00","upto 10,00,00"};
        
        incomeJComboBox=new JComboBox(incomeValue);
        incomeJComboBox.setBounds(370, 280, 280, 28);
        incomeJComboBox.setBackground(Color.WHITE);
        add(incomeJComboBox);
        
/*<!--_______________________________________________________________________-->*/

        JLabel educational=new JLabel("Education");
        educational.setFont(new Font("Arial",Font.BOLD,20));
        educational.setBounds(190, 330, 150, 28);
        add(educational);
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Arial",Font.BOLD,20));
        qualification.setBounds(190, 360, 150, 28);
        add(qualification);

        String qualificationValue[]={"Matriculate","Post-Matriculate","Graduate","Post-Graduate","Doctrate","Others"};
        qualificationJComboBox=new JComboBox(qualificationValue);
        qualificationJComboBox.setBounds(370, 360, 280, 28);
        qualificationJComboBox.setBackground(Color.WHITE);
        add(qualificationJComboBox);

/*<!--_______________________________________________________________________-->*/
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Arial",Font.BOLD,20));
        occupation.setBounds(190, 410, 150, 28);
        add(occupation);
        
        String occupationValue[]={"Student","Self-Employed","Sarlied","Business","Retired","Others"};
        
        occupationJComboBox=new JComboBox(occupationValue);
        occupationJComboBox.setBounds(370, 410, 280, 28);
        occupationJComboBox.setBackground(Color.WHITE);
        add(occupationJComboBox);

/*<!--_______________________________________________________________________-->*/
        
        JLabel panno=new JLabel("PAN Number:");
        panno.setFont(new Font("Arial",Font.BOLD,20));
        panno.setBounds(190, 460, 150, 28);
        add(panno);
        
        pannoJTextField=new JTextField();
        pannoJTextField.setBounds(370, 460, 280, 28);
        add(pannoJTextField);

/*<!--_______________________________________________________________________-->*/
        
        JLabel aadhaar=new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Arial",Font.BOLD,20));
        aadhaar.setBounds(190, 510, 200, 28);
        add(aadhaar);
        
        aadhaarJTextField=new JTextField();
        aadhaarJTextField.setBounds(370, 510, 280, 28);
        add(aadhaarJTextField);

/*<!--_______________________________________________________________________-->*/

        JLabel citizen=new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Arial",Font.BOLD,20));
        citizen.setBounds(190, 560, 150, 28);
        add(citizen);

        citizenYes=new JRadioButton("Yes");
        citizenYes.setBackground(Color.WHITE);
        citizenYes.setBounds(370, 560, 70, 28);
        add(citizenYes);
        
        citizenNo=new JRadioButton("No");
        citizenNo.setBackground(Color.WHITE);
        citizenNo.setBounds(580, 560, 70, 28);
        add(citizenNo);
        
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(citizenYes);
        citizenGroup.add(citizenNo);
        
/*<!--_______________________________________________________________________-->*/
        
        JLabel account=new JLabel("Existing Account:");
        account.setFont(new Font("Arial",Font.BOLD,20));
        account.setBounds(190, 610, 250, 28);
        add(account);
        
        existingYes=new JRadioButton("Yes");
        existingYes.setBackground(Color.WHITE);
        existingYes.setBounds(370, 610, 70, 28);
        add(existingYes);
        
        existingNo=new JRadioButton("No");
        existingNo.setBackground(Color.WHITE);
        existingNo.setBounds(580, 610, 70, 28);
        add(existingNo);

        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(existingYes);
        accountGroup.add(existingNo);
        
        nextButton=new JButton("Next");
        nextButton.setBounds(550, 660, 100, 29);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);
        
        backButton=new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.setBounds(370, 660, 100, 28);
        backButton.addActionListener(this);
        add(backButton);
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        
        String religion=(String)religionJComboBox.getSelectedItem();
        
        String category=(String)categoryJComboBox.getSelectedItem();
        
        String income=(String)incomeJComboBox.getSelectedItem();
        
        String educationQualification=(String)qualificationJComboBox.getSelectedItem();
        
        String occupation=(String)occupationJComboBox.getSelectedItem();
        
        String panNo=(String)pannoJTextField.getText();
        
        String aadhaarNo=(String)aadhaarJTextField.getText();
        
        String seniorCitizen="null";
        if(citizenYes.isSelected()){
            seniorCitizen="Yes";
        }else if(citizenNo.isSelected()){
            seniorCitizen="No";
        }
        
        String existingAccount="null";
        if(existingYes.isSelected()){
            existingAccount="Yes";
        }else if(existingNo.isSelected()){
            existingAccount="No";
        }
        
        try{
            Utility ut=new Utility();
            
            Connection con=ut.connect();
            
            String sql="INSERT INTO signup_two VALUES('"+formNo+"', '"+religion+"', '"+category+"', '"+income+"', '"+educationQualification+"', '"+occupation+"', '"+panNo+"', '"+aadhaarNo+"', '"+seniorCitizen+"', '"+existingAccount+"' )";
            
            Statement st=con.createStatement();
            
            int rows=st.executeUpdate(sql);
            
            System.out.println("Data Stored Successully");
            
            setVisible(false);
            new SignUpThree(formNo).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        if(ae.getSource()==backButton){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
/*
CREATE TABLE signup_two2
(religion VARCHAR(20),
category VARCHAR(20),
income VARCHAR(25),
e_qualication VARCHAR(25),
occupation VARCHAR(25),
pan_no VARCHAR(30),
aadhaar_no VARCHAR(30),
s_citizen VARCHAR(10),
e_account VARCHAR(10)
);


CREATE TABLE new_signup_two
(form_no VARCHAR(20),
religion VARCHAR(20),
category VARCHAR(20),
income VARCHAR(25),
e_qualication VARCHAR(25),
occupation VARCHAR(25),
pan_no VARCHAR(30),
aadhaar_no VARCHAR(30),
s_citizen VARCHAR(10),
e_account VARCHAR(10)
);

INSERT INTO new_signup_two (form_no, religion, category, income, e_qualication, occupation, pan_no, aadhaar_no, s_citizen, e_account)
SELECT NULL, religion, category, income, e_qualication, occupation, pan_no, aadhaar_no, s_citizen, e_account
FROM signup_two;
*/