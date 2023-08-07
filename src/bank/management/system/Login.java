
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// JFrame is a part of swing which is part of java extended verson, which is used as javax
public class Login extends JFrame implements ActionListener{
    //constructor is created so that once called our frame will be generated
    
    JButton login,signup,clear,exit;//buttons defined globally
    JTextField  accnoTextField ;//textfield defined globally
    JPasswordField pinTextField;
    
    Login(){
        //we have to use setBounds for all the elements to be shown in the frame
        setLayout(null);//to set specific position of elements
        
        
        //Title
        setTitle("Your Bank"); //set titke of the frame
        
        
        
        //Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/home-outline.gif")); //to use images, we have to make object of ImageIcon class
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //we cannot add image to jlevel we can add imageicon in jframe
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        
        //now to place the home icon in frame
        label.setBounds(70,20,100,100);//the 4 parameters are the placement of a rectangle
        //70 is the distance from left , 40 is distance from top , 100,100 is the length and width of label
        add(label);
        
        
        
        
        //Labels and text fields
        
        
        //add text to the frame
        JLabel text = new JLabel("Bank Management System");
        text.setFont(new Font("Osward",Font.BOLD, 36));
        text.setBounds(200,50,550,40);
        add(text);
        
        //add label to the frame
        JLabel account = new JLabel("Account No.");
        account.setFont(new Font("Railway",Font.BOLD, 30));
        account.setBounds(120,200,350,30);
        add(account);
        //add text field in front of label
        accnoTextField = new JTextField();
        accnoTextField.setBounds(320,200,250,30);
        accnoTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(accnoTextField);
        
        //add label to the frame
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Osward",Font.BOLD, 30));
        pin.setBounds(120,260,150,30);
        add(pin);
        //add text field in front of label
        pinTextField = new JPasswordField();
        pinTextField.setBounds(320,260,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);
        
        
        
        
        //Buttons
        
        
        //Add sign in for login
        login = new JButton("Sign In");
        login.setBounds(320,350,120,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);//this will tell that action is performed in login
        add(login);
        
        //Add sign in for login
        clear = new JButton("Clear");
        clear.setBounds(450,350,120,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //Add sign in for login
        signup = new JButton("Sign Up");
        signup.setBounds(320,400,250,40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        //add exit button
        exit = new JButton("Exit");
        exit.setBounds(480,470,150,40);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        
        
        //name labels
        JLabel amar = new JLabel("By - Amar Pratap Singh & Anuj Pratap Singh");
        amar.setFont(new Font("Osward",Font.BOLD, 16));
        amar.setBounds(80,520,550,20);
        add(amar);
        
        
        
        
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        
        
        setSize(750,600);//setSize defines dimensions of the frame
        setVisible(true);//frame visibility is false bydefault, it is set to true here
        setLocation(400,200);//origin bydefault is set to top left , set location set changes the origin of frame
        
        
        
        //Action handling here
        
        
        
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){  // To get input from user and take action according to it 
            
            if(ae.getSource() == clear){
                accnoTextField.setText("");
                pinTextField.setText("");
            }
            else if(ae.getSource() == login){
                Cons conn = new Cons();
                String cardNumber = accnoTextField.getText();
                String pinNumber = pinTextField.getText();
                String query =  "select * from login where accNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
                try{
                    ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Home(pinNumber);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Account no. or Pin");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource() == signup){
                setVisible(false);
                new Signup().setVisible(true);
            }
            else if(ae.getSource() == exit){
                System.exit(0);
            }
            
            
        }
    public static void main(String args[]){
        new Login();
        
    }
}
