package config;

        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBconnector {
        Connection cn;

    public DBconnector() {
        try{
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/grade", "root","");
        }catch(SQLException er){System.out.println("Cannot Connect To DB"+er.getMessage());}
    }
    
    public ResultSet getData(String sql) throws SQLException{
      Statement st = (Statement) cn.createStatement(); 
      ResultSet rs = st.executeQuery(sql); 
      return rs;
    }
    
    //Function to save data
        public boolean insertData(String sql){
            int result;
            try{
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
                return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                return false;
            }
        }
  
       
}