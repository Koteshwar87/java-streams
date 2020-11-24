import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
     
            List<Student> students = Arrays.asList(student1, student2, student3);
            
            Optional<Student> stud = students.stream().filter((student) -> student.getName().equalsIgnoreCase("jayesh")).findFirst();
            System.out.println(stud.get().getName());
            
            System.out.println("--------------------");
            
            stud = students.stream().filter((student) -> student.getAddress().getZipcode().equals("1235")).findFirst();
            System.out.println(stud.get().getName());
            System.out.println("--------------------");
            
            
            List<Student> studList = students
            							.stream()
            							.filter((student) -> student.getMobileNumbers()
            													.stream()
            													.anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
            													.collect(Collectors.toList());
            String names = studList
            				.stream()
            				.map((stud11) -> stud11.getName())
            				.collect(Collectors.joining(",", "[", "]"));
            System.out.println(names);
            System.out.println("--------------------");
            
            
            List<Student> studss = students
            						.stream()
            						.filter((stud22) -> stud22.getMobileNumbers()
            							.stream()
            							.allMatch(numbList -> Objects.equals(numbList.getNumber(), "1233") || Objects.equals(numbList.getNumber(), "1234")))
            							.collect(Collectors.toList());
            names = studss.stream().map((stu) -> stu.getName()).collect(Collectors.joining(",", "[", "]"));
            System.out.println(names);
            System.out.println("--------------------");
            
            
            TempStudent t1 = new TempStudent("Jayesh1",201,new Address("12341"),Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
            TempStudent t2 = new TempStudent("Khyati1",202,new Address("12351"),Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331")));
            List<TempStudent> tmpStudents = Arrays.asList(t1, t2);
            
            List<Student> studList2 = 
            		tmpStudents.stream().map((tmpst) -> new Student(tmpst.name, tmpst.age, tmpst.address, tmpst.mobileNumbers)).collect(Collectors.toList());
            System.out.println(studList2);
            System.out.println("--------------------");
            
            
            List<String> studName2 = students.stream().map(Student::getName).collect(Collectors.toList());
            System.out.println(studName2);
            System.out.println("--------------------");
            
            
            String studList33 = students.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]"));
            System.out.println(studList33);
            System.out.println("--------------------");
            
            
            
            List<String> nams = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
            
            nams.stream().map(String::toUpperCase).forEach(System.out::println);
            
            System.out.println("--------------------");
            
            
            nams.stream().sorted().forEach(System.out::println);
            System.out.println("--------------------");
            
            
            Stream<Student> ss = students.stream().filter((ss2) -> ss2.getName().startsWith("J"));
            ss = ss.sorted(Comparator.comparing(Student::getName));
            ss.forEach(System.out::println);
	}

}
