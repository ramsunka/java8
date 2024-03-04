package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

class Student {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String departmantName;
	private int joinedYear;
	private String city;
	private int rank;

	public Student(int id, String firstName, String lastName, int age, String gender, String departmantName,
			int joinedYear, String city, int rank) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.departmantName = departmantName;
		this.joinedYear = joinedYear;
		this.city = city;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartmantName() {
		return departmantName;
	}

	public void setDepartmantName(String departmantName) {
		this.departmantName = departmantName;
	}

	public int getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(int joinedYear) {
		this.joinedYear = joinedYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

public class StudentOps {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Delhi", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

		// Find list of student whose first name starts with alphabet A
		List<Student> lststartwithA = list.stream().filter(nm -> nm.getFirstName().startsWith("A"))
				.collect(Collectors.toList());
		System.out.println("------------------------------------");
		System.out.println("List of students whose name starts with letter A : ");
		System.out.println("------------------------------------");
		lststartwithA.stream().forEach(dt -> System.out.println(dt.getFirstName()));
		System.out.println("------------------------------------");
		// Group the students by department names
		Map<String, List<Student>> groupByDptName = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName));

		System.out.println("Students grouped by the department names : ");
		System.out.println("------------------------------------");
		for (Map.Entry<String, List<Student>> entry : groupByDptName.entrySet()) {
			System.out.println("Department Name is ->" + entry.getKey());
			entry.getValue().forEach(en -> System.out.println("FirstName is - " + en.getFirstName()));
		}
		System.out.println("------------------------------------");
		System.out.println("Find the total count of student using stream");
		System.out.println("------------------------------------");
		long countofStudents = list.stream().count();
		System.out.println("Total count of students is " + countofStudents);
		System.out.println("------------------------------------");
		System.out.println("Find the max age of student");
		System.out.println("------------------------------------");
		OptionalInt maxAge = list.stream().mapToInt(dt -> dt.getAge()).max();
		System.out.println("Max age of student - " + maxAge.getAsInt());
		System.out.println("------------------------------------");
		System.out.println("Find All department Names");
		System.out.println("------------------------------------");
		List<String> lstDep = list.stream().map(ld -> ld.getDepartmantName()).distinct().collect(Collectors.toList());
		System.out.println("All distinct department names : " + lstDep);
		System.out.println("------------------------------------");
		System.out.println("Find the count of student in each department");
		System.out.println("------------------------------------");
		Map<String, Long> countStudentInEachdept = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		System.out.println("Student count in each department : " + countStudentInEachdept);
		System.out.println("------------------------------------");
		System.out.println("Find the list of students whose age is less than 30");
		System.out.println("------------------------------------");
		List<Student> lstStudentAgelsth30 = list.stream().filter(lt3 -> lt3.getAge() < 30).collect(Collectors.toList());
		// System.out.println("List of Students whose age us less than 30 ");
		lstStudentAgelsth30.stream().forEach(lt3s -> {
			System.out.println(lt3s.getFirstName());
		});
		System.out.println("------------------------------------");
		System.out.println("Find the average age of male and female students");
		System.out.println("------------------------------------");
		Map<String, Double> avgAgeGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println(avgAgeGender);
		System.out.println("------------------------------------");
		System.out.println("Find the department who is having maximum number of students");
		System.out.println("------------------------------------");
		Entry<String, Long> entry = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);
		System.out.println("------------------------------------");
		System.out.println("Find the Students who stays in Delhi and sort them by their names");
		System.out.println("------------------------------------");
		List<Student> lstDelhiSt=list.stream().filter(stD->stD.getCity().equals("Delhi"))
				.sorted((st1,st2)->st1.getFirstName().compareTo(st2.getFirstName()))
				.collect(Collectors.toList());
		lstDelhiSt.forEach(ldt->{System.out.println(ldt.getFirstName());});
		System.out.println("------------------------------------");
		System.out.println("Find the average rank in all departments");
		System.out.println("------------------------------------");
		Map<String,Double> avgDep =list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getRank)));
		System.out.println(avgDep);
		System.out.println("------------------------------------");
		System.out.println("Find the highest rank in each department");
		System.out.println("------------------------------------");
		Map<String,Optional<Student>> hrDep=list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,
				Collectors.maxBy((hr1,hr2)->(hr1.getRank()<hr2.getRank())?-1:(hr1.getRank()>hr2.getRank())?1:0)));
		for (Map.Entry<String, Optional<Student>> hrentry : hrDep.entrySet()) {
			System.out.println("Department Name is ->" + hrentry.getKey());
			hrentry.getValue().stream().forEach(enh -> System.out.println("Rank is - " + enh.getRank()));
		}
		System.out.println("------------------------------------");
		System.out.println("Find the list of students and sort them by their rank");
		System.out.println("------------------------------------");
		List<Student> sortRank=list.stream().sorted((sr1,sr2)->(sr1.getRank()<sr2.getRank())?-1:(sr1.getRank()>sr2.getRank())?1:0)
				.collect(Collectors.toList());
		sortRank.forEach(sr->{System.out.println(sr.getFirstName());});
		System.out.println("------------------------------------");
		System.out.println("Find the student who has second rank");
		System.out.println("------------------------------------");
		Student std=list.stream().sorted((sr1,sr2)->(sr1.getRank()<sr2.getRank())?-1:(sr1.getRank()>sr2.getRank())?1:0)
				.skip(1).findFirst().get();
		System.out.println(std.getFirstName());
		
		
	}

}
