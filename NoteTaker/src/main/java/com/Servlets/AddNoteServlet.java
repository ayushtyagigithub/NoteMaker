package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.entity.Notes;
import com.helper.FactoryProvider;

public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Notes note=new Notes(title,content,new Date());
			System.out.println(note.getId()+" "+note.getTitle());
			Session s=FactoryProvider.getFactory().openSession();
			org.hibernate.Transaction t=s.beginTransaction();
			s.save(note);
			t.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter r=response.getWriter();
			r.println("<h1 style='text-align:center'>Note Added Successfully.</h1>");
			r.println("<h4 style='text-align:center'><a href='shownotes.jsp'>View All Notes.</a></h4>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
