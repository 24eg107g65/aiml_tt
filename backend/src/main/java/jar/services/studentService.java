package jar.services;

import jar.dto.studentdto;

public interface studentService {
    studentdto updateStudent(Long id, studentdto dto);

    void deleteStudent(Long id);
}
