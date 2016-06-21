package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;

@WebServlet("/AddApplication")
public class AddApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int idSeed = 100;
	
	public AddApplication() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher( "/WEB-INF/AddApplication.jsp" ).forward(
		            request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String status = request.getParameter("status");
		
		 List<Student> applicants = (List<Student>) getServletContext().getAttribute("applicants");
		//double gpa = Double.parseDouble( request.getParameter("gpa") );
		if(request.getParameter("gpa").equals("")){
			Student applicant = new Student( idSeed++, name, date, null , status );
			 applicants.add( applicant );
		}
		else{
			double gpa = Double.parseDouble(request.getParameter("gpa"));
			Student applicant = new Student( idSeed++, name, date, gpa , status );
			 applicants.add( applicant );
		}

		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		List<Student> temp = new ArrayList<Student>();
		for(int i = 0 ;i<applicants.size()-1;i++){
			for(int j = 0 ;j<applicants.size()-1;j++){
			
			String date1=applicants.get(j).date;
			String date2=applicants.get(j+1).date;
			
			try
		       {
		           //format() method Formats a Date into a date/time string. 
		           Date d1 = df.parse(date1);
		           Date d2 = df.parse(date2);
		           
		           System.out.println(d2.compareTo(d1)+"<-------->");
		           int x = d2.compareTo(d1);
		           if(x>0){
		        	   temp.add(0,applicants.get(j));
		        	   temp.add(1, applicants.get(j+1));
		        	   
		        	   applicants.set(j, temp.get(1));
		        	   applicants.set(j+1, temp.get(0));
		        	   temp.removeAll(temp);
		        	   
		           }
		           
		       }
		       catch (Exception ex ){
		          System.out.println(ex);
		       }
			}
		}
		
        response.sendRedirect( "ApplicationList" );
	}

}
