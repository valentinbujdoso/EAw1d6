package cs544.C;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@ToString
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Map<Long, Student> studentMap = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        studentMap.put(student.getStudentid(), student);
    }
}
