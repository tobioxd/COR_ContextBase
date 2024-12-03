package com.example.demo.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class LoggingCommand implements Command {
    @Override
    public boolean execute(Context context) {
        System.out.println("Ghi log request...");
        return false; // Tiếp tục chain
    }
}
