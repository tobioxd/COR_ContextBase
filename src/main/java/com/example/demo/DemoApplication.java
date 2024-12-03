package com.example.demo;

import com.example.demo.bean.ProcessContext;
import com.example.demo.bean.Result;
import com.example.demo.bean.SimpleResult;
import com.example.demo.command.AuthCommand;
import com.example.demo.command.BusinessLogicCommand;
import com.example.demo.command.LoggingCommand;
import com.example.demo.service.CheckProcess;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private CheckProcess checkProcess;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			// Tạo ProcessContext mẫu
			ProcessContext processContext = new ProcessContext();

			// Thiết lập kết quả ban đầu (có thể thay bằng SimpleResult.UNKNOWN để kiểm tra lỗi)
			processContext.setResult(SimpleResult.OK);

			// Thực thi chuỗi kiểm tra
			checkProcess.executeProcess(processContext);

			// In kết quả cuối cùng
			if (processContext.getResult().isOk()) {
				System.out.println("Quá trình kiểm tra hoàn tất thành công!");
			} else {
				System.out.println("Quá trình kiểm tra thất bại: " + processContext.getResult());
			}
		};
	}
}
