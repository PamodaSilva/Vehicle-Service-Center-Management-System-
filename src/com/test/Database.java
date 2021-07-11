package com.test;
import java.sql.*;

public class Database {
    static Connection con;

    public static Connection getConnection() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("http://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=vehicle+service+center", "root", " ");

        System.out.println("Connected");
        return con;
    }
}