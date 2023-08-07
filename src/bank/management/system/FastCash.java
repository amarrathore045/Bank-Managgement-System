
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit,cashDraw,fastCash,miniStatement,pinChange,balance,exit;
    String pinNumber;
    
    
    
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/FastCash.png"));
        Image i2 = i1.getImage().getScaledInstance(1080,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
       
        
        
        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(185,70,700,35);
        text.setFont(new Font("System",Font.BOLD, 40));
        image.add(text);
        //This will add text over the background;
        
        
        
        //OPERATION LABELS .........
        
        deposit = new JButton("Rs 100");
        deposit.setBorder(null);
        deposit.setBorderPainted(false);
        deposit.setContentAreaFilled(false);
        deposit.setOpaque(false);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("System",Font.PLAIN, 25));
        deposit.setBounds(160,190,320,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        cashDraw = new JButton("Rs 200");
        cashDraw.setBorder(null);
        cashDraw.setBorderPainted(false);
        cashDraw.setContentAreaFilled(false);
        cashDraw.setOpaque(false);
        cashDraw.setForeground(Color.WHITE);
        cashDraw.setFont(new Font("System",Font.PLAIN, 25));
        cashDraw.setBounds(585,190,320,30);
        cashDraw.addActionListener(this);
        image.add(cashDraw);
        
        fastCash = new JButton("Rs 500");
        fastCash.setBorder(null);
        fastCash.setBorderPainted(false);
        fastCash.setContentAreaFilled(false);
        fastCash.setOpaque(false);
        fastCash.setForeground(Color.WHITE);
        fastCash.setFont(new Font("System",Font.PLAIN, 25));
        fastCash.addActionListener(this);
        fastCash.setBounds(160,315,320,30);
        image.add(fastCash);
        
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBorder(null);
        miniStatement.setBorderPainted(false);
        miniStatement.setContentAreaFilled(false);
        miniStatement.setOpaque(false);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setFont(new Font("System",Font.PLAIN, 25));
        miniStatement.addActionListener(this);
        miniStatement.setBounds(595,315,320,30);
        image.add(miniStatement);
        
        
        pinChange = new JButton("Rs 5000");
        pinChange.setBorder(null);
        pinChange.setBorderPainted(false);
        pinChange.setContentAreaFilled(false);
        pinChange.setOpaque(false);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("System",Font.PLAIN, 25));
        pinChange.addActionListener(this);
        pinChange.setBounds(160,435,320,30);
        image.add(pinChange);
        
        
        balance = new JButton("Rs 10000");
        balance.setBorder(null);
        balance.setBorderPainted(false);
        balance.setContentAreaFilled(false);
        balance.setOpaque(false);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System",Font.PLAIN, 25));
        balance.addActionListener(this);
        balance.setBounds(595,435,320,30);
        image.add(balance);
        
        
        exit = new JButton("Back");
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setOpaque(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System",Font.PLAIN, 25));
        exit.addActionListener(this);
        exit.setBounds(650,600,260,30);
        image.add(exit);
        
        
        
        setSize(1080,720);
        setUndecorated(true); //hides buttons on the top
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Home(pinNumber);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Cons c = new Cons();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'" );
                int left = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        left += Integer.parseInt(rs.getString("amount"));
                    }else{
                        left -= Integer.parseInt(rs.getString("amount"));
                    }
                }  
                if(ae.getSource()!= exit && left < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +amount+ " Debited Successfully");
                setVisible(false);
                new Home(pinNumber);
                
             }
                
            
            catch(HeadlessException | NumberFormatException | SQLException e){
                System.out.println(e);
            }
        }
        
            
    }
    
    
    public static void main(String[] args){
        new FastCash("");
    }
    
}
