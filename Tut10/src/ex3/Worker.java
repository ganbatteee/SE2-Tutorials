package ex3;

public class Worker extends Human {
    private double weekSalary;
    private double workingHours;

    public Worker(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Worker(String firstname, String lastname, double weekSalary, double workingHours) {
        super(firstname, lastname);
        this.weekSalary = weekSalary;
        this.workingHours = workingHours;
    }

    @Override
    public void setLastname(String lastname) throws IllegalArgumentException {
        super.setLastname(lastname);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) throws IllegalArgumentException {
        if (weekSalary < 9)
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        this.weekSalary = weekSalary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) throws IllegalArgumentException {
        if (0 < workingHours && workingHours <= 12)
            this.workingHours = workingHours;
        throw new IllegalArgumentException("Expected value mismatch!Argument workHoursPerDay");
    }

    public double salaryPerHour() {
        return getWeekSalary() / 7 / getWorkingHours();
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + "\n" + String.format("Firstname: %s\nLastname: %s\nWeek salary: %.2f\nWorking hours: %.2f\nSalary per hour: %.2f", getFirstname(), getLastname(), getWeekSalary(), getWorkingHours(), salaryPerHour());
    }
}
