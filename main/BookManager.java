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

    public void searchBook(Book book){

        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("검색결과: \n");
                System.out.println(book.toString() + '\n');
                return;
            }
        }
        System.out.println("검색된 도서가 없습니다.\n");
    }

    public void removeBook(Book book){

        boolean removed = books.removeIf(b -> b.getId() == book.getId());
        if (removed) {
            System.out.println(book.toString() + "도서를 삭제하였습니다.\n");
        } else {
            System.out.println("해당 ID( "+ book.getId() + ")의 도서를 찾을 수 없습니다.\n");
        }
    }
}
