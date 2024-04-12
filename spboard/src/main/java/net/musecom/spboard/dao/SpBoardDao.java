package net.musecom.spboard.dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.musecom.spboard.dto.SpBoardDto;

public class SpBoardDao implements DaoInterface {
	
	DataSource dataSource;
	Connection conn = null;
	
	public SpBoardDao() {  
		
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/spboard");
			
			//커넥션 
			
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public ArrayList<SpBoardDto> list(int limet, int maxlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpBoardDto select(int pa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
