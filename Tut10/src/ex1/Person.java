package ex1;

//base - parent -super class
public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 1)
            throw new IllegalArgumentException("Age is invalid");
        else
            this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    private boolean validateAge(int age) {
//        return age >= 1;
//    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));
        return sb.toString();
    }
}
