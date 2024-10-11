/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mohammed Arshad
 */
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton backButton;
    
    String pinNumber;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        
        setSize(900, 900);
        setLayout(null);
        setLocation(500, 100);
        setUndecorated(true);        
/*<!--_______________________________________________________________________-->*/

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("images/BankATM.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel image=new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);
/*<!--_______________________________________________________________________-->*/

        
/*<!--_______________________________________________________________________-->*/

        backButton=new JButton("Back");
        backButton.setBounds(340, 560, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        int balance=0;       

        try{
            mypkg.Utility ut=new mypkg.Utility();

            Connection con=ut.connect();
            
            PreparedStatement ps=con.prepareStatement("SELECT * FROM bank WHERE pin_number=?"); 
            ps.setString(1, pinNumber);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){                             //type==deposit
                    
                    balance=balance + Integer.parseInt(rs.getString("amount"));                    
                }else {                                                                 //type==non-deposit
                    balance=balance - Integer.parseInt(rs.getString("amount"));                    
                }
            }
        }catch (Exception e){
            
        }
        
        JLabel text=new JLabel("Your Current Account Balance is Rs. "+balance);
        text.setFont(new Font("Arial",Font.BOLD,16));    
        text.setForeground(Color.WHITE);
        text.setBounds(175, 320, 500, 28);
        image.add(text);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==backButton){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);        
        }
//        else if(ae.getSource()==backButton){
//
//        }
        
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
