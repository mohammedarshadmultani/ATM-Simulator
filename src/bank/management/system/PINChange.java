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
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Mohammed Arshad
 */
public class PINChange extends JFrame implements ActionListener{
    
    JButton changeButton, backButton;
    JPasswordField pinTextField, repinTextField;
    String pinNumber;
    PINChange(String pinNumber){
        
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
        
        JLabel text=new JLabel("Change Your PIN");
        text.setFont(new Font("Arial",Font.BOLD,20));    
        text.setForeground(Color.WHITE);
        text.setBounds(255, 320, 180, 28);
        image.add(text);
/*<!--_______________________________________________________________________-->*/
        
        JLabel enterPIN=new JLabel("Enter Your PIN:");
        enterPIN.setFont(new Font("Arial",Font.BOLD,16));    
        enterPIN.setForeground(Color.WHITE);
        enterPIN.setBounds(175, 400, 180, 20);
        image.add(enterPIN);
/*<!--_______________________________________________________________________-->*/

        pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,17));
        pinTextField.setBounds(310, 400, 180, 28);
        add(pinTextField);
/*<!--_______________________________________________________________________-->*/
        
        JLabel reenterPIN=new JLabel("Enter Again Your PIN:");
        reenterPIN.setFont(new Font("Arial",Font.BOLD,16));    
        reenterPIN.setForeground(Color.WHITE);
        reenterPIN.setBounds(175, 450, 180, 20);
        image.add(reenterPIN);
/*<!--_______________________________________________________________________-->*/

        repinTextField=new JPasswordField();
        repinTextField.setFont(new Font("Arial",Font.BOLD,17));
        repinTextField.setBounds(360, 450, 130, 28);
        add(repinTextField);          
/*<!--_______________________________________________________________________-->*/

        changeButton=new JButton("Change");
        changeButton.setBounds(340, 525, 150, 30);
        changeButton.addActionListener(this);
        image.add(changeButton);      
/*<!--_______________________________________________________________________-->*/

        backButton=new JButton("Back");
        backButton.setBounds(340, 560, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton);

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==changeButton){
            
            String enterPin=pinTextField.getText();
            
            String reenterPin=repinTextField.getText();
            
            if(!enterPin.equals(reenterPin)){
                JOptionPane.showMessageDialog(null, "Entered PIN Doesn't Match");
                return;
            }else if(enterPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please entered the new PIN");
                return;
            }else if(reenterPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please entered again the new PIN");
                return;
            }else{
                try{
                    mypkg.Utility ut=new mypkg.Utility();
                    Connection con=ut.connect();
                    String query1="UPDATE bank SET pin_number='"+enterPin+"' WHERE pin_number='"+pinNumber+"'";
                    String query2="UPDATE login SET pin_number='"+enterPin+"' WHERE pin_number='"+pinNumber+"'";
                    String query3="UPDATE signup_three SET pin_number='"+enterPin+"' WHERE pin_number='"+pinNumber+"'";
                    
                    Statement stmt1=con.createStatement();
                    Statement stmt2=con.createStatement();
                    Statement stmt3=con.createStatement();
                    
                    stmt1.executeUpdate(query1);
                    stmt2.executeUpdate(query2);
                    stmt3.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                    
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                    
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
        new PINChange("");
    }
    
}
