package com.mybatis;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mybatis.entity.User;


@MappedTypes(User.class)
//@MapperScan("com.mybatis.mapper")
@SpringBootApplication
public class MybatisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisExampleApplication.class, args);
	}

}
