package jar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jar.model.Student;

public class studentdto {
    private Long id;

    @NotBlank(message = "Student name is required")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    private String ip;

    public studentdto() {
    }

    public studentdto(Long id, String name, String email, String ip) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ip = ip;
    }

    public static studentdto mapToStudentDto(Student st) {
        studentdto dto = new studentdto();
        dto.setId(st.getId());
        dto.setName(st.getName());
        dto.setEmail(st.getEmail());
        dto.setIp(st.getIp());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
