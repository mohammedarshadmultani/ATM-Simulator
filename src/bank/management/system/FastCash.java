/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Mohammed Arshad
 */
public class FastCash extends JFrame implements ActionListener{
    JButton amount100Button, amount500Button, amount1000Button, amount2000Button, amount5000Button, amount10000Button, backButton;
    
    String pinNumber;

    FastCash(String pinNumber){
        
        this.pinNumber=pinNumber;
        
        setLayout(null);
        setSize(900, 900);
        setLocation(480, 140);
        setUndecorated(true);
        
/*<!--_______________________________________________________________________-->*/

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("images\\BankATM.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel image=new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);
/*<!--_______________________________________________________________________-->*/

        JLabel text=new JLabel("Please Select Your Withdrawal Amount");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190, 340, 700, 35);
        image.add(text);
/*<!--_______________________________________________________________________-->*/

        amount100Button=new JButton("Rs. 100");
        amount100Button.setBounds(175, 455, 150, 30);
        amount100Button.addActionListener(this);
        image.add(amount100Button);        
/*<!--_______________________________________________________________________-->*/

        amount500Button=new JButton("Rs. 500");
        amount500Button.setBounds(340, 455, 150, 30);
        amount500Button.addActionListener(this);
        image.add(amount500Button);        
/*<!--_______________________________________________________________________-->*/

        amount1000Button=new JButton("Rs. 1000");
        amount1000Button.setBounds(175, 490, 150, 30);
        amount1000Button.addActionListener(this);
        image.add(amount1000Button);
/*<!--_______________________________________________________________________-->*/

        amount2000Button=new JButton("Rs. 2000");
        amount2000Button.setBounds(340, 490, 150, 30);
        amount2000Button.addActionListener(this);
        image.add(amount2000Button);
/*<!--_______________________________________________________________________-->*/

        amount5000Button=new JButton("Rs. 5000");
        amount5000Button.setBounds(175, 525, 150, 30);
        amount5000Button.addActionListener(this);
        image.add(amount5000Button);
/*<!--_______________________________________________________________________-->*/

        amount10000Button=new JButton("Rs. 10000");
        amount10000Button.setBounds(340, 525, 150, 30);
        amount10000Button.addActionListener(this);
        image.add(amount10000Button);
/*<!--_______________________________________________________________________-->*/

        backButton=new JButton("Back");
        backButton.setBounds(340, 560, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton); 
/*<!--_______________________________________________________________________-->*/

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

//        }else if(ae.getSource()==amount100Button){
//
//        }else if(ae.getSource()==amount500Button){
//
//        }else if(ae.getSource()==amount1000Button){
//
//        }else if(ae.getSource()==amount2000Button){
//            
//        }else if(ae.getSource()==amount5000Button){
//            
//        }else if(ae.getSource()==amount10000Button){
//            
//        }

        String amount=(((JButton)ae.getSource()).getText()).substring(3).trim();           //100 or 500 or 1000

        try{
            mypkg.Utility ut=new mypkg.Utility();

            Connection con=ut.connect();
            
            PreparedStatement ps=con.prepareStatement("SELECT * FROM bank WHERE pin_number=?"); 
            ps.setString(1, pinNumber);
            
            ResultSet rs=ps.executeQuery();
            
            int balance=0;       
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){                             //type==deposit
                    
                    balance=balance + Integer.parseInt(rs.getString("amount"));                    
                }else {                                                                 //type==non-deposit
                    balance=balance - Integer.parseInt(rs.getString("amount"));                    
                }
            }
            if(ae.getSource()!= backButton && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date=new Date();
            String date2=""+date;

            PreparedStatement ps2=con.prepareStatement("INSERT INTO bank VALUES(?, ?, ?, ?)");
            ps2.setString(1, pinNumber);
            ps2.setString(2, date2);
            ps2.setString(3, "Withdraw");
            ps2.setString(4, amount);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Sucessfully");

            setVisible(false);
            new Transaction(pinNumber).setVisible(true);

        if(ae.getSource()==backButton){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }   
        }catch(SQLException e){
            System.out.println(e);
        }catch(NumberFormatException e){
            System.out.println("My "+e);
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
