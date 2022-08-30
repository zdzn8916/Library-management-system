package com.xiaokasidi.entity;

public class Persmission {
    private int menuId;
    private String menuName;

    public Persmission(int menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Persmission() {
    }

    @Override
    public String toString() {
        return "Persmission{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
