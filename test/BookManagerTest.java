package test;

import main.Book;
import main.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        book1 = new Book(1, "소프트웨어 공학", "Author1", 2024);
        book2 = new Book(2, "데이터베이스", "Author2", 2023);
        book3 = new Book(3, "운영체제", "Author3", 2022);
    }

    @Test
    public void testAddBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        // 책 3개를 추가했으므로 books의 크기는 3이어야한다.
        assertEquals(3, bookManager.getBooks().size());
        // book1을 다시 추가하려 하면 예외가 발생해야 한다.
        assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(book1));
    }

    @Test
    public void testSearchBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);

        // book1에 해당하는 id 1을 검색하면 예외가 발생하지 않아야한다.
        assertDoesNotThrow(() -> bookManager.searchBook(1));
        // 추가하지않은 책에대해서는 예외가 발생해야 한다.
        assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(3));
    }

    // 기본 검색 테스트와 같은 로직이다.
    @Test
    public void testBsSearchBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        assertDoesNotThrow(() -> bookManager.bsSearchBook(1));
        assertThrows(IllegalArgumentException.class, () -> bookManager.bsSearchBook(4));
    }

    @Test
    public void testRemoveBook() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);

        // 정상 삭제가 되면 예외가 발생하지 않아야한다.
        assertDoesNotThrow(() -> bookManager.removeBook(book1));
        // 정상 삭제 되었을 시 books의 크기는 1이 준다.
        assertEquals(1, bookManager.getBooks().size());
        // 없는 book을 삭제 하려고 하면 예외가 발생해야 한다.
        assertThrows(IllegalArgumentException.class, () -> bookManager.removeBook(book3));
    }
}