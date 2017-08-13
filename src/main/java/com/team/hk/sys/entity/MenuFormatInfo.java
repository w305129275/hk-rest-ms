package com.team.hk.sys.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 返回vue-router路由菜单格式
 */
public class MenuFormatInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;            // 主键
    private String path;        // 路径
    private String component;   // 组件
    private String redirect;    // 请求方式
    private String name;        // 名字
    private String icon;        // 图标
    private Long parent;        // 父类菜单
    private String[] role;      // 角色
    private int type;           // 类型

    private List<MenuFormatInfo> children;      // 子类菜单

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public List<MenuFormatInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuFormatInfo> children) {
        this.children = children;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MenuFormatInfo() {
    }

    @Override
    public String toString() {
        return "MenuFormatInfo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parent=" + parent +
                ", role=" + Arrays.toString(role) +
                ", type=" + type +
                ", children=" + children +
                '}';
    }
}
