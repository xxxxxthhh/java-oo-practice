package com.twu.role;

import com.twu.view.FuncView;

import java.util.Scanner;
import java.util.function.Function;

public class Admin extends Role{

    public Admin(String name){
        this.userName = name;
        this.roleCode = 2;
    }

    public static void collectAdminName(){
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String adminName = input.nextLine();
        Admin admin = new Admin(adminName);
        System.out.print("欢迎你，管理员：");
        System.out.println(admin.getUsername());
        FuncView.adminFunction(admin);
    }

}
