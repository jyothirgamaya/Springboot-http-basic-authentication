package com.auth.mapper.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.auth.entity.User;

@Mapper
public interface UserMapper {
	// name of the column and entity class column name should be same else we need to take Resluts
	
	@Select("select * from users where name=#{name}")
	@Results(value= {
			   @Result(property = "name", column = "name", id = true),
			   @Result(property = "privatePassword", column = "private_password")
			   
			})
	public Optional<User> findUserByName(@Param("name")String name);
	
/*	@Select("select * from users")
	@Results(value= {
			   @Result(property = "name", column = "name", id = true),
			   @Result(property = "privatePassword", column = "private_password")
			   
			})
	public List<User> find();
	
	*/
	
	
}
