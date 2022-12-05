package student;

import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses;

  public Student(String name, double gpa, String... courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = List.of(courses);
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    return courses; // List.of is unmodifiable so this is safe
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }
}
