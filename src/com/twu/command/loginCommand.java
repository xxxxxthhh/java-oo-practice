package com.twu.command;

import com.twu.role.Admin;
import com.twu.role.Users;

import java.util.InputMismatchException;
import java.util.Scanner;

public class loginCommand {
    public void getCommand(int command){
        System.out.println(command);
        int roleNum = -1; //初始化命令
        do {
            System.out.println("请选择您的身份：");
            System.out.println("1. 普通用户登录");
            System.out.println("2. 管理员登录");
            System.out.println("3. 退出");
            System.out.print("请输入数字：");

            Scanner scanner = new Scanner(System.in);
            try {
                roleNum = scanner.nextInt();
            } catch (InputMismatchException e) {
            }

            switch (roleNum){
                case 1:
                    Users.collectUserName();
                case 2:
                    Admin.collectAdminName();
            }
        } while (roleNum != 3);
    }
}
