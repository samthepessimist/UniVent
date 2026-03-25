package za.ac.cput.factoryTest;

import org.junit.Test;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.Assert.*;

public class StudentFactoryTest {
    @Test
    public void createValidStudent() {
        Student student = StudentFactory.createStudent(
                "Samukelo",
                "sam@gmail.com",
                "1234",
                "0812543678",
                "320223456",
                "Informatics",
                "Applications Development",
                2
        );

        assertNotNull(student);
        assertEquals("Samukelo", student.getName());
        assertEquals("sam@gmail.com", student.getEmail());
    }

    @Test
     public void createStudentWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Spitjo",
                    "invalidemail",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    2
            );
        });

        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    public void createStudentWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "",
                    "sam@gmail.com",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    2
            );
        });

        assertEquals("Name is required", exception.getMessage());
    }

    @Test
    public void createStudentWithInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Sam",
                    "sam@gmail.com",
                    "1234",
                    "123", // invalid
                    "220123456",
                    "IT",
                    "ADP",
                    2
            );
        });

        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void createStudentWithInvalidYear() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(
                    "Sam",
                    "sam@gmail.com",
                    "1234",
                    "0812345678",
                    "220123456",
                    "IT",
                    "ADP",
                    0
            );
        });

        assertEquals("Year must be greater than 0", exception.getMessage());
    }
}
