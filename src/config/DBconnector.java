package config;

        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBconnector {
        Connection cn;

    public DBconnector() {
        try{
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ako_ni", "root","");
        }catch(SQLException er){System.out.println("Cannot Connect To DB"+er.getMessage());}
    }
    
    public ResultSet getData(String sql) throws SQLException{
      Statement st = (Statement) cn.createStatement(); 
      ResultSet rs = st.executeQuery(sql); 
      return rs;
    }
}