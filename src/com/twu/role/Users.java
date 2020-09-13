package com.twu.role;

import com.twu.view.FuncView;

import java.util.Scanner;

public class Users extends Role{
    private int tickets;
    public Users(String name, int tickets){
        this.userName = name;
        this.roleCode = 1;
        this.tickets = tickets;
    }

    public static void collectUserName(){
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String user_name = input.nextLine();
        Users user = new Users(user_name, 10);
        System.out.print("欢迎进入系统, 亲爱的");
        System.out.println(user.getUsername());
        FuncView.userFunc(user);
    }
}
