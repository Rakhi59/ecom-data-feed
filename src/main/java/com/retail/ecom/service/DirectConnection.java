package com.retail.ecom.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DirectConnection {
    public static void main(String[] args) {

    	Connection conn = null;
        String dbName = "BusyComp0001_db12020";
        String serverip="103.209.147.187";
        String serverport="3331";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
        Statement stmt = null;
        ResultSet result = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String databaseUserName = "sa";
        String databasePassword = "busy@123";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
            stmt = conn.createStatement();
            result = stmt.executeQuery("select * from dbo.Master1");
            System.out.print("Result is "+result); 

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}