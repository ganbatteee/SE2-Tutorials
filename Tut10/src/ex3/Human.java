package ex3;

public class Human {
    private String firstname;
    private String lastname;

    public Human(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        String firstChar = String.valueOf(lastname.charAt(0)).toUpperCase();
        return firstChar + lastname.substring(1);
    }

    public void setLastname(String lastname) throws IllegalArgumentException {
        if (lastname.length() < 2)
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: firstName");
        this.lastname = lastname;
    }

    public String getFirstname() {
        String firstChar = String.valueOf(firstname.charAt(0)).toUpperCase();
        return firstChar + firstname.substring(1);
    }

    public void setFirstname(String firstname) throws IllegalArgumentException {
        if (firstname.length() < 3)
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Firstname: ").append(this.getFirstname())
                .append(System.lineSeparator())
                .append("Lastname: ").append(this.getLastname())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
