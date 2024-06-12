package main;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;

    Book(int id, String title, String author, int year){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear(){
        return year;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id: '" + id + "', " +
                "제목: '" + title + "', " +
                "저자: '" + author + "', " +
                "출판년도: " + year +
                '}';
    }
}
