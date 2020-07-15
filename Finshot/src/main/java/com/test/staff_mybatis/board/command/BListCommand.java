package com.test.staff_mybatis.board.command;

import org.springframework.ui.Model;

import com.test.staff_mybatis.board.C;
import com.test.staff_mybatis.board.beans.IWriteDAO;



public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list",dao.select());
				
		

	}

}
