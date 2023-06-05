package cs544.C;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coursenumber;
    private String name;
    @ManyToMany(mappedBy = "courseList")
    private List<Student2> studentList = new ArrayList<>();

    public Course(String coursenumber, String name) {
        this.coursenumber = coursenumber;
        this.name = name;
    }

    public void addStudent(Student2 student) {
        studentList.add(student);
        if(!student.getCourseList().contains(this)) {
            student.addCourse(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", coursenumber='" + coursenumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
