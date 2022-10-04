
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Withdraw extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pinNumber;
    
    Withdraw(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        //by default layout is boxed so e have to change it befor using setbounds 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/Deposit.png"));
        Image i2 = i1.getImage().getScaledInstance(1080,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
        
        
        
        JLabel text = new JLabel("Enter amount you want to Withdraw");
        text.setFont(new Font("System",Font.BOLD,30));
        text.setForeground(Color.WHITE);
        text.setBounds(290,190,700,40);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Highway",Font.BOLD,22));
        amount.setBounds(240 , 330 , 600 , 50);
        image.add(amount);
        
        
        
        withdraw = new JButton("Withdraw");
        withdraw.setBorder(null);
        withdraw.setBorderPainted(false);
        withdraw.setContentAreaFilled(false);
        withdraw.setOpaque(false);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        withdraw.setFont(new Font("Highway",Font.BOLD,25));
        withdraw.setBounds(763,480,150,40);
        image.add(withdraw);
        
        
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
        if(ae.getSource() == withdraw){
            setVisible(false);
            String number = amount.getText();
            Date date = new Date();
             String regex_deposit = "[0-9]+";  // Regular Expression to check that the amount entered is numeric
            Pattern pattern_deposit =Pattern.compile(regex_deposit);
            Matcher match_deposit= pattern_deposit.matcher(number); // Mathching the Entered amount with the regex
            boolean deposit_match= match_deposit.matches(); // Transfering the result to a boolean variable
            // Check of Amount Field Ends Here
            
            
            if(number.equals("") || deposit_match == false ){
                JOptionPane.showMessageDialog(null,"Invalid Amount");
                setVisible(false);
                    new Home(pinNumber).setVisible(true);
            }
            //valid amount will be sent for updation in the database 
            else{
                try{
                    Cons conn = new Cons();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'" );
                    int left = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            left += Integer.parseInt(rs.getString("amount"));
                        }else{
                            left -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource()!= back && left < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    setVisible(false);
                    new Home(pinNumber).setVisible(true);
                    return;
                    }
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Home(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println("Error encountered - "+e);
                    //This will make user interaction better
                }
                
            }
            
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Home(pinNumber).setVisible(true);
        }
    }
    
    
    
    public static void main(String args[]){
        new Withdraw("");
    }
    
}
