package tutorial.tut7.todo;

public class BagTest {
    public static void main(String[] args) {
        // STUDENT
        System.out.println("---------------------STUDENT TEST---------------------");
        BagInterface<String> students = new ArrayBag<>();
        System.out.println("Initialize size: " + students.getCurrentSize());
        System.out.println("Is empty: " + students.isEmpty());
        System.out.println("Contain \"Phuong\": " + students.contains("Phuong"));
        System.out.println("Frequency of \"Nam\": " + students.getFrequencyOf("Nam"));
        System.out.println("-----> ADD 33 STUDENTS");
        students.add("Phuong");
        students.add("Nga");
        students.add("Nam");
        for (int i = 1; i <= 30; i++) {
            students.add("Nam");
        }
        System.out.println("Current size: " + students.getCurrentSize());
        System.out.println("Is empty: " + students.isEmpty());
        System.out.println("Contain \"Phuong\": " + students.contains("Phuong"));
        System.out.println("Frequency of \"Nam\": " + students.getFrequencyOf("Nam"));
        System.out.println("-----> REMOVE 1 STUDENT");
        students.remove("Nga");
        System.out.println("Current size: " + students.getCurrentSize());
        System.out.println("Is empty: " + students.isEmpty());
        System.out.println("Contain \"Phuong\": " + students.contains("Phuong"));
        System.out.println("Frequency of \"Nam\": " + students.getFrequencyOf("Nam"));
        System.out.println("Frequency of \"Phuong\": " + students.getFrequencyOf("Phuong"));
        System.out.println("-----> REMOVE A LAST STUDENT");
        students.remove();
        System.out.println("Current size: " + students.getCurrentSize());
        students.clear();
        System.out.println("Current size: " + students.getCurrentSize());
        System.out.println("Is empty: " + students.isEmpty());
        System.out.println("Contain \"Phuong\": " + students.contains("Phuong"));
        System.out.println("Frequency of \"Nam\": " + students.getFrequencyOf("Nam"));


        System.out.println("---------------------NUMBER TEST---------------------");
        BagInterface<Integer> numbers = new ArrayBag<>(10);
        System.out.println("Initialize size: " + numbers.getCurrentSize());
        System.out.println("Is empty: " + numbers.isEmpty());
        System.out.println("Contain 1: " + numbers.contains(2));
        System.out.println("Frequency of 2: " + numbers.getFrequencyOf(1));
        System.out.println("-----> ADD 4 NUMBERS");
        numbers.add(Integer.valueOf(1));
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        System.out.println("Current size: " + numbers.getCurrentSize());
        System.out.println("Is empty: " + numbers.isEmpty());
        System.out.println("Contain 2: " + numbers.contains(2));
        System.out.println("Frequency of 1: " + numbers.getFrequencyOf(1));
        System.out.println("-----> REMOVE 2 NUMBERS");
        numbers.remove(1);
        numbers.remove();
        System.out.println("Current size: " + numbers.getCurrentSize());
        System.out.println("Is empty: " + numbers.isEmpty());
        System.out.println("Contain 2: " + numbers.contains(2));
        System.out.println("Frequency of 1: " + numbers.getFrequencyOf(1));
        System.out.println("-----> REMOVE ALL NUMBERS");
        numbers.clear();
        System.out.println("Current size: " + numbers.getCurrentSize());
        System.out.println("Is empty: " + numbers.isEmpty());
        System.out.println("Contain 2: " + numbers.contains(2));
        System.out.println("Frequency of 1: " + numbers.getFrequencyOf(1));
    }
}
