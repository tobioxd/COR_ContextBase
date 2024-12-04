package com.example.demo.command.test;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class BusinessLogicCommand implements Command {
    @Override
    public boolean execute(Context context) {
        System.out.println("Xử lý nghiệp vụ...");
        return false; // Tiếp tục chain
    }
}