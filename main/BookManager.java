package main;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {

        for (Book b : books) {
            if (b.getId() == book.getId()) {
                throw new IllegalArgumentException("해당 ID(" + book.getId() + ") 는 이미 존재합니다.\n");
            }

        }
        books.add(book);
        System.out.println(book.toString() + "도서가 추가되었습니다.\n");
    }

}
