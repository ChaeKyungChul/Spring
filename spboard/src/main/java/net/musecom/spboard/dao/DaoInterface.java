package net.musecom.spboard.dao;

import java.util.ArrayList;

import net.musecom.spboard.dto.SpBoardDto;

public interface DaoInterface {
	//list() - 목록 , select()-상세페이지 ,del()-삭제, update()-업데이트
	public ArrayList<SpBoardDto> list(int limet, int maxlist);
	public SpBoardDto select(int pa);
	public int del(int id);
	public int update(int id);

}
