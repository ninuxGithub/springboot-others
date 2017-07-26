package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by daile on 2017/7/20.
 */
public class SpringServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7756275125401955880L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();

        ServletContext servletContext = getServletContext();

        servletContext.log("SpringServlet");

        writer.write("hello SpringServlet");

    }

}
