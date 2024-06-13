package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    // 매개변수로 book에 대한 정보를 받는다.
    public void addBook(Book book) {

        // 순차적으로 books 배열에 중복되는 id가 있는지 확인하고 있다면 예외를 던진다.
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                throw new IllegalArgumentException("해당 ID(" + book.getId() + ") 는 이미 존재합니다.");
            }
        }
        books.add(book);
        // 추후 binarySearch를 위해 정렬을 진행한다.
        Collections.sort(books);
        System.out.println(book.toString() + "도서가 추가되었습니다.");
    }

    // book의 id를 매개변수로 전달받아 순차탐색을 진행한다. 검색 된 도서가 없다면 예외를 던진다.
    public void searchBook(int id) {

        for (Book b : books) {
            if (b.getId() == id) {
                System.out.println("검색결과: ");
                System.out.println(b.toString());
                return;
            }
        }
        throw new IllegalArgumentException("검색된 도서가 없습니다.");
    }

    // book의 id를 매개변수로 전달받아 이진탐색을 진행한다. 검색 된 도서가 없다면 예외를 던진다.
    public void bsSearchBook(int id) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = books.get(mid);

            if (midBook.getId() == id) {
                System.out.println("검색결과: ");
                System.out.println(midBook.toString());
                return;
            } else if (midBook.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new IllegalArgumentException("검색된 도서가 없습니다.");
    }

    // book을 매개변수로 전달받아 해당 book을 books 배열에서 삭제한다. 해당 book을 찾을 수 없다면 예외를 던진다.
    public void removeBook(Book book){

        boolean removed = books.removeIf(b -> b.getId() == book.getId());
        if (removed) {
            System.out.println(book.toString() + "도서를 삭제하였습니다.");
        } else {
            throw new IllegalArgumentException("해당 ID("+ book.getId() + ")의 도서를 찾을 수 없습니다.");
        }
    }
}
