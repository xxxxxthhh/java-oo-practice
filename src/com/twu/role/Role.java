package com.twu.role;

import com.twu.command.HotSearch;
import com.twu.command.UsualHot;

import java.util.Scanner;

public class Role {
    protected String userName;
    protected int roleCode;
    public String getUsername(){ return userName;}
    public int getroleCode() { return roleCode;}
    public HotSearch createUsualHotSearch() {
        System.out.print("请输入普通热搜名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        return new UsualHot(name);
    }
}
