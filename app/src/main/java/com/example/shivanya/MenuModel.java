package com.example.shivanya;

import android.content.Context;

public class MenuModel {

    public String menuName;
    Context context;
    public boolean hasChildren, isGroup;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren) {

        this.menuName = menuName;

        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}