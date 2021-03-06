package com.lec.spring.board.command;

import java.util.Arrays;
import java.util.Map;

import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;



public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
//		BWriteDAO dao = new BWriteDAO();
//		BWriteDTO dto = dao.selectByUid(uid);
//		model.addAttribute("list", Arrays.asList(dto));
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("comlist", dao.selectCompany());
		model.addAttribute("list", Arrays.asList(dao.selectByUid(uid)));

	}

}















