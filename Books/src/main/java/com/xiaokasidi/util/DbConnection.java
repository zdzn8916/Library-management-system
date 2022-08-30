package com.xiaokasidi.util;

import com.xiaokasidi.test.test1;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

import java.sql.*;
//连接到数据库的工具类
public class DbConnection {

    public static Connection getConn(){
        Logger logger = Logger.getLogger(test1.class);
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/books?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "z15788901";


        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {

            logger.error("mysql没有启动");
        } catch (SQLException e) {

            logger.error("mysql没有启动");
            e.printStackTrace();
        }
        return connection;

    }
    public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs){
        try {
            conn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
