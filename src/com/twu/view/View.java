package com.twu.view;


import com.twu.command.loginCommand;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    loginCommand commander = new loginCommand();

    public void showView() {
        int command = -1; //初始化命令
        do {
            System.out.println("您可以进行的操作有：");
            System.out.println("1. 用户登录");
            System.out.println("2. 退出");
            System.out.print("请输入数字：");

            Scanner scanner = new Scanner(System.in);
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
            }

            commander.getCommand(command);
        } while (command != 2);
    }
}
