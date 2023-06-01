package com.cgi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cgi.model.Student;
import com.cgi.service.StudentServiceImpl;

@Controller
public class StudentController {

	private final StudentServiceImpl studentServiceImpl;

	public StudentController(StudentServiceImpl studentServiceImpl) {
		super();
		this.studentServiceImpl = studentServiceImpl;
	}

	@GetMapping("/")
	public String listCustomers(Model theModel) {
		List<Student> students = studentServiceImpl.getAllStudents();
		theModel.addAttribute("student", students);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveCustomer(@ModelAttribute("student") Student student) {
		studentServiceImpl.createStudent(student);
		return "redirect:/";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Optional<Student> student = studentServiceImpl.findStudentById(theId);
		theModel.addAttribute("student", student);
		return "student-form";
	}

	@GetMapping("/findStudentById")
	public String showStudentFormById(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "findStudentById";
	}

	@PostMapping("/getStudentById")
	public String showStudentById(@RequestParam("studentId") int theId, Model theModel) {
		Optional<Student> student = studentServiceImpl.findStudentById(theId);
		theModel.addAttribute("student", new Student());
		if (student.isPresent()) {
			theModel.addAttribute("students", student.get());
		} else {
			return "notFound";
		}
		return "findStudentById";
	}

	@GetMapping("/findByName")
	public String showStudentForName(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "showStudentForName";
	}

	@PostMapping("/showFormForName")
	public String showFormForName(@ModelAttribute("student") Student student, @RequestParam("name") String name,
			Model theModel) {

		List<Student> studentList = studentServiceImpl.findByName(name);

		if (!studentList.isEmpty()) {
			theModel.addAttribute("students", studentList);
		} else {
			return "notFound";
		}
		return "showStudentForName";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentServiceImpl.deleteStudentById(theId);
		return "redirect:/";
	}

	@GetMapping("/deleteAll")
	public String deleteAllStudent() {
		studentServiceImpl.deleteAllStudent();
		return "redirect:/";
	}
}
