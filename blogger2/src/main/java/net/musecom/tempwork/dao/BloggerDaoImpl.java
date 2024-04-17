package net.musecom.tempwork.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.musecom.tempwork.model.BloggerDto;

@Repository //bean 주입
public class BloggerDaoImpl implements BloggerDao {

   private JdbcTemplate template;
   
   public BloggerDaoImpl(DataSource dataSource) {
      this.template = new JdbcTemplate(dataSource);      
   }
 
  
   
   //sql insert
   @Override
   public int create(BloggerDto dto) {
      int rs = 0;
      String sql = "insert into board(title, content) values (?,?)";
      
      try {
         rs = template.update(sql, 
                 new Object[] {      
  
                     dto.getTitle(),
                     dto.getContent()
         });   
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      return rs;
   }

   @Override
   public int update(BloggerDto dto) {
	   
	   String sql = "UPDATE board"
	   		+ " SET Title = ?, Content = ? WHERE id = ?";
    		 
     try {
    	 int rs = template.update(sql, new Object[] {
    			
    			 dto.getTitle(),
    			 dto.getContent(),
    			 dto.getId(),
    		
    	 });
    	 return rs;
    	 
     }catch(Exception e) {
    	 e.printStackTrace();
    	 return 0;
     }
     
      
   }

   @Override
   public int delete(int bloggerId) {
    
	  String sql = "delete from board where id=?";
	  try {
		  int rs = template.update(sql, new Object[] {bloggerId});
		  return rs;
				  
	  }catch(Exception e) {
		  return 0;
	  }	   
    
   }

   @Override
   public List<BloggerDto> read() {
      String sql = "select * from board order by id desc";
      List<BloggerDto> stList = template.query(sql, new RowMapper<BloggerDto>() {

         @Override
         public BloggerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        	 
        	    BloggerDto dto = new BloggerDto();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWdate(rs.getTimestamp("wdate"));
                            
            return dto;
         }
         
      });
      
      return stList;
   }

   @Override
   public BloggerDto findStudentById(int bloggerId) {
   
      String sql = "select * from board where id = ?";
      try {
    	  BloggerDto stView = template.queryForObject(
    		     sql, 
    		     new Object[]{bloggerId} , 
    		     new RowMapper<BloggerDto>() { //3가지 받음

         @Override
         public BloggerDto mapRow(ResultSet rs, int rowNum) throws SQLException {

            	 BloggerDto dto = new BloggerDto();
                dto.setId(rs.getInt("id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWdate(rs.getTimestamp("wdate"));
                            //dto에 담음
            return dto;
         }
         
      });
          return stView;
      }catch(Exception e) {
    	  return null;
      }
      
     
    }

   
   @Override
   public void increaseHit(int postId) {
      String sql = "UPDATE board SET hit = hit + 1 WHERE id = ?";
      try {
          int updatedRows = template.update(sql, postId);
          if (updatedRows > 0) {
              // 조회수 증가 성공
          } else {
              // 조회수 증가 실패
          }
      } catch (Exception e) {
          e.printStackTrace();
          // 예외 처리
      }
   }
   
   
          
   
}
 	     
 	      
 	   

 	
 	

