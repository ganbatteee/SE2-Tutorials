package ex1;

public class Child extends Person{
    public Child(String name, int age, String address) {
        super(name, age, address);
    }

    public Child(String name, int age) {
        super(name, age);
    }
    public void displayChild() {
        System.out.println("Name: " + getName());;
        System.out.println("Age: " + getAge());
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        super.setAge(age);
    }

}
