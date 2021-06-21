
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class OracleConnection {
    
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData resultsetMetaData;
    
    public OracleConnection() {
        
        
    }
    
    String[] connection()
    {
        String[] stringArray = new String[3];
        
        final String port="1521";
        final String db="xe";
 //      final String user="Faria Alam";
 //     final String password="4736910";
        final String user="emon49";
        final String password="emon49";
        final String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
        stringArray[0]=jdbcUrl;
        stringArray[1]=user;
        stringArray[2]=password;        
        return stringArray;
    }
    
}
