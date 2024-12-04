package com.example.demo.command.test;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class AuthCommand implements Command {
    @Override
    public boolean execute(Context context) {
        System.out.println("Xác thực request...");
        // Nếu xác thực thất bại, có thể trả về true để dừng chain
        return false; // Tiếp tục chain
    }
}