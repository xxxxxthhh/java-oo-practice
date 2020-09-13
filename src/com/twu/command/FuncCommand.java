package com.twu.command;

import java.util.ArrayList;

public class FuncCommand {
    protected Billboard billboard;
    public FuncCommand() {
        this.billboard = new Billboard(new ArrayList<HotSearch>());
    }
}
