package net.musecom.tempwork.dao;

import java.util.List;

import org.springframework.ui.Model;

import net.musecom.tempwork.model.BloggerDto;

public interface BloggerDao {
    
	public int create(BloggerDto dto);
	
	public int update(BloggerDto dto);
	
	public int delete(int bloggerId);
	
	public List<BloggerDto> read();
	
	public BloggerDto findStudentById(int bloggerId);
	
	void increaseHit(int postId); 
}
