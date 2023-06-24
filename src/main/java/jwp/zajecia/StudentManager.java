package jwp.zajecia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.*;

@Service
public class StudentManager {
	@Autowired
	private StudentRepo studentRepo;


	public StudentManager(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;


	}


	public Student addStudent(Student student){
		return studentRepo.save(student);
	}
	public Iterable<Student> getStudentList(){
		return studentRepo.findAll();
	}
	public void removeStudent(Long id){
	studentRepo.deleteById(id);
	}
	public boolean updateStudent(Long id, Student updatedStudent){
			if(studentRepo.findById(id).isPresent()) {
				Student student = studentRepo.findById(id).get();
				student.setImie(updatedStudent.getImie());
				student.setNazwisko(updatedStudent.getNazwisko());
				student.setWiek(updatedStudent.getWiek());
				student.setStopienStudiow(updatedStudent.getStopienStudiow());
				studentRepo.save(student);
				return true;
			}
			return false;
	}
	public Iterable<Student> getStudentsByStopien(StopienStudiow stopienStudiow){
		return studentRepo.findAllByStopienStudiow(stopienStudiow);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void runExample(){

	}
}
