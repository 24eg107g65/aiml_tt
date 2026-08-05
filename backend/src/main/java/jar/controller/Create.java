package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;


@RestController
@RequestMapping("/api/v1")
public class Create {

    @Autowired
    StudentRepo db;

    @PostMapping
    public Map<Object, Object> create(@RequestBody Student d) {

        Map<Object, Object> res = new HashMap<>();

        Student s = new Student();
        s.setName(d.getName());
        s.setEmail(d.getEmail());
        s.setIp(d.getIp());

        db.save(s);

        res.put("msg", "Student Added Successfully");
        res.put("status", 201);
        res.put("data", s);

        return res;
    }
    
    
}
