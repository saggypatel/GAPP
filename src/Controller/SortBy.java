package Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;


@WebServlet("/SortBy")
public class SortBy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SortBy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortby = request.getParameter("column");

		List<Student> applicants = (List<Student>) getServletContext().getAttribute("applicants");
		
		List<Student> temp1 = new ArrayList<Student>();
		List<Student> temp2 = new ArrayList<Student>();
		
		if(sortby.equals("name")){
			
		for(int i=0;i<applicants.size()-1;i++){
			for(int j=0;j<applicants.size()-1;j++){
				
				int x=0;
				x=(applicants.get(j).name.toLowerCase()).compareTo(applicants.get(j+1).name.toLowerCase());
				
				if(x>0){
					temp1.add(0,applicants.get(j+1));
					temp2.add(0,applicants.get(j));

					applicants.set(j, temp1.get(0));
					applicants.set(j+1, temp2.get(0));
					
				}
			}
		}
	}
		
		if(sortby.equals("gpa")){
			for(int i=0;i<applicants.size()-1;i++){
				int maxindex = i;
				for(int j=i;j<applicants.size();j++){
					System.out.println(applicants.get(maxindex).gpa+"-------------"+applicants.get(j).gpa);
					if(applicants.get(j).gpa == null){
						//j=j+1;
						for(Student s:applicants){
							System.out.println("if j-- "+s.gpa);
						}
					}
					else if(applicants.get(maxindex).gpa == null){
						temp1.add(0,applicants.get(j));
						temp2.add(0,applicants.get(maxindex));
						
						applicants.set(maxindex, temp1.get(0));
						applicants.set(j, temp2.get(0));
						
						for(Student s:applicants){
							System.out.println("if maxindex- "+s.gpa);
						}
					}
					else{
						if(Double.compare(applicants.get(maxindex).gpa, applicants.get(j).gpa)<0){
							maxindex=j;
						}
					}
				}
				temp1.add(0,applicants.get(i));
				temp2.add(0, applicants.get(maxindex));
				
				applicants.set(i, temp2.get(0));
				applicants.set(maxindex, temp1.get(0));
				
			}
		}
		/*if(sortby.equals("gpa")){
			for(int i=0;i<applicants.size()-1;i++){
				for(int j=0;j<applicants.size()-1;j++){
					
					int x=0;
					if(applicants.get(j).gpa==null){
						temp1.add(0,applicants.get(j+1));
						temp2.add(0,applicants.get(j));
						
						applicants.set(j, temp1.get(0));
						applicants.set(j+1, temp2.get(0));
						
					}
					else if(applicants.get(j+1).gpa==null){
						//do nothing
					}
					else{
					
						x=Double.compare(applicants.get(j).gpa,applicants.get(j+1).gpa);
					
					if(x<0){
						temp1.add(0,applicants.get(j+1));
						temp2.add(0,applicants.get(j));
						
						applicants.set(j, temp1.get(0));
						applicants.set(j+1, temp2.get(0));

					}	
					}
				}
			}
		}*/
		
		if(sortby.equals("status")){

			for(int i=0;i<applicants.size()-1;i++){
				for(int j=0;j<applicants.size()-1;j++){
					int x=0;
					
					x=(applicants.get(j).status.toLowerCase()).compareTo(applicants.get(j+1).status.toLowerCase());
					
					if(x>0){
						temp1.add(0,applicants.get(j+1));
						temp2.add(0,applicants.get(j));
						applicants.set(j, temp1.get(0));
						applicants.set(j+1, temp2.get(0));
						
					}	
				}
			}
		}
		
		if(sortby.equals("date")){
			DateFormat df = new SimpleDateFormat("M/d/yyyy");
			//List<Student> temp = new ArrayList<Student>();
			
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
			        	   temp1.add(0,applicants.get(j));
			        	   temp2.add(0, applicants.get(j+1));
			        	   
			        	   applicants.set(j, temp2.get(0));
			        	   applicants.set(j+1, temp1.get(0));
			        	   //temp.removeAll(temp);
			        	   
			           }    
			       }
			       catch (Exception ex ){
			          System.out.println(ex);
			       }
				}
			}
		}
		
		response.sendRedirect("ApplicationList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
