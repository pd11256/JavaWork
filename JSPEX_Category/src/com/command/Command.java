package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	void excute(HttpServletRequest request, HttpServletResponse response);
}
