package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;

@WebServlet("/EditApplication")
public class EditApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public EditApplication() {
        super();
    
    }

	private Student getApplicant( Integer id )
    {
        List<Student> applicants = (List<Student>) getServletContext().getAttribute(
            "applicants" );

        for( Student applicant : applicants )
            if( applicant.getId().equals( id ) ) return applicant;

        return null;
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	 Integer id = Integer.parseInt(request.getParameter( "id" ) );
         Student applicant = getApplicant( id );

         request.setAttribute( "applicant", applicant );
         request.getRequestDispatcher( "/WEB-INF/EditApplication.jsp" ).forward(
             request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt( request.getParameter( "id" ) );
        Student applicant = getApplicant( id );
        String date = request.getParameter("date");
		
        
        applicant.setName(request.getParameter("name"));
        applicant.setDate(date);
        
        if(request.getParameter("gpa").equals("")){
        	applicant.setGpa(null);
		}
		else{
			applicant.setGpa(Double.parseDouble(request.getParameter("gpa")));	        
		}
        
        applicant.setStatus(request.getParameter("status"));
        
        response.sendRedirect( "ApplicationList" );
	}

}
