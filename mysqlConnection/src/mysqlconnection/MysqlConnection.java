/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconnection;

//import com.;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 *
 * @author asher.ansari
 */
public class MysqlConnection {

    /**
     * @param args the command line arguments
     */
    private static final String username = "root";
    private static final String psk = "";
    private static final String connectionString =
            "jdbc:mysql://localhost:3306/temp";
    
    public static void main(String[] args) {
             Connection con =null;
        try{

            con = DriverManager.getConnection(connectionString+"?"+"user="+username+"&password="+psk);
            System.out.println("connected");
            Statement st = (Statement) con.createStatement();
//             String query = "";
String insert = "INSERT INTO employees (fname, mname) values('Muhammad','Asher')";
            st.executeUpdate(insert);
            ResultSet myRs = st.executeQuery("select * from employees");
            while(myRs.next()){
               	System.out.println(myRs.getString("fname") + ", " + myRs.getString("mname"));
		
            }
        }
        catch(SQLException e){
            System.out.println(""+e);
        }
    }
    
}
