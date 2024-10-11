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
/**
 *
 * @author Mohammed Arshad
 */
public class Transaction extends JFrame implements ActionListener{
    JButton depositButton, withdrawalButton, fastcashButton, ministatementButton, pinChangeButton, balanceEnquiryButton, exitButton;
    
    String pinNumber;

    Transaction(String pinNumber){
        
        this.pinNumber=pinNumber;
        
        setLayout(null);
        setSize(900, 900);
        setLocation(480, 140);
        setUndecorated(true);
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("images\\BankATM.jpg"));
        Image image2=image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);
        JLabel image=new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);
/*<!--_______________________________________________________________________-->*/

        JLabel text=new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(220, 340, 700, 35);
        image.add(text);
/*<!--_______________________________________________________________________-->*/

        depositButton=new JButton("Deposit");
//        depositButton.setForeground(Color.BLACK);        
//        depositButton.setBackground(Color.WHITE);
        depositButton.setBounds(175, 455, 150, 30);
        depositButton.addActionListener(this);
        image.add(depositButton);        
/*<!--_______________________________________________________________________-->*/

        withdrawalButton=new JButton("Withdrawal");
        withdrawalButton.setBounds(340, 455, 150, 30);
        withdrawalButton.addActionListener(this);
        image.add(withdrawalButton);        
/*<!--_______________________________________________________________________-->*/

        fastcashButton=new JButton("Fast Cash");
        fastcashButton.setBounds(175, 490, 150, 30);
        fastcashButton.addActionListener(this);
        image.add(fastcashButton);
/*<!--_______________________________________________________________________-->*/

        ministatementButton=new JButton("Mini Statement");
        ministatementButton.setBounds(340, 490, 150, 30);
        ministatementButton.addActionListener(this);
        image.add(ministatementButton);
/*<!--_______________________________________________________________________-->*/

        pinChangeButton=new JButton("PIN Change");
        pinChangeButton.setBounds(175, 525, 150, 30);
        pinChangeButton.addActionListener(this);
        image.add(pinChangeButton);
/*<!--_______________________________________________________________________-->*/

        balanceEnquiryButton=new JButton("Balance Enquiry");
        balanceEnquiryButton.setBounds(340, 525, 150, 30);
        balanceEnquiryButton.addActionListener(this);
        image.add(balanceEnquiryButton);
/*<!--_______________________________________________________________________-->*/

        exitButton=new JButton("Exit");
        exitButton.setBounds(340, 560, 150, 30);
        exitButton.addActionListener(this);
        image.add(exitButton); 
/*<!--_______________________________________________________________________-->*/
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exitButton){
            System.exit(0);
        }else if(ae.getSource()==depositButton){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource()==withdrawalButton){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if(ae.getSource()==fastcashButton){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource()==pinChangeButton){
            setVisible(false);
            new PINChange(pinNumber).setVisible(true);
        }else if(ae.getSource()==balanceEnquiryButton){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource()==ministatementButton){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transaction("");
    }
}
