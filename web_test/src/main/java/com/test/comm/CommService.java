package com.test.comm;

import java.util.List;

public class CommService {
	CommDAO dao = new CommDAO();
	
	//게시글 수정
	public CommVO update(CommVO vo) {
		return dao.commUpdate(vo);
	}
	
	
	//게시글 삭제
	public CommVO delete(int cmId) {
		return dao.commDelete(cmId);
	}
	
	//게시글 전체조회
	public List<CommVO> searchAll(){
		return dao.commList();
	}
	
}
