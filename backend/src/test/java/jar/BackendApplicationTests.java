package jar;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jar.model.Student;
import jar.repo.StudentRepo;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1",
		"spring.datasource.driver-class-name=org.h2.Driver",
		"spring.datasource.username=sa",
		"spring.datasource.password=",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect"
})
@ActiveProfiles("test")
class BackendApplicationTests {

	@Autowired
	StudentRepo studentRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldGenerateIdAutomaticallyOnSave() throws Exception {
		Student student = new Student();
		student.setName("Alice");
		student.setEmail("alice@example.com");
		student.setIp("127.0.0.1");

		Student saved = studentRepo.save(student);
		Field idField = Student.class.getDeclaredField("id");
		idField.setAccessible(true);
		Object generatedId = idField.get(saved);

		assertNotEquals(0L, generatedId);
	}

}
