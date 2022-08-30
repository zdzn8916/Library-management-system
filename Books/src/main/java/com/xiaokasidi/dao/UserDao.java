package com.xiaokasidi.dao;


import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Log;
import com.xiaokasidi.entity.Persmission;
import com.xiaokasidi.entity.User;

import java.util.List;

//这里通过实现接口的方式，好处是业务逻辑更便于扩展
public interface UserDao {
    public User getUser(String name, String pwd);

    public List<Persmission> getPermission(int id);

    List<User> selectAll();

    void delete1(int userId);

    User selectById(int userId);

    void upd(int id,String role);

    void add(User user);

    List<Log> selectAllLog();
}
