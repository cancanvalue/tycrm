package com.javasm.tycrm.entity;

import java.util.List;

/**
 * @ClassName MenuSubEntity
 * @Description
 * @Author WORK-GROUP
 * @Date 2019/9/8 0:35
 * @Version V1.0
 **/
public class MenuSubEntity {

    private Short menuId;
    private String menuName;
    private Short menuSuperId;
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

    public Short getMenuSuperId() {
        return menuSuperId;
    }

    public void setMenuSuperId(final Short menuSuperId) {
        this.menuSuperId = menuSuperId;
    }

    public List<MenuSubEntity> getMenuSub() {
        return menuSub;
    }

    public void setMenuSub(final List<MenuSubEntity> menuSub) {
        this.menuSub = menuSub;
    }


    @Override
    public String toString() {
        return "MenuSubEntity{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuSuperId=" + menuSuperId +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuSub=" + menuSub +
                '}';
    }
}
