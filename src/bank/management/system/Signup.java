//Signup page

package bank.management.system;

import bank.management.system.Handlers.fieldEmailHandler;
import bank.management.system.Handlers.fieldPINHandler;
import bank.management.system.Handlers.fieldTextHandler;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.regex.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;



public class Signup extends JFrame implements ActionListener {
    
    long random;
    JTextField nameText,fnameText,dobText,emailText,addressText,cityText,stateText,pinText,dobtext;
    JButton next, cancel,dobButton;
    JRadioButton male, female, other , married, unmarried;
    JDateChooser dateChooser;
    Signup(){
        
        //set layout is boxed by defauylt so changing it is necessary
        
        setLayout(null);
        
        setTitle("Sign Up,    Page 1 of 2");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);//to get 4 digit application number
        
        JLabel formno = new JLabel("Applicaion Form Number :"+ random );
        formno.setFont(new Font("Railway",Font.BOLD,30));
        formno.setBounds(190,20,600,30);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details" );
        personalDetails.setFont(new Font("Railway",Font.BOLD,28));
        personalDetails.setBounds(230,70,400,40);
        add(personalDetails);
        
        
        
        //Labels and textfields
        
        
        
        JLabel name = new JLabel("Name :" );
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(120,150,200,30);
        add(name);
        nameText = new JTextField();
        nameText.setFont(new Font("Railway",Font.BOLD,14));
        nameText.setBounds(300,150,400,30);
        add(nameText);
        
        
        
        
        JLabel fname = new JLabel("Father's Name :" );
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(120,200,200,30);
        add(fname);
        fnameText = new JTextField();
        fnameText.setFont(new Font("Railway",Font.BOLD,14));
        fnameText.setBounds(300,200,400,30);
        add(fnameText);
        
        
        
        //DOB
        
        JLabel dobText = new JLabel("Date of Birth :" );
        dobText.setFont(new Font("Railway",Font.BOLD,20));
        dobText.setBounds(120,250,200,30);
        add(dobText);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,250,20,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        dobtext=new JTextField();
        dobtext.setFont(new Font("Railway",Font.BOLD,14));
        dobtext.setBounds(320,250,150,30);
        add(dobtext);
        
        //Showing selected DOB to the user
        
        dobButton = new JButton("Show DOB");
        dobButton.setBackground(Color.BLACK);
        dobButton.setForeground(Color.WHITE);
        dobButton.setFont(new Font("Railway",Font.BOLD,12));
        dobButton.setBounds(470, 250, 100, 30);
        dobButton.addActionListener(this);
        add(dobButton);
        
        
        
        JLabel gender = new JLabel("Gender :" );
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(120,300,200,30);
        add(gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Railway",Font.BOLD,15));
        male.setBackground(Color.GRAY);
        male.setBounds(300,300,60,30);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Railway",Font.BOLD,15));
        female.setBackground(Color.GRAY);
        female.setBounds(450,300,85,30);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        
        
        
        JLabel email = new JLabel("Email :" );
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(120,350,200,30);
        add(email);
        emailText = new JTextField();
        emailText.setFont(new Font("Railway",Font.BOLD,14));
        emailText.setBounds(300,350,400,30);
        add(emailText);
        
        
        //radio buttons are used for marital status
        
        
        JLabel marital = new JLabel("Marital Status :" );
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(120,400,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setFont(new Font("Railway",Font.BOLD,15));
        married.setBackground(Color.GRAY);
        married.setBounds(300,400,100,30);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Railway",Font.BOLD,15));
        unmarried.setBackground(Color.GRAY);
        unmarried.setBounds(430,400,160,30);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setFont(new Font("Railway",Font.BOLD,15));
        other.setBackground(Color.GRAY);
        other.setBounds(590,400,200,30);
        add(other);
        
        ButtonGroup marryGroup = new ButtonGroup();
        marryGroup.add(married);
        marryGroup.add(unmarried);
        marryGroup.add(other);
        
        
        
        
        
        
        JLabel address = new JLabel("Adddress :" );
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(120,450,200,30);
        add(address);
        addressText = new JTextField();
        addressText.setFont(new Font("Railway",Font.BOLD,14));
        addressText.setBounds(300,450,400,30);
        add(addressText);
        
        
        
        
        
        
        JLabel city = new JLabel("City :" );
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(120,500,200,30);
        add(city);
        cityText = new JTextField();
        cityText.setFont(new Font("Railway",Font.BOLD,14));
        cityText.setBounds(300,500,400,30);
        add(cityText);
        
        
        
        
        
        
        JLabel state = new JLabel("State :" );
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(120,550,200,30);
        add(state);
        stateText = new JTextField();
        stateText.setFont(new Font("Railway",Font.BOLD,14));
        stateText.setBounds(300,550,400,30);
        add(stateText);
        
        
        
        
        
        JLabel pincode = new JLabel("Pincode :" );
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(120,600,200,30);
        add(pincode);
        pinText = new JTextField();
        pinText.setFont(new Font("Railway",Font.BOLD,14));
        pinText.setBounds(300,600,400,30);
        add(pinText);

        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(600, 690, 100, 30);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBounds(470, 690, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.GRAY);
        
        setSize(850,800);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){  // To get input from user and take action according to it
        
        
        if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            return;
        }
        if(ae.getSource()== dobButton){
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            dobtext.setText(dob);
            return;
        }
        
        String formno = ""+ random; // random is a long value
        String name  = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        
        
        String marital = null;
        if(married.isSelected()){
            marital = "Mrried";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();
        String email = emailText.getText();
        
        
        try{
            String[] request = {name, fname, state , city , email, pin}; // request que contiene
            // los datos que queremos validar en cadena.
            
            
            fieldTextHandler nameFieldValidation = new fieldTextHandler(request);
            nameFieldValidation.setIndex(0); // Aqui inicia la cadena.
            fieldTextHandler fatherNameFieldValidation = new fieldTextHandler(request);
            fieldTextHandler stateFieldValidation = new fieldTextHandler(request);
            fieldTextHandler cityFieldValidation = new fieldTextHandler(request);
            fieldEmailHandler emailFieldValidation = new fieldEmailHandler(request);
            fieldPINHandler pinFieldValidation = new fieldPINHandler(request);
            
            nameFieldValidation.setNext(fatherNameFieldValidation);
            fatherNameFieldValidation.setNext(stateFieldValidation);
            stateFieldValidation.setNext(cityFieldValidation);
            cityFieldValidation.setNext(emailFieldValidation);
            emailFieldValidation.setNext(pinFieldValidation);
            
            boolean othersValidations = (!dob.equals("")) && gender != null && marital != null && !address.equals("");
            if(nameFieldValidation.handle(request) && othersValidations){
               Cons c = new Cons();
               String query = "insert into signup value('"+formno+"'  ,'"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+pin+"' , '"+state+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
            } else {
                 JOptionPane.showMessageDialog(null, "Please complete all fields.");
            }
             /*
            variable here shoulb be treated as string 
            therefore, tomake query using a variable we have to do in the format-
            "string'"+variable"'String";
            */
        }
        catch(Exception e){
            System.out.println("Error caught - "+e);
        }
        //this will print the error encountered in the console
        
    }
    
    
    //main class
    public static void main(String args[]){
        new Signup();
        //This will create a new page and logout the current user
    
    }
    
}
