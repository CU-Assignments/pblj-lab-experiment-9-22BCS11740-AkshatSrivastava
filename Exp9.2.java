
<hibernate-configuration>  
<session-factory>  
<property 
name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>  
<property 
name="hibernate.connection.url">jdbc:mysql: 
<property name="hibernate.connection.username">root</property>  
<property 
name="hibernate.connection.password">password</property>  
<property 
name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>  
<property name="hibernate.hbm2ddl.auto">update</property>  
<mapping class="Student"/>  
</session-factory>  
</hibernate-configuration>  
import javax.persistence.*;  
Entity  

public class Student {  
Id  
GeneratedValue(strategy = 
GenerationType.IDENTITY)     private int id;     
String name;  
private int age;  
public Student() {}  
public Student(String name, int 
age) {         
this.name = name;         
this.age = age;  
}  

} import 
org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;  
public class HibernateUtil {  
private 
private static final SessionFactory sessionFactory;  
static 
{  
sessionFactory = new Configuration().configure().buildSessionFactory();  
}  
public static SessionFactory getSessionFactory() {  
return sessionFactory;  
}  
}  
import org.hibernate.*;  
public class MainCRUD {  
public static void main(String[] args) {  
Session session = HibernateUtil.getSessionFactory().openSession();  
 
Transaction tx = session.beginTransaction();         
Student s1 = new Student("Aman", 22);  
session.save(s1);  
tx.commit();  
 
Student student = session.get(Student.class, 1);  
System.out.println(student);  
 
tx = session.beginTransaction();         
student.setAge(23);         
session.update(student);         
tx.commit();  

tx = session.beginTransaction();         
session.delete(student);  
tx.commit();  
session.close();  
}  
}  
