package com.xiaokasidi.entity;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.jdbc.JDBCAppender;
import org.junit.Test;

public class RoolingAndDateFileAppender extends JDBCAppender {

    private String expirDays="30";//保留最近几天


    public void isDelete(String expirDays){
        long l = System.currentTimeMillis();

    }
}
