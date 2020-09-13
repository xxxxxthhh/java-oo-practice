package com.twu.command;

import com.twu.role.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Billboard {
    private List<HotSearch> hotSearchList; //存所有的热搜

    public Billboard(List<HotSearch> hotSearchList) {
        this.hotSearchList = hotSearchList;
    }

    public void display(){
        // System.out.println("--------------------------------------------------");
        System.out.println("| name | voteNum" ); //| isBrought | broughtMoney |"
        // System.out.println("--------------------------------------------------");
        int i = 1;

        for (HotSearch hotSearch : hotSearchList) {
            System.out.print("| " + i++ + ". ");
            System.out.println(hotSearch);
        }
    }

    public void addHotSearch(HotSearch hotSearch) {
        if (!this.hotSearchList.stream().anyMatch(
                //不区分大小写
                h -> h.getName().toLowerCase().equals(hotSearch.getName().toLowerCase())
        )) {
            this.hotSearchList.add(hotSearch);
        } else {
            System.out.println("添加热搜失败! 热搜名重复！");
        }
    }

    public void vote (Map map) {
        String name = (String) map.get("name");

        if (name == null) {
            return;
        }

        //查找名字匹配的热搜
        Optional<HotSearch> foundOptional = this.hotSearchList.stream().filter(
                hotSearch -> hotSearch.getName().toLowerCase().equals(name.toLowerCase())
        ).findFirst();
        if (!foundOptional.isPresent()) {
            System.out.println("输入的热搜不存在!"); //名字不匹配则抛出异常
            return;
        }

        //判断热搜类型并修改热搜票数
        int voteNum = (int) map.get("voteNum");
        HotSearch foundHotSearch = foundOptional.get();
        if (foundHotSearch instanceof UsualHot) { //如果是普通热搜，票数直接相加
            foundHotSearch.setVoteNum(foundHotSearch.getVoteNum() + voteNum );
        } else if (foundHotSearch instanceof SuperHot) { //超级热搜票数翻倍
            foundHotSearch.setVoteNum(foundHotSearch.getVoteNum() + (voteNum * 2));
        }

        Users user = (Users) map.get("User");
        user.setTicket(user.getTicket() - voteNum); //更新票数

        this.sort();//投票后热搜排序
    }

    private void sort() {
        //找出所有没有购买的热搜，记录其索引位置
        List<HotSearch> unBoughtHotSearchList = new ArrayList<HotSearch>();
        //找出没有购买的热搜
        for (HotSearch hotSearch : this.hotSearchList) {
            if (!hotSearch.isBought()) {
                unBoughtHotSearchList.add(hotSearch);
            }
        }
        unBoughtHotSearchList.sort(new SortByTickets()); //没购买的热搜先排序
        //排序后依次覆盖原列表中没购买的热搜
        int i = 0; //指向this.hotSearchList
        int j = 0; //指向unBoughtHotSearchList
        for (HotSearch hotSearch : this.hotSearchList) {
            if (!hotSearch.isBought()) {
                this.hotSearchList.set(i, unBoughtHotSearchList.get(j));
                j++;
            }
            i++;
        }
    }

}
