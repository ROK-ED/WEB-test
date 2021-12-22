package com.test.comm;

import java.util.List;

public class CommService {
	CommDAO dao = new CommDAO();
	
	/*
	 * //댓글 한건 public CommVO selectOne(int cmId, int tId) { return
	 * dao.commSearch(cmId, cmId); }
	 */
	//게시글 등록
	public CommVO insert(CommVO vo) {
		return dao.commInsert(vo);
	}
	
	//게시글 수정
	/*
	 * public CommVO update(CommVO vo) { return dao.commUpdate(vo); }
	 */
	
	
	//게시글 삭제
	public CommVO delete(int cmId, String cPw) {
		return dao.commDelete(cmId,cPw);
	}
	
	//게시글 전체조회
	public List<CommVO> searchAll(int tId){
		return dao.commList(tId);
	}
	
}
