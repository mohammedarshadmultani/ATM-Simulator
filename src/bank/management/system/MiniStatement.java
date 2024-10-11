/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Mohammed Arshad
 */
public class MiniStatement extends JFrame{
    
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        
        setTitle("Mini Statement");
        setLayout(null);
        setSize(500, 1000);
        setLayout(null);
        setLocation(200, 100);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);        
/*<!--_______________________________________________________________________-->*/        

        JLabel text=new JLabel("Indian Bank");
//        text.setForeground(Color.BLACK);
//        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(65, 150, 400, 20);
        add(text);
/*<!--_______________________________________________________________________-->*/

        JLabel card=new JLabel();
//        card.setForeground(Color.BLACK);
        card.setFont(new Font("System",Font.BOLD,16));
        card.setBounds(65, 300, 400, 20);
        add(card);
/*<!--_______________________________________________________________________-->*/
        
        JLabel mini=new JLabel();
//        mini.setForeground(Color.BLACK);
        mini.setFont(new Font("System",Font.BOLD,16));
        mini.setBounds(65, 390, 800, 50);
        add(mini);
/*<!--_______________________________________________________________________-->*/

        JLabel balance=new JLabel();
//        card.setForeground(Color.BLACK);
        balance.setFont(new Font("System",Font.BOLD,16));
        balance.setBounds(65, 480, 400, 20);
        add(balance);        
        
        try{
            mypkg.Utility ut=new mypkg.Utility();
            
            Connection con=ut.connect();
            
            String query1="SELECT * FROM login  WHERE pin_number='"+pinNumber+"'";
//            String query1="SELECT * FROM login  WHERE pin_number=1650";
            
            PreparedStatement ps=con.prepareStatement(query1);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0, 4)+" XXXX-XXX-" + rs.getString("card_number").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            mypkg.Utility ut=new mypkg.Utility();
            
            Connection con=ut.connect();
            
            String query2="SELECT * FROM bank  WHERE pin_number='"+pinNumber+"'";
//            String query2="SELECT * FROM bank  WHERE pin_number=1650";
            
            PreparedStatement ps=con.prepareStatement(query2);
            
            ResultSet rs=ps.executeQuery();
            
            int bal=0;
            
            while(rs.next()){
                mini.setText(
                        mini.getText()+
                                "<html>"
                        +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        +rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        +rs.getString("amount")+"<br>"
                );
                if(rs.getString("type").equals("Deposit")){                             //type==deposit
                    
                    bal=bal + Integer.parseInt(rs.getString("amount"));                    
                }else {                                                                 //type==non-deposit
                    bal=bal - Integer.parseInt(rs.getString("amount"));                    
                }                
            }  
            
            balance.setText("Your Current Account Balance is Rs. "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        

        setVisible(true);
        
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
