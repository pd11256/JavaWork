package com.lec.sts13_jdbc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import old.*;

@Controller
@RequestMapping("/old")
public class OldController {
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		new ListCommand().excute(request, response);
		return "old/list";
	}
	

	@RequestMapping("/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response) {
		return "old/write";
	}
	
	@RequestMapping("/writeOk.do")
	public String writeOk(HttpServletRequest request, HttpServletResponse response) {
		new WriteCommand().excute(request, response);
		return "old/writeOk";
	}
	
	@RequestMapping("/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response) {
		new ViewCommand().excute(request, response);
		return "old/view";
	}
	
	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		new SelectCommand().excute(request, response);
		return "old/update";
	}
	
	@RequestMapping("/updateOk.do")
	public String updateOk(HttpServletRequest request, HttpServletResponse response) {
		new UpdateCommand().excute(request, response);
		return "old/updateOk";
	}
	
	@RequestMapping("/deleteOk.do")
	public String deleteOk(HttpServletRequest request, HttpServletResponse response) {
		new DeleteCommand().excute(request, response);
		return "old/deleteOk";
	}
	
	
}
















