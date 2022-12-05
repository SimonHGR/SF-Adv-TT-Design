package student;

import java.util.ArrayList;
import java.util.List;

public class School {
  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------");
  }
//  public static void showAllSmart(List<Student> ls) {
//    for (Student s : ls) {
//      if (s.getGpa() > 3) {
//        System.out.println("> " + s);
//      }
//    }
//    System.out.println("------------");
//  }

  public static List<Student> getSmart(List<Student> ls) {
    List<Student> rv = new ArrayList<>();
    for (Student s : ls) {
      if (s.getGpa() > 3.0) {
        rv.add(s);
      }
    }
    return rv;
  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 3.2),
        new Student("Jim", 2.2),
        new Student("Shiela", 3.9)
    );

    // print all students
    showAll(roster);

    // print smart students
    showAll(getSmart(roster));
  }
}
