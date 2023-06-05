package cs544.C;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    private Long studetnid;
    private String firstname;
    private String lastname;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Course> courseList = new ArrayList<>();

    public Student(Long studetnid, String firstname, String lastname) {
        this.studetnid = studetnid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addCourse(Course course) {
        courseList.add(course);
        if(!course.getStudentList().contains(this)) {
            course.addStudent(this);
        }
    }
}
