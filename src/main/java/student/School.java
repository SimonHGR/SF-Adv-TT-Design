package student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;

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


  // somewhere
//  static DoubleSupplier ds; ??
//  static double threshold = 3.5;
//  public static List<Student> getSmart(List<Student> ls) {
//  public static List<Student> getSmart(List<Student> ls, double threshold) {
//    List<Student> rv = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGpa() > threshold) { // picks up threshold somehow
//        rv.add(s);
//      }
//    }
//    return rv;
//  }
//
//  public static List<Student> getEnthusiastic(List<Student> ls, int threshold) {
//    List<Student> rv = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getCourses().size() > threshold) {
//        rv.add(s);
//      }
//    }
//    return rv;
//  }

//  static Predicate<Student> ps;
  public static List<Student> getByPredicate(
      // store the behavior and just "use it"
      // Strategy pattern
//      List<Student> ls) {
      // "Command" pattern
      List<Student> ls, Predicate<Student> ps) {
    List<Student> rv = new ArrayList<>();
    for (Student s : ls) {
      if (ps.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }

  // Pattern is called "Functor"
  public static <E, F> List<F> map(List<E> data, Function<E, F> op) {
    List<F> rv = new ArrayList<>();
    for (E e : data) {
      rv.add(op.apply(e));
    }
    return rv;
  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 3.2, "Math", "Physics"),
        new Student("Jim", 2.2, "Journalism"),
        new Student("Shiela", 3.9,
            "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    // print all students
    showAll(roster);

    // print smart students
//    showAll(getSmart(roster));
//    showAll(getSmart(roster, 3.8));
//    showAll(getEnthusiastic(roster, 3));

    showAll(getByPredicate(roster, s -> s.getGpa() > 3.0));
    showAll(getByPredicate(roster, s -> s.getCourses().size() < 3));
  }
}
