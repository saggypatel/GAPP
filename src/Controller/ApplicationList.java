package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;

@WebServlet("/ApplicationList")
public class ApplicationList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApplicationList() {
    	super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		List<Student> applicants = new ArrayList<Student>();
		
		applicants.add( new Student( 1, "John", "07/09/2015",3.3,"Accepted" ) );
		applicants.add( new Student( 2, "Doe", "07/10/2015",null,"Pending Review" ) );
		applicants.add( new Student( 3, "Aaa", "07/08/2015",3.1,"Rejected" ) );
		applicants.add( new Student( 4, "sagar", "05/09/2014",null,"Accepted" ) );
		applicants.add( new Student( 5, "patel", "07/10/2016",4.0,"Pending Review" ) );

		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		List<Student> temp = new ArrayList<Student>();
		
		for(int i = 0 ;i<applicants.size()-1;i++){
			for(int j = 0 ;j<applicants.size()-1;j++){
			String date1=applicants.get(j).date;
			String date2=applicants.get(j+1).date;
			
			try
		       {
		           Date d1 = df.parse(date1);
		           Date d2 = df.parse(date2);
		           
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

        getServletContext().setAttribute( "applicants", applicants );
        
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "WEB-INF/Applications.jsp" ).forward(
	            request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
