import java.util.Objects;

public class Student {

	private String name;
	private Course course;
	private int age;
	private String foundation;

	public Student(String name, Course course, int age, String foundation) {
		super();
		this.name = name;
		this.course = course;
		this.age = age;
		this.foundation = foundation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFoundation() {
		return foundation;
	}

	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, course, foundation, name);
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
		return age == other.age && Objects.equals(course, other.course) && Objects.equals(foundation, other.foundation)
				&& Objects.equals(name, other.name);
	}

}
