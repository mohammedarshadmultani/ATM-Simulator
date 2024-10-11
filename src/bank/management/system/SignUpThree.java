/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammed Arshad
 */
public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton savingRadioButton, currentRadioButton, fdRadioButton, rdRadioButton, declareRadioButton;
    JCheckBox atmCard, internetBanking, mobileBanking, emailSMS, cheque, eStatement;
    JButton cancelButton, submitButton;
    
    String formNo;
   
    SignUpThree(String formNo){
        
        this.formNo=formNo;
        
        setSize(850, 850);
        setLocation(570, 150);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Sign Up Form Three");
        setLayout(null);
        
/*<!--_______________________________________________________________________-->*/
        
        JLabel heading1=new JLabel("Page 3: Account Details");
        heading1.setBounds(250, 100, 350, 35);                                  //850-350 = 500/2=250
        heading1.setFont(new Font("Raleway",Font.BOLD,28));
        add(heading1);
/*<!--_______________________________________________________________________-->*/

        JLabel accountType=new JLabel("Account Type:");
        accountType.setFont(new Font("Arial",Font.BOLD,22));
        accountType.setBounds(130, 180, 280, 28);                               //850-150 = 600/4=150
        add(accountType);
        
        savingRadioButton=new JRadioButton("Saving Account");
        savingRadioButton.setFont(new Font("Arial",Font.BOLD,17));
        savingRadioButton.setBounds(150, 220, 280, 19);                         //
//        savingRadioButton.setBackground(Color.WHITE);
        add(savingRadioButton);
        
        currentRadioButton=new JRadioButton("Current Account");
        currentRadioButton.setFont(new Font("Arial",Font.BOLD,17));
        currentRadioButton.setBounds(150, 260, 280, 19);                        //
//        currentRadioButton.setBackground(Color.WHITE);
        add(currentRadioButton);
        
        fdRadioButton=new JRadioButton("Fixed Deposit Account");
        fdRadioButton.setFont(new Font("Arial",Font.BOLD,17));
        fdRadioButton.setBounds(430, 220, 280, 19);                             //850-150-180 = 420
//        fdRadioButton.setBackground(Color.WHITE);
        add(fdRadioButton);
        
        rdRadioButton=new JRadioButton("Recurring Deposit Account");
        rdRadioButton.setFont(new Font("Arial",Font.BOLD,17));
        rdRadioButton.setBounds(430, 260, 280, 19);                             //
//        rdRadioButton.setBackground(Color.WHITE);
        add(rdRadioButton);
        
        ButtonGroup accountTypeGroup=new ButtonGroup();
        accountTypeGroup.add(savingRadioButton);
        accountTypeGroup.add(currentRadioButton);
        accountTypeGroup.add(fdRadioButton);
        accountTypeGroup.add(rdRadioButton);
        
/*<!--_______________________________________________________________________-->*/

        JLabel cardNumber=new JLabel("Card Number:");
        cardNumber.setFont(new Font("Arial",Font.BOLD,22));
        cardNumber.setBounds(130, 320, 200, 28);
        add(cardNumber);
        
        JLabel cardDetails=new JLabel("Your 16-digits Card Number");
        cardDetails.setFont(new Font("Arial",Font.BOLD,10));
        cardDetails.setBounds(130, 345, 200, 12);
        add(cardDetails);
        
        JLabel generatedCardNumber=new JLabel("XXXX-XXXX-XXXX-4184");
        generatedCardNumber.setFont(new Font("Arial",Font.BOLD,20));        
        generatedCardNumber.setBounds(430, 320, 250, 20);
        add(generatedCardNumber);
        
/*<!--_______________________________________________________________________-->*/

        JLabel pinNumber=new JLabel("PIN Number:");
        pinNumber.setFont(new Font("Arial",Font.BOLD,22));
        pinNumber.setBounds(130, 380, 150, 28);
        add(pinNumber);
        
        JLabel pinDetails=new JLabel("Your 4-digits PIN Number");
        pinDetails.setFont(new Font("Arial",Font.BOLD,10));
        pinDetails.setBounds(130, 405, 200, 12);
        add(pinDetails);
        
        JLabel generatedPINNumber=new JLabel("XXXX");
        generatedPINNumber.setFont(new Font("Arial",Font.BOLD,20));
        generatedPINNumber.setBounds(430, 380, 100, 25);
        add(generatedPINNumber);

/*<!--_______________________________________________________________________-->*/

        JLabel serviceRequired=new JLabel("Service Required:");
        serviceRequired.setFont(new Font("Arial",Font.BOLD,22));
        serviceRequired.setBounds(130, 440, 250, 28);
        add(serviceRequired);
        
        atmCard=new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Arial",Font.BOLD,16));
        atmCard.setBounds(150, 480, 250, 18);
        add(atmCard);
        
        mobileBanking=new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Arial",Font.BOLD,16));
        mobileBanking.setBounds(150, 520, 250, 18);
        add(mobileBanking);
        
        cheque=new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Arial",Font.BOLD,16));
        cheque.setBounds(150, 560, 250, 18);
        add(cheque);
        
        internetBanking=new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Arial",Font.BOLD,16));        
        internetBanking.setBounds(430, 480, 250, 18);
        add(internetBanking);
        
        emailSMS=new JCheckBox("Email & SMS Alters");
        emailSMS.setFont(new Font("Arial",Font.BOLD,16));
        emailSMS.setBounds(430, 520, 250, 18);
        add(emailSMS);
        
        eStatement=new JCheckBox("Electronic Statement");
        eStatement.setFont(new Font("Arial",Font.BOLD,16));
        eStatement.setBounds(430, 560, 250, 18);
        add(eStatement);

/*<!--_______________________________________________________________________-->*/

        declareRadioButton=new JRadioButton("I hereby declares that the entired above details are correct to best of my knowledge.");
        declareRadioButton.setFont(new Font("Arial",Font.BOLD,13));
        declareRadioButton.setBounds(130, 620, 650, 14);
        add(declareRadioButton);

/*<!--_______________________________________________________________________-->*/

        cancelButton=new JButton("Cancel");
//        cancelButton.setFont(new Font("Arial",Font.BOLD,18));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setBounds(130, 660, 100, 28);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        submitButton=new JButton("Submit");
//        nextButton.setFont(new Font("Arial",Font.BOLD,18));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.setBounds(580, 660, 100, 28);
        submitButton.addActionListener(this);
        add(submitButton);
        
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submitButton){
            
            String accountType="null";
            if(savingRadioButton.isSelected()){
                accountType="Saving Account";
            }else if(currentRadioButton.isSelected()){
                accountType="Current Account";
            }else if(fdRadioButton.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(rdRadioButton.isSelected()){
                accountType="Recurring Deposit Account";
            }
            
            Random random=new Random();
            
            String cardNumber=""+Math.abs((random.nextLong()% 90000000L) + 1234567000000000L);
            
            String pinNumber=""+Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String serviceRequired="";
            if(atmCard.isSelected()){
                serviceRequired=serviceRequired+" ATM Card";
            }else if(mobileBanking.isSelected()){
                serviceRequired=serviceRequired+" Mobile Banking";
            }else if(cheque.isSelected()){
                serviceRequired=serviceRequired+" Cheque Book";
            }else if(internetBanking.isSelected()){
                serviceRequired=serviceRequired+" Internet Banking";
            }else if(emailSMS.isSelected()){
                serviceRequired=serviceRequired+" Email & SMS Alters";
            }else if(eStatement.isSelected()){
                serviceRequired=serviceRequired+" Electronic Statement";
            }
            
            String declaration="";                                              System.out.println(declaration);
            if(declareRadioButton.isSelected()){
                declaration="Yes";
            }
            
            if(accountType.equals("")||cardNumber.equals("")||pinNumber.equals("")||serviceRequired.equals("")||declaration.equals("")){
                    JOptionPane.showMessageDialog(null, "*All fields are required*");
            }else{
                try{
                    mypkg.Utility ut=new mypkg.Utility();
                    Connection con=ut.connect();
                    
                    PreparedStatement ps1=con.prepareStatement("INSERT INTO signup_three VALUES(?, ?, ?, ?, ?)");
                    ps1.setString(1, formNo);
                    ps1.setString(2, accountType);
                    ps1.setString(3, cardNumber);
                    ps1.setString(4, pinNumber);
                    ps1.setString(5, serviceRequired);
                    int rows1=ps1.executeUpdate();
                    System.out.println("Data Stored Successfully For ps1"+rows1);
                    
                    PreparedStatement ps2=con.prepareStatement("INSERT INTO login VALUES(?, ?, ?)");            //'"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')"
                    ps2.setString(1, formNo);
                    ps2.setString(2, cardNumber);
                    ps2.setString(3, pinNumber);
                    int rows2=ps2.executeUpdate();
                    System.out.println("Data Stored Successfully for ps2"+rows2);
                    
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\nPIN Number: "+pinNumber);
                    setVisible(false);
//                    new Login().setVisible(true);
                    new Deposit(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==cancelButton){
            setVisible(false);
            new SignUpTwo("").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignUpThree("");
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

CREATE TABLE signup_three(
form_no VARCHAR(20),
account_type VARCHAR(40),
card_number VARCHAR(20),
pin_number VARCHAR(10),
service_required VARCHAR(100)
);

CREATE TABLE login(
form_no VARCHAR(20),
card_number VARCHAR(20),
pin_number VARCHAR(10)
);
*/