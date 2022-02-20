package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from user")
	List<User> findAll();

	@Insert("insert into user(id,name,salary) values(#{id},#{name},#{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
    	before = false, resultType = Integer.class)
	void insert(User user);

	@Delete("delete from user where id=#{id}")
	void delete(Long id);
	
}
