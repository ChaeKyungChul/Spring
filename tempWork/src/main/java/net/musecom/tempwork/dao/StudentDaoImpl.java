package net.musecom.tempwork.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.musecom.tempwork.model.StudentDto;

@Repository //bean 주입
public class StudentDaoImpl implements StudentDao {

   private JdbcTemplate template;
   
   public StudentDaoImpl(DataSource dataSource) {
      this.template = new JdbcTemplate(dataSource);      
   }
   
   //sql insert
   @Override
   public int create(StudentDto dto) {
      int rs = 0;
      String sql = "insert into student(stu_name, stu_email, stu_course) values (?,?,?)";
      
      try {
         rs = template.update(sql, 
                 new Object[] {      
                     dto.getStu_name(),
                     dto.getStu_email(),
                     dto.getStu_course()
         });   
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      return rs;
   }

   @Override
   public int update(StudentDto dto) {
	   
     String sql ="update student set stu_name=?, stu_email=? , stu_course =? where stu_id = ?";
     try {
    	 int rs = template.update(sql, new Object[] {
    			 dto.getStu_name(),
    			 dto.getStu_email(),
    			 dto.getStu_course(),
    			 dto.getStu_id()
    	 });
    	 return rs;
    	 
     }catch(Exception e) {
    	 e.printStackTrace();
    	 return 0;
     }
     
      
   }

   @Override
   public int delete(int studentId) {
    
	  String sql = "delete from student where stu_id=?";
	  try {
		  int rs = template.update(sql, new Object[] {studentId});
		  return rs;
				  
	  }catch(Exception e) {
		  return 0;
	  }	   
    
   }

   @Override
   public List<StudentDto> read() {
      String sql = "select * from student order by stu_id desc";
      List<StudentDto> stList = template.query(sql, new RowMapper<StudentDto>() {

         @Override
         public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                StudentDto dto = new StudentDto();
                dto.setStu_id(rs.getInt("stu_id"));
                dto.setStu_name(rs.getString("stu_name"));
                dto.setStu_email(rs.getString("stu_email"));
                dto.setStu_course(rs.getString("stu_course"));
                            
            return dto;
         }
         
      });
      
      return stList;
   }

   @Override
   public StudentDto findStudentById(int studentId) {
   
      String sql = "select * from student where stu_id = ?";
      try {
      StudentDto stView = template.queryForObject(
    		     sql, 
    		     new Object[]{studentId} , 
    		     new RowMapper<StudentDto>() { //3가지 받음

         @Override
         public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                StudentDto dto = new StudentDto();
                dto.setStu_id(rs.getInt("stu_id"));
                dto.setStu_name(rs.getString("stu_name"));
                dto.setStu_email(rs.getString("stu_email"));
                dto.setStu_course(rs.getString("stu_course"));
                            //dto에 담음
            return dto;
         }
         
      });
          return stView;
      }catch(Exception e) {
    	  return null;
      }
      
     
   }

}
