package com.twu.command;

public abstract class HotSearch {
    private String name;
    private int voteNum;
    private boolean isBought;
    private double boughtMoney;

    public HotSearch(String name) {
        this.name = name;
        this.voteNum = 0;
        this.isBought = false;
        this.boughtMoney = 0;
    }

    @Override
    public String toString() {
        return name + " | " + voteNum + " | "
                + isBought + " | " + boughtMoney + " |";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }
}
