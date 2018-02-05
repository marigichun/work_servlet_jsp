package com.koitt.bookmgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koitt.bookmgr.util.DBUtil;
import com.koitt.bookmgr.vo.Book;

public class BookDao {
	
	public List<Book> selectAll() throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (책 번호 내림차순 정렬, 최신등록 책 우선)
		String sql = "SELECT * FROM book ORDER BY isbn DESC";
		
		// 3. PreparedStatement 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ResultSet 객체를 이용하여 게시물 값들을 가져온 뒤 Book 객체에 저장
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book book = new Book();
			
			book.setAuthor(rs.getString("author"));
			book.setDescription(rs.getString("description"));
			book.setIsbn(rs.getInt("isbn"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setTitle(rs.getString("title"));
			
			// 글 하나에 해당하는 Book 객체를 리스트에 저장
			list.add(book);
		}
		
		// 6. 객체 해제
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		return list;
	}
	
	// isbn에 해당하는 글 하나 가져오는 기능
	public Book select(Integer isbn) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기.
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (글 번호 내림차순 정렬, 최신글 우선)
		String sql = "SELECT * FROM book WHERE osbn = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,isbn);
		
		// 4. SQL문 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. ResultSet 객체를 이용하여 게시물 값들을 가져온 뒤 Board 객체에 저장
		/*
		 *  처음에 Cursor가 BOF(Begin Of File)을 가르키고 있기 때문에 next() 메소드를
		 *  한번 호출해야 우리가 원하는 no에 해당하는 글을 가져올 수 있다.
		*/
		rs.next();
		Book book = new Book();
		book.setAuthor(rs.getString("author"));
		book.setDescription(rs.getString("description"));
		book.setIsbn(rs.getInt("isbn"));
		book.setPrice(rs.getInt("price"));
		book.setPublisher(rs.getString("publisher"));
		book.setTitle(rs.getString("title"));
		
		// 6. 객체 해제
		DBUtil.getInstance().close(rs);
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		// 7. 데이터베이스로부터 가져온 글 정보를 저장한 board 객체 리턴
		return book;
	}
	
	//글작성
	public void insert(Book book) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성 (글 번호 내림차순 정렬, 최신글 우선)
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO book(author, description,isbn, price,publisher,title)");
		sql.append("VALUES (?, ?, ?, ? CURDATE())");	// CURDATE(): MySQL에서 제공하는 함수
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, book.getAuthor());
		pstmt.setString(2, book.getDescription());
		pstmt.setInt(2, book.getIsbn());
		pstmt.setInt(4, book.getPrice());
		pstmt.setString(5, book.getPublisher());
		pstmt.setString(6, book.getTitle());
		
		// 4. SQL문 실행
		pstmt.executeUpdate();
		
		//5.생략
		
		//6.객체 해제
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		//7생략
	}
	
	//클 삭제
	public void delete(Integer isbn) throws ClassNotFoundException, SQLException {
		// 1. 데이터베이스 커넥션 객체 가져오기
		Connection conn = DBUtil.getInstance().getConnection();
		
		// 2. SQL문 작성
		String sql = "DELETE FROM book WHERE isbn = ?";
		
		// 3. PreparedStatement 객체 생성 및 물음표 채우기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, isbn);
		 
		// 4. SQL문 실행
		pstmt.executeUpdate();
		
		//5.생략
		
		//6.객체 해제
		DBUtil.getInstance().close(pstmt);
		DBUtil.getInstance().close(conn);
		
		
	}
	
}
