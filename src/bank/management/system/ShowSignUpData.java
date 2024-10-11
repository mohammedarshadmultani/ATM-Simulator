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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mypkg.Utility;
/**
 *
 * @author Mohammed Arshad
 */
public class ShowSignUpData extends JFrame{
    
    JButton backbutton;
    ResultSet rs;    
    String ran;
    ShowSignUpData(String ran){
        this.ran=ran;
        
//        setSize(1920, 1123);      //full screen
//        setLocation(0, 7);        //act as by default
        setSize(1920, 1123);
        setLocation(0, 7);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Sign Up Data");
        setLayout(null);
        
        
//--------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------
        //DataBase Code
        
        try{
            Utility ut=new Utility();
            Connection con=ut.connect();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM signup_one WHERE formno=?");  //WHERE form_no='"+ran+"'");
            ps.setString(1, ran);
            rs=ps.executeQuery();
            
            rs.next();
            
            

        
        
//--------------------------------------------------------------------------------------------------
        
        //String name="Elon";
        //JLabel headingn=new JLabel(name+": ");
        JLabel heading=new JLabel(rs.getString("name")+" Sign Up Data");
        heading.setBounds(800, 100, 400, 42);                                   //headingn.setBounds(700, 100, 100, 42);                  //
        heading.setFont(new Font("Raleway",Font.BOLD,36));                      //headingn.setFont(new Font("Raleway",Font.ITALIC,36));
        add(heading);                                                           //add(headingn);
        
        JLabel personname=new JLabel("Name:                 "+rs.getString("name"));
        personname.setFont(new Font("Arial",Font.BOLD,20));
        personname.setBounds(190, 180, 400, 28);                                       //850-90=760 and 730/4=190
        add(personname);
        
        JLabel fname=new JLabel("Father's Name:             "+rs.getString("father_name"));
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(190, 230, 400, 28);
        add(fname);
        
        JLabel dob=new JLabel("Date of Birth:               "+rs.getString("date_of_birth"));
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(190, 280, 400, 28);
        add(dob);
                
        JLabel gender=new JLabel("Gender:                   "+rs.getString("gender"));
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(190, 330, 400, 28);
        add(gender);
        
        JLabel email=new JLabel("Email Address:             "+rs.getString("email"));
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(190, 380, 400, 28);
        add(email);
        
        JLabel marital=new JLabel("Marital Status:          "+rs.getString("marital"));
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(190, 430, 400, 28);
        add(marital);
        
        JLabel address=new JLabel("Address:                 "+rs.getString("address"));
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(190, 480, 400, 28);
        add(address);

        JLabel city=new JLabel("City:                       "+rs.getString("city"));
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(190, 530, 400, 28);
        add(city);
        
        JLabel state=new JLabel("State:                     "+rs.getString("state"));
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(190, 580, 400, 28);
        add(state);
        
        JLabel pincode=new JLabel("PIN Code:                "+rs.getString("pincode"));
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(190, 630, 400, 28);
        add(pincode);
                setVisible(true);

        
        
        }catch(Exception e){
            System.out.println(e);
        }        
        
        backbutton=new JButton("Back");
        backbutton.setForeground(Color.WHITE);
        backbutton.setBackground(Color.BLACK);
        backbutton.setBounds(370, 680, 100, 28);
        add(backbutton);
                
    }
    public static void main(String[] args) {
        new ShowSignUpData("farz");
    }
}
