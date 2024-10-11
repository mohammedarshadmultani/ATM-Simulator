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
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Mohammed Arshad
 */
public class Deposit extends JFrame implements ActionListener{
    
    JTextField amountTextField;
    JButton depositButton, backButton;
    
    String pinNumber;;
    
    Deposit(String pinNumber){
        
        this.pinNumber=pinNumber;
        
        setSize(900, 900);
        setLayout(null);
        setLocation(480, 140);
//        setUndecorated(true);
        
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource(("images/BankATM.jpg")));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel image=new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

/*<!--_______________________________________________________________________-->*/        
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(190, 320, 400, 20);
        image.add(text);
        
/*<!--_______________________________________________________________________-->*/
        
        amountTextField=new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(175, 370, 320, 34);
        image.add(amountTextField);
        
        depositButton=new JButton("Deposit");
        depositButton.setBounds(355, 485, 150, 30);
        depositButton.addActionListener(this);
        image.add(depositButton);

        backButton=new JButton("Back");
        backButton.setBounds(175, 485, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depositButton){
            
            String amountQuantity=amountTextField.getText();
            
            Date date=new Date();
            
            if(amountQuantity.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }
            
            else{
                try{
                    mypkg.Utility ut=new mypkg.Utility();
                    java.sql.Connection con=ut.connect();
//                    String sql="";
                    java.sql.Statement stmt=con.createStatement();
                    int n=stmt.executeUpdate("INSERT INTO bank VALUES('"+pinNumber+"','"+date+"','Deposit', '"+amountQuantity+"')");
                    if(n>0){
                        JOptionPane.showMessageDialog(null, "Rs. "+amountQuantity+" Deposited Sucessfully");
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                
                
            }
        }else if(ae.getSource()==backButton){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
    
    
    
}
/*

CREATE TABLE bank(
pin_number VARCHAR(20),
date VARCHAR(20),
type VARCHAR(20), 
amount VARCHAR(20)
);

ALTER TABLE bank MODIFY date VARCHAR(50);
*/