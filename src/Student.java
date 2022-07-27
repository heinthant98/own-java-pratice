import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {

	private String name;
	private List<Course> courses;
	private int age;
	private List<String> basicKnowledges;

	public Student(String name, List<Course> courses, int age, List<String> basicKnowledge) {
		super();
		this.name = name;
		this.courses = courses;
		this.age = age;
		this.basicKnowledges = basicKnowledge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getBasicKnowledges() {
		return basicKnowledges;
	}

	public void setBasicKnowledges(List<String> basicKnowledges) {
		this.basicKnowledges = basicKnowledges;
	}
	
	public String getCoursesName(List<Course> courses) {
		return courses.stream().map(Course::getName).collect(Collectors.joining("、"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, courses, basicKnowledges, name);
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
		return age == other.age && Objects.equals(courses, other.courses) && Objects.equals(basicKnowledges, other.basicKnowledges)
				&& Objects.equals(name, other.name);
	}

}
