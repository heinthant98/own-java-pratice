import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {

	private String name;
	private List<Course> course;
	private int age;
	private List<String> basicKnowledge;

	public Student(String name, List<Course> course, int age, List<String> basicKnowledge) {
		super();
		this.name = name;
		this.course = course;
		this.age = age;
		this.basicKnowledge = basicKnowledge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getBasicKnowledge() {
		return basicKnowledge;
	}

	public void setBasicKnowledge(List<String> basicKnowledge) {
		this.basicKnowledge = basicKnowledge;
	}
	
	public String getCourseName(List<Course> course) {
		return course.stream().map(Course::getName).collect(Collectors.joining("、"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, course, basicKnowledge, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(course, other.course) && Objects.equals(basicKnowledge, other.basicKnowledge)
				&& Objects.equals(name, other.name);
	}

}
