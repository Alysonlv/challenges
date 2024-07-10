package corp.alv.challenges.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Circle {

    public static void main(String[] args) {
        String[][] operations = new String[][]{
                {REGISTER_COURSE, "c001", "Computer Science", "8"},
                {REGISTER_COURSE, "c002", "Medicine", "10"},
                {REGISTER_COURSE, "c003", "Computer Science", "4"},
                {REGISTER_COURSE, "c001", "Computer Science", "4"},

                {REGISTER_COURSE, "c004", "Blockchain", "5"},
                {REGISTER_COURSE, "c005", "Nurse", "3"},
                {REGISTER_COURSE, "c006", "Java", "5"},
                {REGISTER_COURSE, "c007", "Javascript", "3"},
                {REGISTER_COURSE, "c008", "React", "4"},
                {REGISTER_COURSE, "c009", "Spring Framework", "7"},
                {REGISTER_COURSE, "c010", "Spring Boot", "3"},
                {REGISTER_COURSE, "c011", "Scrum", "3"},
                {REGISTER_COURSE, "c012", "Docker", "5"},

                {REGISTER_COURSE, "c013", "Biology", "5"},
                {REGISTER_COURSE, "c014", "Drugs", "5"},
                {REGISTER_COURSE, "c015", "History", "1"},

                {STUDENT_COURSE, "std001", "c001"},
                {STUDENT_COURSE, "std001", "c004"},
                {STUDENT_COURSE, "std001", "c005"},
                {STUDENT_COURSE, "std001", "c006"},
                {STUDENT_COURSE, "std001", "c006"},
                {STUDENT_COURSE, "std001", "c007"},
                {STUDENT_COURSE, "std001", "c008"},

                {STUDENT_COURSE, "std002", "c006"},
                {STUDENT_COURSE, "std003", "c007"},
                {GET_PAIR}
        };

        Circle circle = new Circle();
        String[] result = circle.solution(operations);

        for (int i = 0; i < operations.length; i++) {
            System.out.println("Command: " + operations[i][0] + " :: Result = " + result[i]);
        }
    }

    public static final String REGISTER_COURSE = "REGISTER_COURSE";
    public static final String STUDENT_COURSE = "STUDENT_COURSE";
    public static final String GET_PAIR = "GET_PAIR";

    public String[] solution(String[][] queries) {
        String[] result = new String[queries.length];
        Map<String, Course> courses = new HashMap<>();
        Map<String, Student> students = new HashMap<>();
        Map<Course, Set<Student>> registry = new HashMap<>();


        int maxCredits = 24;

        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String command = query[0];
            switch (command) {
                case REGISTER_COURSE: {
                    String name = query[2];
                    String id = query[1];

                    // If course is found on map, operations fails
                    if (courseAlreadyRegistred(courses, name, id)) {
                        result[i] = "" + false;
                        break;
                    }

                    Course course = new Course(id, name, query[3]);
                    courses.put(course.id, course);
                    result[i] = "" + true;
                    registry.put(course, new HashSet<>());

                    break;
                }
                case STUDENT_COURSE: {
                    String studentId = query[1];
                    String courseId = query[2];
                    Course course = courses.get(courseId);
                    // If the course is not registred yet, operation fails
                    if (course == null) {
                        result[i] = "" + false;
                        break;
                    }

                    Student student = students.get(studentId);
                    // If it is a new student add it to the student map
                    if (student == null) {
                        students.put(studentId, new Student(studentId));
                        student = students.get(studentId);
                    }

                    // If student is already registred on that course, operation fails
                    if (registry.get(course).contains(student)) {
                        result[i] = "" + false;
                        break;
                    }

                    // If the new course credits add more than 24, operation fails
                    if (student.credits + course.credits > maxCredits) {
                        result[i] = "" + false;
                        break;
                    }

                    // If we are here, student can be registred
                    student.credits += course.credits;
                    registry.get(course).add(student);
                    result[i] = "" + true;

                    break;
                }
                case GET_PAIR: {
                    Map<Student, Set<Student>> studentPairs = new HashMap<>();

                    // Iterate through each entry in the registry
                    for (Map.Entry<Course, Set<Student>> entry : registry.entrySet()) {
                        List<Student> stds = new ArrayList<>(entry.getValue());

                        if (stds.size() > 1) {
                            for (int a = 0; a < students.size(); a++) {
                                for (int j = a + 1; j < students.size(); j++) {
                                    if (j >= stds.size()) {
                                        break;
                                    }
                                    Student student1 = stds.get(a);
                                    Student student2 = stds.get(j);

                                    // Add the pair in both directions
                                    studentPairs.computeIfAbsent(student1, k -> new HashSet<>()).add(student2);
                                    studentPairs.computeIfAbsent(student2, k -> new HashSet<>()).add(student1);
                                }
                            }
                        }
                    }

                    // Create the result set based on the pairs map
                    Set<List<Student>> pairList = new HashSet<>();
                    Set<String> seen = new HashSet<>();

                    for (Student student : studentPairs.keySet()) {
                        for (Student pairedStudent : studentPairs.get(student)) {
                            String pair1 = student.id + "," + pairedStudent.id;
                            String pair2 = pairedStudent.id + "," + student.id;

                            if (!seen.contains(pair1) && !seen.contains(pair2)) {
                                pairList.add(Arrays.asList(student, pairedStudent));
                                seen.add(pair1);
                            }
                        }
                    }

                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    Iterator<List<Student>> iterator = pairList.iterator();
                    while (iterator.hasNext()) {
                        List<Student> pair = iterator.next();
                        sb.append("[");
                        sb.append(pair.get(0).id);
                        sb.append(", ");
                        sb.append(pair.get(1).id);
                        sb.append("]");
                        if (iterator.hasNext()) {
                            sb.append(", ");
                        }
                    }
                    sb.append("]");

                    result[i] = sb.toString();

                    break;
                }
            }
        }

        return result;
    }

    private boolean courseAlreadyRegistred(Map<String, Course> courses, String name, String id) {
        return courses.values()
                .stream()
                .anyMatch(registredCourse -> registredCourse.name.equals(name) || registredCourse.id.equals(id));
    }

    class Course {
        String id;
        String name;
        int credits;

        public Course(String id, String name, String c) {
            this.id = id;
            this.name = name;
            this.credits = Integer.valueOf(c);
        }

        @Override
        public boolean equals(Object o) {
            Course c = (Course) o;
            return this.id.equals(c.id) || this.name.equals(c.name);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    class Student {
        String id;
        int credits;

        public Student(String id) {
            this.id = id;
            this.credits = 0;
        }

        @Override
        public boolean equals(Object o) {
            Student s = (Student) o;
            return this.id.equals(s.id);
        }
    }
}
