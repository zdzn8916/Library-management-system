package com.xiaokasidi.entity;

public class Log {
    private int id;
    private String level;
    private String content;
    private String time;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Log(int id, String level, String content, String time) {
        this.id = id;
        this.level = level;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
