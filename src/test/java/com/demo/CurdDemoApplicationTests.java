package com.demo;

import java.util.Optional;

import org.apache.logging.slf4j.SLF4JLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.student;
import com.demo.repository.studentrepository;

@SpringBootTest
class CurdDemoApplicationTests {
//	private static final Logger Logger =LoggerFactory.getLogger(CurdDemoApplicationTests.class);
	@Autowired
	private studentrepository studentRepo;
	@Test
	void saveStudent() {
		student s=new student();
		s.setName("Shaku");
		s.setCourse("Dev");
		s.setCourse_fee(5000);
//		System.out.println(studentRepo);
		studentRepo.save(s);
	}	
@Test
public void deleteStudentInformation() {
	studentRepo.deleteById(10);
	}
	@Test
	public void findStudentByid() {
	Optional<student> findById = studentRepo.findById(1);
	if(findById.isPresent()) {
		student stu=findById.get();
		System.out.println(stu.getId());
		System.out.println(stu.getName());
		System.out.println(stu.getCourse());
		System.out.println(stu.getCourse_fee());
	}else {
		System.out.println("No record found");
	}	
	}
	@Test
	public void updateStudentInfo() {
		Optional<student> obj = studentRepo.findById(1);
		student stu=obj.get();
		stu.setCourse_fee(20000);
		studentRepo.save(stu);	
	}
	@Test
	public void findStudentexits() {
		boolean val=studentRepo.existsById(1);
		System.out.println(val);
	}
	@Test
	public void getAllRecords() {
		Iterable<student>findAll=studentRepo.findAll();
		for(student stu:findAll) {
			System.out.println(stu.getId());
			System.out.println(stu.getName());
			System.out.println(stu.getCourse());
			System.out.println(stu.getCourse_fee());	
		}
		System.out.println(findAll);
	}

}
