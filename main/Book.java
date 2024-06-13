package main;

public class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String author;
    private int year;

    public Book(int id, String title, String author, int year){
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

    // 출력을 위한 toString 매서드 구현
    @Override
    public String toString() {
        return "Book{" +
                "id: '" + id + "', " +
                "제목: '" + title + "', " +
                "저자: '" + author + "', " +
                "출판년도: " + year +
                '}';
    }

    // binarySearch를 위한 id값으로 비교하는 compreTo 매서드 구현
    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.id, book.id);
    }
}
