package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class Delete {

    @Autowired
    StudentRepo db;

    @DeleteMapping("/{id}")
    public Map<Object, Object> delete(@PathVariable Integer id) {

        Map<Object, Object> res = new HashMap<>();

        if (db.existsById(id)) {

            db.deleteById(id);

            res.put("msg", "Student Deleted Successfully");
            res.put("status", 200);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);

        }

        return res;
    }
}