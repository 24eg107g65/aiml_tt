package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class Read {

    @Autowired
    StudentRepo db;

    @GetMapping 
    public Map<Object, Object> read() {

        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "Student Fetched Successfully");
        res.put("status", 200);
        res.put("data", db.findAll());

        return res;
    }
    
}
