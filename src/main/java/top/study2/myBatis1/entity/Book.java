package top.study2.myBatis1.entity;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String price;
    private String press;

    public Book() {
    }

    public Book(String title, String author, String price, String press) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.press = press;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
