package jwp.zajecia;

import jwp.zajecia.Student;
import org.omg.CORBA.portable.Delegate;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class StudentApi {
	private StudentManager studentManager;

	public StudentApi(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
	@GetMapping("/showStudents")
	public Iterable<Student> getStudents(){
		return studentManager.getStudentList();
	}
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student){
		 return studentManager.addStudent(student);
	}
	@DeleteMapping("/deleteStudent")
	public void deleteStudent(@RequestParam Long id){
		 studentManager.removeStudent(id);
	}
	@PutMapping("/updateData")
	public boolean updateStudent(@RequestParam Long id, @RequestBody Student student){
		return studentManager.updateStudent(id,student);
	}
	@GetMapping("/showStudentsByStopien")
	public Iterable<Student> getStudentsByStopien(@RequestParam StopienStudiow stopien){
		return studentManager.getStudentsByStopien(stopien);
	}
}
