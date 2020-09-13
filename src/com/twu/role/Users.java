package com.twu.role;

import com.twu.view.FuncView;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Users extends Role{
    private int tickets;
    public Users(String name, int tickets){
        this.userName = name;
        this.roleCode = 1;
        this.tickets = tickets;
    }

    public int getTicket(){return this.tickets;}
    public void setTicket(int tickets){this.tickets = tickets;}

    public static void collectUserName(){
        System.out.println("请输入您的昵称");
        Scanner input = new Scanner(System.in);
        String user_name = input.nextLine();
        Users user = new Users(user_name, 10);
        System.out.print("欢迎进入系统, 亲爱的");
        System.out.println(user.getUsername());
        FuncView.userFunc(user);
    }

    public Map voteForHotSearch() {
        System.out.println("目前拥有的票数：" + this.getTicket());
        Scanner scanner = new Scanner(System.in);
        Map map = new HashMap();
        System.out.print("热搜名: ");
        String name = scanner.next();
        System.out.print("票数: ");
        int voteNum = -1;
        try {
            voteNum = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("票数输入有误！");
            return map;
        }

        //判断票数是否充足
        if (voteNum > this.getTicket()) {
            System.out.println("票数不足！");
            return map;
        } else if (voteNum < 0) {
            System.out.println("票数输入有误！");
            return map;
        }

        map.put("User", this);
        map.put("name", name);
        map.put("voteNum", voteNum);
        return map;
    }

}
