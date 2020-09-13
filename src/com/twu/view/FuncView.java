package com.twu.view;
import	java.security.KeyStore.Builder;

import com.twu.command.Billboard;
import com.twu.command.HotSearch;
import com.twu.command.UserFunc;
import com.twu.role.Admin;
import com.twu.role.Role;
import com.twu.role.Users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncView {
    protected Billboard billboard;
    public FuncView() {
        this.billboard = new Billboard(new ArrayList<HotSearch>());
    }

    public static void userFunc(Users user) {
        UserFunc insideFunc = new UserFunc(user);
        int choice = -1;
        do {
            System.out.print("你好，");
            System.out.print(user.getUsername());
            System.out.println("，你可以");
            System.out.println("1.查看热搜排行榜");
            System.out.println("2.添加热搜");
            System.out.println("3.给热搜事件投票");
            System.out.println("4.购买热搜");
            System.out.println("5.退出");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error! Input invalid");
            }
            insideFunc.UserFunction(choice);
        }while(choice != 5);

    }

    public static void adminFunc(Admin admin) {
        int choice = -1;
        do {
            System.out.print("你好，");
            System.out.print(admin.getUsername());
            System.out.println(",你可以");
            System.out.println("1.查看热搜排行榜");
            System.out.println("2.添加热搜");
            System.out.println("3.添加超级热搜");
            System.out.println("4.退出");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error! Input invalid");
            }
        }while (choice != 4);

    }
}
