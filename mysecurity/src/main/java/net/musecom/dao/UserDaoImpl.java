package net.musecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.musecom.model.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertUser(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserDto> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto selectOneUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isUser(int usertype, String usearch) {
		String sql = "";
		if(usertype==1) {
			sql = "select count(*) from users where username = ?";
		}else {
			sql = "select count(*) from users where useremail = ?";
		}
		
		return jdbcTemplate.queryForObject(sql, new Object[] {usearch}, Integer.class);
	}

}
