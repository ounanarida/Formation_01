package fr.randstaddigital.BookStore;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.randstaddigital.BookStore.entities.Book;
import fr.randstaddigital.BookStore.repository.BookRepository;
import fr.randstaddigital.BookStore.service.BookService;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveBook(){

        Book book1 = new Book();
        book1.setTitle("book 1 title");

        when(bookRepository.save(any(Book.class))).thenReturn(book1);

        Book bookResponse = bookService.saveBook(book1);

        assertEquals(bookResponse.getTitle(),book1.getTitle());
        
        verify(bookRepository, times(1)).save(any(Book.class));

    }

    @Test
    public void testGetAllBooks(){

        Book book1 = new Book();
        book1.setTitle("book 1 title");

        Book book2 =  new Book();
        book2.setTitle("book 2 title");

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        assertEquals(bookService.getAllBooks().size(), 2);
    }
    
    public void TestDleteBook(){
        Long id = 1L;
        bookService.deleteBook(id);
        verify(bookRepository, times(1)).deleteById(id);
    }

}
