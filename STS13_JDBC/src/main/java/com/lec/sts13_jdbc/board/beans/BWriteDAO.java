package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;


public class BWriteDAO {
	JdbcTemplate template;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // 
	Connection conn = null;
	Statement stmt = null;

	public BWriteDAO() {
		this.template = C.template;
	}

	// 전체 SELECT
	public List<BWriteDTO> select() {
		return template.query(C.SQL_WRITE_SELECT, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}

	// 1. update() + PreparedStatementSetter()
	public int insert(BWriteDTO dto) {

		return template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
			}
		});
	}

//	 2. update() + PreparedStatementCreator()
//		return
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//			
//				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
//				ps.setString(1, dto.getSubject());
//				ps.setString(2, dto.getContent());
//				ps.setString(3, dto.getName());
//				
//				return ps;
//				
//			}
//		} );

	public BWriteDTO readByUid(final int uid){
		BWriteDTO dto = null;
		
		// 조회수 증가.
		template.update(C.SQL_WRITE_INC_VIEWCNT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
			}
		});
		
		// 읽기
		List<BWriteDTO> list = 
		template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,  uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
		if(list.size() > 0) dto = list.get(0);  // 읽어온 글 (첫번째 아이템)
		
		
		return dto;
	} // end readByUid()
	
	
	
//	public List<BWriteDTO> selectByUid(int uid) {
//		return template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, uid);
//			}
//			
//		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
//		
//	} 내가한것
	
	public BWriteDTO selectByUid(final int uid){
		BWriteDTO dto = null;
		
		// 읽기
		List<BWriteDTO> list = 
		template.query(C.SQL_WRITE_SELECT_BY_UID, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,  uid);
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
		if(list.size() > 0) dto = list.get(0);  // 읽어온 글 (첫번째 아이템)
		
		
		return dto;
	} // end readByUid()
	
	public int update(BWriteDTO dto) {

		return template.update(C.SQL_WRITE_UPDATE, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
			}
		});
	}
	public int deleteByUid(int uid) {
		
		return template.update(C.SQL_WRITE_DELETE_BY_UID, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
			}
		});
	}
	
//	public int deleteByUid(final int uid) {
//		int cnt = 0;
//		
//		cnt = 
//		template.update(C.SQL_WRITE_DELETE_BY_UID, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, uid);
//				
//			}
//		});		
//		
//		return cnt;
//	}
	

}
