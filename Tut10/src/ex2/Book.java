package ex2;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.length() < 3)
            throw new IllegalArgumentException("Title not valid!");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException{
        String[] nameAuther = author.split(" ");
        System.out.println(nameAuther[0] + " & " + nameAuther[1]);
        String firstCharacter  = String.valueOf(nameAuther[1].charAt(0));
        if (firstCharacter.matches("[0-9]"))
            throw new IllegalArgumentException( "Author not valid!");
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException{
        if (price <= 0)
            throw new IllegalArgumentException("Price not valid!");
        this.price = price;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
