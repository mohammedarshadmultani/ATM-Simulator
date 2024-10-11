/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Mohammed Arshad
 */
public class Utility {
    Connection con;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","1234");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
