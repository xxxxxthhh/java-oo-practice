package com.twu.command;

import com.twu.role.Users;

public class UserFunc extends FuncCommand {
    private Users roleUser;
    public UserFunc(Users user){
        this.roleUser = user;
    }

    public void UserFunction(int choice) {
        switch (choice) {
            case 1:
                this.billboard.display();
                break;
            case 2:
                this.billboard.addHotSearch(roleUser.createUsualHotSearch());
                break;
            case 3:
                this.billboard.vote(roleUser.voteForHotSearch());
                break;
            case 4:
                // hotSearchBillboard.userPayForHotSearch(roleUser.payForHotSearch());
                System.out.println("等待开发！");
                break;
            case 5:
                System.out.println("退出成功！");
                break;
            default:
                System.out.println("命令输入有误！");
        }
    }
}
