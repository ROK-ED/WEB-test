package com.test.board;

import java.util.List;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//상세 설명
	public BoardVO search(int bId) {
		return dao.boardSearch(bId);
	}
	
	//게시글 삭제
	public BoardVO delete(int bId) {
		return dao.boardDelete(bId);
	}
	
	//게시글 등록
	public BoardVO insert(BoardVO vo) {
		return dao.boardInsert(vo);
	}
	
	//게시글 전체조회
	public List<BoardVO> searchAll(){
		return dao.boardList();
	}
	
	
}
