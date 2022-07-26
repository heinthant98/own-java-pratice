import java.time.LocalDate;
import java.util.Objects;

public class Course {

	private String name;
	private int duration;
	private int fees;
	private LocalDate startDate;

	public Course(String name, int duration, int fees, LocalDate startDate) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, fees, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return duration == other.duration && fees == other.fees && Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate);
	}

}
