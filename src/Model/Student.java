package Model;

public class Student {
	
	Integer id;
	public String name;
	public String date;
	public Double gpa;
	public String status;
	
	public Student(int id, String name, String date, Double gpa, String status){
		
		this.id=id;
		this.name=name;
		this.date=date;
		this.gpa=gpa;
		this.status=status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
