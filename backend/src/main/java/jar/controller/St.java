package jar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.dto.studentdto;
import jar.model.Student;
import jar.repo.StudentRepo;
import jar.services.studentService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1")
public class St {

    private final studentService studentService;

    @Autowired
    StudentRepo db;

    @Autowired
    public St(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    Map<Object, Object> m1() {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to get api");
        res.put("status", 200);
        res.put("data", m3());

        return res;
    }

    @PostMapping()
    Map<Object, Object> m2(@RequestBody Student d) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to Post api");
        res.put("status", 201);
        String name = d.getName();
        String email = d.getEmail();
        String ip = d.getIp();
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setIp(ip);

        System.out.println("\n\t check 1 : " + d.getName());
        System.out.println("\n\t check 1 : " + d.getEmail());
        System.out.println("\n\t check 1 : " + d.getIp());

        Student saved = db.save(s);
        res.put("id", saved.getId());

        return res;
    }

    List<Student> m3() {
        return db.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<studentdto> updateStudent(@PathVariable Long id, @RequestBody studentdto studentDto) {
        studentdto updateStudent = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Delated Successfully");
    }

}
