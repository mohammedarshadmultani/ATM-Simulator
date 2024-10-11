/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Mohammed Arshad
 */
public class Login extends JFrame implements ActionListener{
    
    JButton signinbutton, clearbutton, signupbutton;
    JTextField cardnotextfield;
    JPasswordField pinnotextfield;
    
    Login(){
        
        //Here we set the title of our desktop-app
        setTitle("Automatic Teller Machine");
        
        //Frame Color        
        getContentPane().setBackground(Color.WHITE);
        
        //we set the layout null because we have to off the by default layouts
        setLayout(null);
        
        //here we set the image or icon of the desktop-app
        ImageIcon imic2=new ImageIcon(ClassLoader.getSystemResource("images/Bank Logo.png"));
        
//        Image im=imic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    //here we commented this two statements because we set the image size already in figma.
//        ImageIcon imic2=new ImageIcon(im);
        JLabel imlab=new JLabel(imic2);
        imlab.setBounds(250, 65, 100, 100);
        add(imlab);
        
        //now big heading we are writing using the JLabel
        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Raleway", Font.BOLD, 42));
        text.setBounds(390, 100, 360, 40);
        add(text);

        //now label for field one we are writing using the JLabel
        JLabel cardno=new JLabel("Card No.:");
        cardno.setFont(new Font("osward", Font.BOLD, 22));
        cardno.setBounds(270, 235, 350, 40);
        add(cardno);
        
        //now label for field two we are writing using the JLabel
        JLabel pinno=new JLabel("PIN No.:");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(270, 310, 90, 20);
        add(pinno);
        
        cardnotextfield=new JTextField();
        cardnotextfield.setBounds(450, 234, 280, 30);
        cardnotextfield.setFont(new Font("Arial",Font.PLAIN, 16));
        add(cardnotextfield);
        
        pinnotextfield=new JPasswordField();
        pinnotextfield.setBounds(450, 310, 280, 30);
        pinnotextfield.setFont(new Font("Arial", Font.PLAIN, 16));
        add(pinnotextfield);
        
        signinbutton=new JButton("Sign In");
        signinbutton.setBounds(450, 386, 120, 30);
        signinbutton.setBackground(Color.BLACK);
        signinbutton.setForeground(Color.WHITE);
        signinbutton.addActionListener(this);                                   //here addActionListener() method catch the click event when we click on this button.
        signinbutton.setFont(new Font("Jaldi", Font.BOLD, 16));
        add(signinbutton);
        
        clearbutton=new JButton("Clear");
        clearbutton.setBackground(Color.BLACK);
        clearbutton.setForeground(Color.WHITE);
        clearbutton.setBounds(610, 386, 120, 30);
        clearbutton.addActionListener(this);
        clearbutton.setFont(new Font("Arial", Font.BOLD, 16));
        add(clearbutton);
        
        signupbutton=new JButton("Sign Up");
        signupbutton.setBackground(Color.BLACK);
        signupbutton.setForeground(Color.WHITE);
        signupbutton.setBounds(450, 462, 280, 30);
        signupbutton.addActionListener(this);
        signupbutton.setFont(new Font("Arial", Font.BOLD, 16));
        add(signupbutton);
        
        //we set the total size of the super-container or frame of our desktop-app
        setSize(1000, 650);
        setVisible(true);
        
        //we set the frame location that frame will open from center side or left side or right side etc
        setLocation(460, 240);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==signinbutton){
            
            String cardno=cardnotextfield.getText();
            String pinno=pinnotextfield.getText();
            
            if(cardno.equals("")){
                JOptionPane.showMessageDialog(null, "*Please fill the Card Number");
                
            }else if(pinno.equals("")){
                JOptionPane.showMessageDialog(null, "*Please Fill the PIN Number");
            
            }else{
                try{
                    mypkg.Utility ut=new mypkg.Utility();
                    Connection con=ut.connect();
                    PreparedStatement ps=con.prepareStatement("SELECT card_number, pin_number FROM login WHERE card_number=? AND pin_number=?");
                    ps.setString(1, cardno);
                    ps.setString(2, pinno);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()){                        
                        setVisible(false);
                        new Transaction(pinno).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "*Incorrect Card Number or PIN Number!");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==clearbutton){
            cardnotextfield.setText("");
            pinnotextfield.setText("");
            
        }else if(ae.getSource()==signupbutton){
            setVisible(false);                                      //first we close this frame automatic teller machine
            new SignUpOne().setVisible(true);
            
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}


//public class Login extends JFrame{
//    Login(){
//
//        //we set the total size of the super-container or frame of our desktop-app
//        setSize(1000, 650);
//        
//        //Here we set the title of our desktop-app
//        setTitle("Automatic Teller Machine");
//        
//        //Frame Color        
//        getContentPane().setBackground(Color.WHITE);
//
//        //we set the frame location that frame will open from center side or left side or right side etc
//        setLocation(460, 240);
//        
//        //we set the layout null because we have to off the by default layouts
//        setLayout(null);
//        
//        //here we set the image or icon of the desktop-app
//        ImageIcon imic2=new ImageIcon(ClassLoader.getSystemResource("images/Bank Logo.png"));
//        //Image im=imic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    //here we commented this two statements because we set the image size already in figma.
//        //ImageIcon imic2=new ImageIcon(im);
//        JLabel imlab=new JLabel(imic2);
//        imlab.setBounds(250, 65, 100, 100);
//        add(imlab);
//        
//        //now big heading we are writing using the JLabel
//        JLabel text=new JLabel("Welcome To ATM");
//        text.setFont(new Font("Raleway", Font.BOLD, 42));
//        text.setBounds(390, 100, 360, 40);
//        add(text);
//
//        //now label for field one we are writing using the JLabel
//        JLabel cardno=new JLabel("Card No.:");
//        cardno.setFont(new Font("osward", Font.BOLD, 22));
//        cardno.setBounds(270, 235, 350, 40);
//        add(cardno);
//        
//        //now label for field two we are writing using the JLabel
//        JLabel pinno=new JLabel("PIN No.:");
//        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
//        pinno.setBounds(270, 310, 90, 20);
//        add(pinno);
//        
//        JTextField cardnotextfield=new JTextField();
//        cardnotextfield.setBounds(450, 234, 280, 30);
//        add(cardnotextfield);
//        
//        JTextField pinnotextfield=new JTextField();
//        pinnotextfield.setBounds(450, 310, 280, 30);
//        add(pinnotextfield);
//        
//        JButton signinbutton=new JButton("Sign In");
//        signinbutton.setBounds(450, 386, 120, 30);
//        signinbutton.setBackground(Color.BLACK);
//        signinbutton.setForeground(Color.WHITE);
//        add(signinbutton);
//        
//        JButton clearbutton=new JButton("Clear");
//        clearbutton.setBackground(Color.BLACK);
//        clearbutton.setForeground(Color.WHITE);
//        clearbutton.setBounds(610, 386, 120, 30);
//        add(clearbutton);
//        
//        JButton signupbutton=new JButton("Sign Up");
//        signupbutton.setBackground(Color.BLACK);
//        signupbutton.setForeground(Color.WHITE);
//        signupbutton.setBounds(450, 462, 280, 30);
//        add(signupbutton);
//        
//        setVisible(true);
//    }
//    
//    public static void main(String[] args) {
//        new Login();
//    }
//}