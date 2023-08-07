package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("resources/Balance.png"));
        Image i2= i1.getImage().getScaledInstance(1080, 720, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
        
        back=new JButton("Back");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setOpaque(false);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Highway",Font.BOLD,28));
        back.setBounds(755, 470, 150, 50);
        back.addActionListener(this);
        image.add(back);
        
        Cons c= new Cons();
        int balance = 0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));           
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));      
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text =new JLabel("Your current Account Balance is Rs. "+ balance);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 30));

        text.setBounds(100,200, 720,30);
        image.add(text);
        
        
        
        
        setSize(1080,720);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Home(pinNumber);
    }
    public static void main(String args[]){
        
        new BalanceEnquiry("");
    }
}