package pl.sda.readstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Student[] students = objectMapper.readValue(new File("student.json"), Student[].class);

            List<Student> studentList = Arrays.asList(students);

            studentList.stream().forEach(s -> System.out.println(s));

            studentList.stream()
                    .filter(s -> s.getName().startsWith("A"))
                    .forEach(s -> System.out.println(s));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
