package com.javasm.tycrm.entity;

import java.util.List;

/**
 * @ClassName MenuOneEntity
 * @Description 一级菜单类
 * @Author 家富
 * @Date 2019/9/8 0:32
 * @Version V1.0
 **/
public class MenuMainEntity {
    private Short menuId;
    private String menuName;
    private String menuIcon;
    private List<MenuSubEntity> menuSub;

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(final String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Short getMenuId() {
        return menuId;
    }

    public void setMenuId(final Short menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(final String menuName) {
        this.menuName = menuName;
    }

    public List<MenuSubEntity> getMenuSub() {
        return menuSub;
    }

    public void setMenuSub(final List<MenuSubEntity> menuSub) {
        this.menuSub = menuSub;
    }


    @Override
    public String toString() {
        return "MenuMainEntity{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuSub=" + menuSub +
                '}';
    }
}
