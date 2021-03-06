package com.test.staff_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.test.staff_mybatis.board.C;
import com.test.staff_mybatis.board.beans.IWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void excute(Model model) {
		Map<String, Object>map = model.asMap();
		int uid = (Integer)map.get("uid");

		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("delete", dao.deleteByUid(uid));
		

	}
	


}
