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
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Connection;
import mypkg.Utility;
import java.sql.PreparedStatement;
import bank.management.system.Login;
/**
 *
 * @author Mohammed Arshad
 */
public class SignUpOne extends JFrame implements ActionListener{
    
    JTextField nametextfield, fnametextfield, emailtextfield, addresstextfield, citytextfield, statetextfield, pincodetextfield;
    JDateChooser datechooser;
    JRadioButton male, female, married, unmarried, other;
    JButton nextbutton, backbutton;
    
    long formNumber;
    
    SignUpOne(){
        
        setSize(850, 850);
        setLocation(490, 150);
        setTitle("Sign Up Form");
        Container s=getContentPane();                                           //or getContentPane().setBackground(Color.WHITE);
        s.setBackground(Color.WHITE);
        setLayout(null);
        
/*<!--_______________________________________________________________________-->*/

        Random ran=new Random();
        formNumber=Math.abs(ran.nextLong()%9000L+1000L);
        
        JLabel heading1=new JLabel("Application Form No.: "+formNumber);;
        Font font=new Font("Raleway",Font.BOLD,32);
        heading1.setFont(font);
        heading1.setBounds(225, 50, 450, 35);                                    //850-250=600 and 600/2=300 so for this frame 300 is the center  
        add(heading1);
        
/*<!--_______________________________________________________________________-->*/

        JLabel heading2=new JLabel("Page 1: Personal Details");
        heading2.setFont(new Font("Raleway",Font.BOLD,27));
        heading2.setBounds(300, 100, 350, 30);
        add(heading2);
        
/*<!--_______________________________________________________________________-->*/

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(190, 180, 90, 28);                                       //850-90=760 and 730/4=190
        add(name);
        
        nametextfield=new JTextField();
        nametextfield.setBounds(370, 180, 280, 28);                              //760-280=480 and 480/4=120
        add(nametextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(190, 230, 150, 28);
        add(fname);
        
        fnametextfield=new JTextField();
        fnametextfield.setBounds(370, 230, 280, 28);
        add(fnametextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(190, 280, 150, 28);
        add(dob);
        
        datechooser=new JDateChooser();
        datechooser.setBounds(370, 280, 280, 28);
        add(datechooser);
        
/*<!--_______________________________________________________________________-->*/

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(190, 330, 150, 28);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(370, 330, 70, 28);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(580, 330, 70, 28);
        add(female);
        
        ButtonGroup group=new ButtonGroup();
        group.add(male);
        group.add(female);
       
/*<!--_______________________________________________________________________-->*/

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(190, 380, 150, 28);
        add(email);
        
        emailtextfield=new JTextField();
        emailtextfield.setBounds(370, 380, 280, 28);
        add(emailtextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(190, 430, 150, 28);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(370, 430, 70, 28);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(470, 430 , 100, 28);
        add(unmarried);
        
        other=new JRadioButton("Others");
        other.setBackground(Color.WHITE);
        other.setBounds(580, 430, 70, 28);
        add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
/*<!--_______________________________________________________________________-->*/

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(190, 480, 150, 28);
        add(address);
        
        addresstextfield=new JTextField();
        addresstextfield.setBounds(370, 480, 280, 28);
        add(addresstextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(190, 530, 150, 28);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setBounds(370, 530, 280, 28);
        add(citytextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(190, 580, 150, 28);
        add(state);
        
        statetextfield=new JTextField();
        statetextfield.setBounds(370, 580, 280, 28);
        add(statetextfield);
        
/*<!--_______________________________________________________________________-->*/

        JLabel pincode=new JLabel("PIN Code:");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(190, 630, 150, 28);
        add(pincode);
        
        pincodetextfield=new JTextField();
        pincodetextfield.setBounds(370, 630, 280, 28);
        add(pincodetextfield);
        
/*<!--_______________________________________________________________________-->*/

        nextbutton=new JButton("Next");
        nextbutton.setBounds(550, 680, 100, 29);
        nextbutton.setBackground(Color.BLACK);
        nextbutton.setForeground(Color.WHITE);
        nextbutton.addActionListener(this);
        add(nextbutton);
        
        backbutton=new JButton("Back");
        backbutton.setForeground(Color.WHITE);
        backbutton.setBackground(Color.BLACK);
        backbutton.setBounds(370, 680, 100, 28);
        backbutton.addActionListener(this);
        add(backbutton);
        
/*<!--_______________________________________________________________________-->*/

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formNo;
        if(ae.getSource()==nextbutton){
            
            formNo=""+formNumber;
            
            String name=nametextfield.getText();
            
            String fname=fnametextfield.getText();
            
            String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
            
            String gender="null";
            if(male.isSelected()){
                gender="Male";
            }else if(female.isSelected()){
                gender="Female";
            }
            
            String email=emailtextfield.getText();
            
            String marital="null";
            if(married.isSelected()){
                marital="Married";
            }else if(unmarried.isSelected()){
                marital="Unmarried";
            }else if(other.isSelected()){
                marital="Other";
            }
            
            String address=addresstextfield.getText();
            
            String city=citytextfield.getText();
            
            String state=statetextfield.getText();
            
            String pincode=pincodetextfield.getText();
                
            try{
                
                if(name.equals("")||fname.equals("")||dob.equals("")||gender.equals("null")||email.equals("")||marital.equals("null")||address.equals("")||city.equals("")||state.equals("")||pincode.equals("")){
                    JOptionPane.showMessageDialog(null, "All Fields are Required!");
                }
                
                else{
                
                    Utility ut=new Utility();
                   
                    Connection con=ut.connect();
                    
                    String sql="INSERT INTO signup_one VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setString(1, formNo);                    
                    ps.setString(2, name);
                    ps.setString(3, fname);
                    ps.setString(4, dob);
                    ps.setString(5, gender);
                    ps.setString(6, email);
                    ps.setString(7, marital);
                    ps.setString(8, address);
                    ps.setString(9, city);
                    ps.setString(10, state);
                    ps.setString(11, pincode);
                    
                    int n=ps.executeUpdate();
                    
                    if(n>0){
                        setVisible(false);
                        new SignUpTwo(formNo).setVisible(true);
//                        new ShowSignUpData(formNo).setVisible(true);
                    }
                }
            }catch(Exception e){
                System.out.println(e); 
            }
            
        }else if(ae.getSource()==backbutton){
            
            setVisible(false);
            new Login().setVisible(true);
        }
        System.out.println("at ending FormNumber="+formNumber);
    }

    public static void main(String[] args) {
        
        new SignUpOne();
    }
}
/*
CREATE TABLE signup
(formno INT PRIMARY KEY,
name VARCHAR(30),
father_name VARCHAR(30),
date_of_birth VARCHAR(20),
gender VARCHAR(20),
email VARCHAR(50),
marital VARCHAR(20),
address VARCHAR(50),
city VARCHAR(30),
state VARCHAR(50),
pincode VARCHAR(20)
);
*/