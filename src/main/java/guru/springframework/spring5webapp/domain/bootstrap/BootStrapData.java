package guru.springframework.spring5webapp.domain.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.repository.AuthorRepository;
import guru.springframework.spring5webapp.domain.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private  final AuthorRepository authorRepository ;
    private  final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author erick = new Author("Erick","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        erick.getBooks().add(ddd);
        ddd.getAuthors().add(erick);

        authorRepository.save(erick);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Jhonson");
        Book noEJB = new Book("J2EE Development without EJB","123456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());

    }
}
