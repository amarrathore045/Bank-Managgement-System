
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    
    JButton deposit,cashDraw,fastCash,miniStatement,pinChange,balance,exit;
    String pinNumber;
    
    
    
    Home(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/main background.png"));
        Image i2 = i1.getImage().getScaledInstance(1080,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
       
        
        
        JLabel text = new JLabel("PLEASE SELECT YOUR OPERATION");
        text.setBounds(185,70,700,35);
        text.setFont(new Font("System",Font.BOLD, 40));
        image.add(text);
        //This will add text over the background;
        
        
        
        //OPERATION LABELS .........
        
        deposit = new JButton("Deposit");
        deposit.setBorder(null);
        deposit.setBorderPainted(false);
        deposit.setContentAreaFilled(false);
        deposit.setOpaque(false);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System",Font.PLAIN, 25));
        deposit.setBounds(160,205,320,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        cashDraw = new JButton("Cash Withdraw");
        cashDraw.setBorder(null);
        cashDraw.setBorderPainted(false);
        cashDraw.setContentAreaFilled(false);
        cashDraw.setOpaque(false);
        cashDraw.setForeground(Color.WHITE);
        cashDraw.setFont(new Font("System",Font.PLAIN, 25));
        cashDraw.setBounds(595,205,320,30);
        cashDraw.addActionListener(this);
        image.add(cashDraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBorder(null);
        fastCash.setBorderPainted(false);
        fastCash.setContentAreaFilled(false);
        fastCash.setOpaque(false);
        fastCash.setForeground(Color.WHITE);
        fastCash.setFont(new Font("System",Font.PLAIN, 25));
        fastCash.addActionListener(this);
        fastCash.setBounds(160,355,320,30);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBorder(null);
        miniStatement.setBorderPainted(false);
        miniStatement.setContentAreaFilled(false);
        miniStatement.setOpaque(false);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setFont(new Font("System",Font.PLAIN, 25));
        miniStatement.addActionListener(this);
        miniStatement.setBounds(595,355,320,30);
        image.add(miniStatement);
        
        
        pinChange = new JButton("PIN Change");
        pinChange.setBorder(null);
        pinChange.setBorderPainted(false);
        pinChange.setContentAreaFilled(false);
        pinChange.setOpaque(false);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("System",Font.PLAIN, 25));
        pinChange.addActionListener(this);
        pinChange.setBounds(160,503,320,30);
        image.add(pinChange);
        
        
        balance = new JButton("Balance Enquiry");
        balance.setBorder(null);
        balance.setBorderPainted(false);
        balance.setContentAreaFilled(false);
        balance.setOpaque(false);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System",Font.PLAIN, 25));
        balance.addActionListener(this);
        balance.setBounds(595,503,320,30);
        image.add(balance);
        
        
        exit = new JButton("Logout");
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setOpaque(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System",Font.PLAIN, 25));
        exit.addActionListener(this);
        exit.setBounds(650,630,260,30);
        image.add(exit);
        
        
        
        
        setSize(1080,720);
        setUndecorated(true); //hides buttons on the top
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){ // To get input from user and take action according to it
        if(ae.getSource() == exit){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == cashDraw){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
            
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);   
        }   
        else if(ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);   
        } 
        else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);   
        } 
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);   
        } 
    }
    
    
    public static void main(String[] args){
        new Home("");
    }
    
}
