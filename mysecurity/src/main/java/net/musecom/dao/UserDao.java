package net.musecom.dao;

import java.util.List;

import net.musecom.model.UserDto;

public interface UserDao {

	//c r u d 구성
	
	public int insertUser(UserDto dto);
	
	public int updateUser(UserDto dto);
	
	public int deleteUser(String username);
	
	public List<UserDto> selectUser();
	
	public UserDto selectOneUser(String username);
	
	public int isUser(int usertype, String usearch);
	
}
