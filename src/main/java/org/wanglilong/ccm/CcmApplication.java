package org.wanglilong.ccm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wanglilong.ccm.dao.api")
public class CcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcmApplication.class, args);
	}
}
