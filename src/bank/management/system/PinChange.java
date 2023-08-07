package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinChange extends JFrame implements ActionListener{
 
    JPasswordField pin,repin;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("resources/Change Pin.png"));
        Image i2=i1.getImage().getScaledInstance(1080, 720, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1080,720);
        add(image);
        
        JLabel text= new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 45));
        text.setBounds(350, 50, 500, 80);
        image.add(text);
        
        JLabel pintext= new JLabel("New Pin");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 30));
        pintext.setBounds(220, 135, 200, 150);
        image.add(pintext);
        
        JLabel repintext= new JLabel("Re-Enter Pin");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 30));
        repintext.setBounds(210, 250, 200, 150);
        image.add(repintext);
        
        
        
         pin=new JPasswordField();
        pin.setFont(new Font("Railway", Font.BOLD, 30));
        pin.setBounds(600, 180, 300, 50);
        image.add(pin);
        
         repin=new JPasswordField();
        repin.setFont(new Font("Railway", Font.BOLD, 30));
        repin.setBounds(600, 300, 300, 50);
        image.add(repin);
        
        change=new JButton("Change");
        change.setBorder(null);
        change.setBorderPainted(false);
        change.setContentAreaFilled(false);
        change.setOpaque(false);
        change.setForeground(Color.WHITE);
        change.setFont(new Font("System",Font.PLAIN, 25));
        change.setBounds(730, 473, 200, 50);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setOpaque(false);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System",Font.PLAIN, 25));
        back.setBounds(730, 587, 200, 50);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(1080,720);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== change){    
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
             String regex_deposit = "[0-9]+";  // Regular Expression to check that the amount entered is numeric
            Pattern pattern_deposit =Pattern.compile(regex_deposit);
            Matcher match_deposit= pattern_deposit.matcher(npin); // Mathching the Entered amount with the regex
            boolean deposit_match= match_deposit.matches(); // Transfering the result to a boolean variable
            // Check of Amount Field Ends Here
            
            
            if(npin.equals("") || deposit_match == false || npin.length()!=4){
                JOptionPane.showMessageDialog(null,"Invalid Pin. Enter a 4 digit Pin");
                setVisible(false);
                    new Home(pinNumber);
                    return;
            }
            
            
            if(npin.equals(rpin)== false){
                JOptionPane.showMessageDialog(null, "Pin Doesnot Match");
                setVisible(false);
                    new Home(pinNumber);
                    return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Confirm the New Pin");
                setVisible(false);
                    new Home(pinNumber);
                    return;
            }
            Cons cons= new Cons();
            String query1="update bank set pin= '"+rpin+"' where pin='"+pinNumber+"'";
            String query2="update login set pinNumber= '"+rpin+"' where pinNumber='"+pinNumber+"'";
            //String query3="update signup3 set pin= '"+rpin+"' where pin='"+pinnumber+"'";
            
            cons.s.execute(query1);
            cons.s.execute(query2);
            //cons.s.execute(query3);
            
            JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
            setVisible(false);
            
            new Home(rpin);
        } catch(Exception e) {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Home(pinNumber);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
            
}