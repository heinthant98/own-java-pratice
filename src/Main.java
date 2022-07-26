import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	private static List<Student> students = createStudent();

	public static void main(String[] args) {
		Set<Course> courses = students.stream().map(Student::getCourse).collect(Collectors.toSet());

		System.out.println("===すべての学生を表示する===");
		students.forEach(s -> System.out.println("生徒の名前： %s、 %dヶ月間の%sコースを取っています。".formatted(s.getName(),
				s.getCourse().getDuration(), s.getCourse().getName())));

		System.out.println("===すべてのコースを表示する===");
		courses.forEach(c -> System.out.println("コースの名前 : %s, 期間 : %dヶ月間。".formatted(c.getName(), c.getDuration())));

		System.out.println("===料金250000以下のコースを表示する===");
		courses.stream().filter(c -> c.getFees() <= 250000)
				.forEach(c -> System.out.println("%s　コースの料金は %dです。".formatted(c.getName(), c.getFees())));

		System.out.println("===コースの開始日と終了日を表示する===");
		courses.forEach(c -> System.out.println("%sコースの開始日は　%sで、終了日は %sです。".formatted(c.getName(),
				c.getStartDate(), calculateMonths(c.getStartDate(), c.getDuration()))));

		System.out.println("===Spring Frameworkコースを取っている生徒を表示する===");
		students.stream().filter(s -> s.getCourse().getName().equals("Spring Framework"))
				.forEach(s -> System.out.println("生徒の名前：　%s、年齢： %d".formatted(s.getName(), s.getAge())));

		System.out.println("===生徒の基礎を表示する===");
		students.forEach(s -> System.out.println("%sが　%sを勉強したことあります。".formatted(s.getName(), s.getFoundation())));

		System.out.println("===HTMLを勉強した生徒を表示する。===");
		students.stream().filter(s -> s.getFoundation().contains("HTML"))
				.forEach(s -> System.out.println("%s がHTMLを勉強したことあります。".formatted(s.getName())));

		System.out.println("===生徒全員が30歳未満かチェックして表示する。===");
		checkStudentsAreUnder30(students.stream().allMatch(s -> s.getAge() < 30));

		System.out.println("===Hein Thantという名前の生徒がいるかチェックする。===");
		checkStudentAttendingCourse(
				students.stream().filter(s -> s.getName().equalsIgnoreCase("hein thant")).findAny().orElse(null));

		System.out.println("===Johnという名前の生徒がいるかチェックする。===");
		checkStudentAttendingCourse(
				students.stream().filter(s -> s.getName().equalsIgnoreCase("Thant")).findAny().orElse(null));
	}

	private static void checkStudentAttendingCourse(Student student) {
		if (null != student) {
			System.out.println("%s　は %s コースを取っています。".formatted(student.getName(), student.getCourse().getName()));
		} else {
			System.out.println("その名前で授業を取っている生徒はいません。");
		}
	}

	private static void checkStudentsAreUnder30(boolean allMatch) {
		if (allMatch) {
			students.stream().forEach(s -> System.out.println("生徒の名前： %s".formatted(s.getName())));
		} else {
			System.out.println("３０歳以上の生徒がいます！");
		}
	}

	private static LocalDate calculateMonths(LocalDate startDate, int duration) {
		return startDate.plusMonths(duration);
	}

	private static List<Student> createStudent() {
		Course c1 = new Course("Java", 4, 200000, LocalDate.of(2022, 7, 3));
		Course c2 = new Course("Spring Framework", 6, 250000, LocalDate.of(2022, 10, 15));
		Course c3 = new Course("Node Js", 5, 300000, LocalDate.of(2023, 1, 15));

		List<Student> studentList = List.of(
				new Student("Hein Thant", c1, 24, "HTML, CSS"),
				new Student("Thidar", c3, 30, "CSS"), 
				new Student("Kyi Phyar", c1, 26, "CSS, Database"),
				new Student("Zwe", c2, 20, "HTML, CSS, Database"));

		return studentList;
	}

}