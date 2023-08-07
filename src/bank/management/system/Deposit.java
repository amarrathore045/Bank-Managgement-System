
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinNumber;
    
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/Deposit.png"));
        Image i2 = i1.getImage().getScaledInstance(1080,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
        //items will be above the image therefore, we have to use image.add for other components
        
        
        JLabel text = new JLabel("Enter amount you want to deposit");
        text.setFont(new Font("System",Font.BOLD,30));
        text.setForeground(Color.WHITE);
        text.setBounds(290,190,700,40);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Highway",Font.BOLD,22));
        amount.setBounds(240 , 330 , 600 , 50);
        image.add(amount);
        
        
        
        deposit = new JButton("Deposit");
        deposit.setBorder(null);
        deposit.setBorderPainted(false);
        deposit.setContentAreaFilled(false);
        deposit.setOpaque(false);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Highway",Font.BOLD,25));
        deposit.setBounds(763,480,150,40);
        image.add(deposit);
        
        
        back = new JButton("Back");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setOpaque(false);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Highway",Font.BOLD,25));
        back.addActionListener(this);
        back.setBounds(763,570,150,40);
        image.add(back);
        
        
        
        setSize(1080,720);
        //setUndecorated(true); //hides buttons on the top
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            setVisible(false);
            String number = amount.getText();
            Date date = new Date();
            //To Check the Format of Amount Entered
            
            String regex_deposit = "[0-9]+";  // Regular Expression to check that the amount entered is numeric
            Pattern pattern_deposit =Pattern.compile(regex_deposit);
            Matcher match_deposit= pattern_deposit.matcher(number); // Mathching the Entered amount with the regex
            boolean deposit_match= match_deposit.matches(); // Transfering the result to a boolean variable
            // Check of Amount Field Ends Here
            
            
            if(number.equals("") || deposit_match == false || number.equals("0") ){
                JOptionPane.showMessageDialog(null,"Invalid Amount");
                setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
            }
            else{
                try{
                    Cons conn = new Cons();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Home(pinNumber);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
            
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Home(pinNumber);
        }
    }
    
    
    
    public static void main(String args[]){
        new Deposit("");
    }
    
}
