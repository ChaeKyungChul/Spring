package net.musecom.spboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.musecom.spboard.dto.SpBoardDto;

@Mapper
public interface SpBoardMapper {
    //insert
	public int insert(SpBoardDto dto);
    
	//update
	public int update(SpBoardDto dto);
	
	//delete
	public int delete(int id);
	
	//전체 게시글 수
	public int selectTotalCount();
	
	//상세보기
	public SpBoardDto selectDetail(int id);
	
	//목록보기
	public List<SpBoardDto> selectList(int limitPage, int viewlist);
}
