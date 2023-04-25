package ex3;

public class Student extends Human{
    private int facultyNumber;

    public Student(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Student(String firstname, String lastname, int facultyNumber) {
        super(firstname, lastname);
        this.facultyNumber = facultyNumber;
    }


    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) throws IllegalArgumentException {
        String newFacultyNumber = String.valueOf(facultyNumber);
//        if (!newFacultyNumber.matches("[5-9]"))
//            System.out.println("Invalid faculty number!");
//        this.facultyNumber = Integer.parseInt(newFacultyNumber);
        if (newFacultyNumber.contains("2") | newFacultyNumber.contains("3") | newFacultyNumber.contains("4"))
            throw new IllegalArgumentException("Invalid faculty number!");
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Firstname: ").append(this.getFirstname())
                .append(System.lineSeparator())
                .append("Lastname: ").append(this.getLastname())
                .append(System.lineSeparator())
                .append("Faculty number: ").append(this.getFacultyNumber())
                .append(System.lineSeparator());
        return sb.toString();
    }
}

