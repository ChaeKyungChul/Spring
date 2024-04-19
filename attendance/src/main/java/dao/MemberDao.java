package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import attendance.dto.DBto;
import attendance.dto.PDto;

public class MemberDao {
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	//로그인
	public DBto login(String name, String student_id, String password) {
		String sql = "select * from student where name=? and stnum=? and pass=?";
		DBto dto = new DBto();
		
		try {
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, student_id);
			System.out.println(pstmt);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setStudent_id(rs.getString("stNum"));
				dto.setPassword(rs.getString("pass"));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return dto;
		
	}
	//로그인(교수)
	public PDto login(String name, String password) {
		String sql = "select * from professor where name=? and userpass=?";
		PDto dto = new PDto();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			System.out.println(pstmt);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setUserpass(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	//수강신청
	public int code(String student_id, String code) {
		int rs= 0;
		String sql = "UPDATE students set code = ? where student_id=?";
		DBto dto = new DBto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, student_id);
			rs = pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {e.printStackTrace();
		}
	}
	return rs;
	}
	
	
	public ArrayList<DBto> gradeDB(String code) {
	    String sql = "select * from student where id=? and name =?";
	    ArrayList<DBto> list = new ArrayList<>();
	   
	    try {
	        pstmt = conn.prepareStatement(sql);     
	        pstmt.setString(1, code);       
	        rs = pstmt.executeQuery(); 
	         
	        while(rs.next()) {
	                      
	          //  int Id = rs.getInt("id");
	          //  String Name = rs.getString("name");
	          //  String subject = rs.getString("subject");
	          //  double score = rs.getDouble("score");

	            DBto dto = new DBto(); // while 루프 내에서 객체 생성         
	            dto.setId(rs.getInt("id"));
	            dto.setName(rs.getString("name"));
	            dto.setSubject(rs.getString("subject"));
	            dto.setScore(rs.getDouble("score"));	            
	            list.add(dto);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(pstmt != null) pstmt.close();
	            if(rs != null) rs.close();
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	      
	    return list;
	}
}
