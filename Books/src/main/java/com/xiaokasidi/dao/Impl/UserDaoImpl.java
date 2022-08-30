package com.xiaokasidi.dao.Impl;

import com.alibaba.fastjson.JSON;
import com.xiaokasidi.dao.UserDao;

import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Log;
import com.xiaokasidi.entity.Persmission;
import com.xiaokasidi.entity.User;
import com.xiaokasidi.util.ConnectionUtil;
import com.xiaokasidi.util.DbConnection;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//用户表的操作数据对象
    public class UserDaoImpl implements UserDao {
    Logger logger = Logger.getLogger(UserDaoImpl.class);
        @Override
        public User getUser(String name, String pwd){
            //创建对象
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            User user=null;
            String sql = "SELECT * from user where name=? and password=?";
            try {
                conn= DbConnection.getConn();
                ps=conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,pwd);
                rs=ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String userName = rs.getString("name");
                    String passWord = rs.getString("password");
                    String role = rs.getString("role");
                    user=new User(id,userName,passWord,role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DbConnection.closeConn(conn,ps,rs);
            }
            return user;
        }

        @Override
        public List<Persmission> getPermission(int id) {
            String sql = "select * from permission WHERE id in(Select menu_id from role_menu where role_id in(select role_id from role_user where user_id=?))";
            Connection conn= DbConnection.getConn();
            ResultSet rs = null;
            List<Persmission> list = new ArrayList<>();
            try {
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                while (rs.next()) {
                    int menuId = rs.getInt("id");
                    String menuName = rs.getString("权限名称");
                    Persmission persmission = new Persmission(menuId,menuName);
                    list.add(persmission);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }

    @Override
    public List<User> selectAll() {
        String sql = "SELECT * from user";
        //创建对象
        ResultSet rs = ConnectionUtil.startConn(sql);
        List<User> userList = new ArrayList<>();

        try {
            while (rs.next()) {
                User user = ConnectionUtil.userConn(rs);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return userList;
    }

    @Override
    public void delete1(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from user where id = ?";
        try {
            conn = DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.executeUpdate();
            logger.trace("删除了id为"+userId+"的用户");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public User selectById(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        User user = null;
        String sql = "select * from user where id=?";
        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                user = ConnectionUtil.userConn(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbConnection.closeConn(conn,ps,rs);
        }
        return user;


    }

    @Override
    public void upd(int id,String role) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Update user set role=? where id = ?";
        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

            try {
                ps.setString(1,role);
                ps.setInt(2,id);
                int count = ps.executeUpdate();
                logger.trace("修改了id为"+id+"的用户");


            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "Insert into user values(null,?,?,?)";

        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            if(user!=null){
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassWord());
                ps.setString(3, user.getRole());
                int count = ps.executeUpdate();
                logger.trace("增加了用户名为"+user.getUserName()+"的用户");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Log> selectAllLog() {
        String sql = "SELECT * from log";

        //创建对象
        ResultSet rs = ConnectionUtil.startConn(sql);
        List<Log> logList = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String level = rs.getString("level");
                String content = rs.getString("content");
                String time = rs.getString("time");
                Log log = new Log(id,level,content,time);
                logList.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return logList;
    }
    protected void jsonResult(HttpServletResponse resp, Object data) throws IOException {
        String json = JSON.toJSONString(data);
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.close();
    }

}
