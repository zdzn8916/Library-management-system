package com.xiaokasidi.service;


import com.xiaokasidi.dao.Impl.UserDaoImpl;
import com.xiaokasidi.dao.UserDao;
import com.xiaokasidi.entity.Log;
import com.xiaokasidi.entity.Persmission;
import com.xiaokasidi.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImpl();
    public User getUser(String name, String pwd) {
        User user = null;
        user=userDao.getUser(name,pwd);
        return user;
    }
    public List<Persmission> getPermission(int id) {
        List<Persmission> permission = userDao.getPermission(id);
        return permission;
    }

    public List<User> selectAll(){
        List<User> users = userDao.selectAll();
        return users;
    }
    public void delete1(int userId){
        userDao.delete1(userId);
    }

    public User selectById(int userId){
        User user = userDao.selectById(userId);
        return user;
    }
    public void upd(int id,String role){
        userDao.upd(id,role);
    }
    public void add(User user){
        userDao.add(user);
    }
    public List<Log> selectAllLog(){
        List<Log> logList = userDao.selectAllLog();
        return logList;

    }
    //用来测试
    @Test
    public void test(){
        User user=new UserDaoImpl().getUser("xiaoka","z15788901");
        System.out.println(user);
    }
    @Test
    public void test2(){
        List<Persmission> permission = getPermission(2);
        System.out.println(permission);
    }
    @Test
    public void test3(){
        List<User> users = userDao.selectAll();
        System.out.println(users);
    }
    @Test
    public void test4(){
        userDao.delete1(5);

    }
    @Test
    public void test5(){
        User user = userDao.selectById(1);
        System.out.println(user);

    }
    @Test
    public void test6(){
        userDao.upd(4,"4");

    }
    @Test
    public void test7(){
        userDao.add(new User(null,"xksdll","123456","2"));

    }
    @Test
    public void test8(){
        List<Log> logList = userDao.selectAllLog();
        System.out.println(logList);
    }
}
