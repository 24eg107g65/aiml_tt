package jar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jar.dto.studentdto;
import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class StudentServiceImpl implements studentService {

    private final StudentRepo repo;

    @Autowired
    public StudentServiceImpl(StudentRepo repo) {
        this.repo = repo;
    }

    @Override
    public studentdto updateStudent(Long id, studentdto dto) {
        Optional<Student> existing = repo.findById(id);
        if (existing.isPresent()) {
            Student student = existing.get();
            student.setName(dto.getName());
            student.setEmail(dto.getEmail());
            student.setIp(dto.getIp());
            Student saved = repo.save(student);
            return studentdto.mapToStudentDto(saved);
        }
        return dto;
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
