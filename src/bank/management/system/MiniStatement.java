
package bank.management.system;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame{

    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        
        setLayout(null); // To reset the default layout to null, inorder to avoid any layout clashes
        
        
        //new label for predefined amounts
        
        JLabel mini=new JLabel();
        mini.setBounds(20, 130, 500, 400);
        add(mini);
        
        
        JLabel balance= new JLabel();
        balance.setBounds(20, 110, 300, 20);
        add(balance);
        
        
        JLabel bank = new JLabel("Your own Bank");
        bank.setBounds(150, 20, 100, 20);
        

        add(bank);
        
        JLabel card= new JLabel();
        card.setBounds(20,80, 300, 20);
        add(card);
        
        //establishing connection to database 
        
        try{
            Cons cons=new Cons();
            ResultSet rs= cons.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"' ");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("accNumber"));
            }        
        }
        catch(Exception e){
            System.out.println(e);
        }
        int bal=0;
        try{
            Cons cons=new Cons();
            ResultSet rs= cons.s.executeQuery("select * from bank where pin = '"+pinNumber+"' order by date DESC LIMIT 0,10 ");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
           
            }
            ResultSet rs2=cons.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs2.next()){
                
                if(rs2.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs2.getString("amount"));           
                }
                else{
                    bal -= Integer.parseInt(rs2.getString("amount"));      
                }
                
            }
           
            balance.setText("Your Current Account Balance is Rs "+ bal);
            
            
        }
        //catch block for exception handling
        catch(Exception e){
            System.out.println("Error caught - "+e);
            //this will print into the console
        }
        
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(100,100);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
