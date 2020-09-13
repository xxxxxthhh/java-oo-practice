package com.twu.view;

import com.twu.role.Admin;
import com.twu.role.Role;
import com.twu.role.Users;

public class FuncView {

    public static void userFunc(Users user) {
        System.out.print("你好，");
        System.out.print(user.getUsername());
        System.out.println("，你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
    }
    public static void adminFunction(Admin admin) {
        System.out.print("你好，");
        System.out.print(admin.getUsername());
        System.out.println(",你可以");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
    }
}
