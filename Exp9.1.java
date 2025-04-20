public class Course {     
duration;  
private String courseName;     
public Course(String courseName, String duration) {         
this.courseName = courseName;         
}  
private String 
this.duration = duration;  
public String getCourseName() { return courseName; }     public String 
getDuration() { return duration; }  
@Override  
public String toString() {  
return "Course: " + courseName + ", Duration: " + duration;  
}  
}  
public class Student {    
 private String name;    
 private 
Course course;     public Student(String name, Course course) {  

this.name = name;        
}  
 this.course = course;  
public void showDetails() {  
System.out.println("Student: " + name);  
System.out.println(course);  
}  
}
import org.springframework.context.annotation.*;  
@Configuration public class AppConfig {  
@Bean  
public Course course() {  
return new Course("Java", "3 months");  
}  
@Bean  
public Student student() {  
return new Student("Aman", course());  
}  
}// MainApp.java  
import org.springframework.context.ApplicationContext;  
import 
org.springframework.context.annotation.AnnotationConfigApplicationCon
 text;  
public class MainApp {  
public static void main(String[] args) {  
ApplicationContext context = new  
AnnotationConfigApplicationContext(AppConfig.class);        
student = context.getBean(Student.class);        
 Student 
 student.showDetails();  
} }  
