import java.time.LocalDate;
import java.util.Objects;

public class Course {

	private String name;
	private int months;
	private int fees;
	private LocalDate startDate;

	public Course(String name, int months, int fees, LocalDate startDate) {
		super();
		this.name = name;
		this.months = months;
		this.fees = fees;
		this.startDate = startDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
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
		return Objects.hash(months, fees, name, startDate);
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
		return months == other.months && fees == other.fees && Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate);
	}

}
