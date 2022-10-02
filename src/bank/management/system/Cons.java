

package bank.management.system;
import java.sql.*;
// for jdbc connection 
// here is no main because its object is to be used
/*
5 steps in jdbc connectivity
1.Register Driver
2.Create connection
3.Create statement
4.Execute query
5.Close Connection
*/




public class Cons {
    
    Connection c;
    Statement s;
    public Cons(){
        try{
            
            //create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","password");
            
            //create statement for query execution
            s = c.createStatement();
            
            
        }
        // catch exception here
        catch(Exception e){
            //print execption to console
            System.out.println("Exception occur named : " + e);
        }
    
    }

}
