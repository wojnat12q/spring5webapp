package guru.springframework.spring5webapp.domain.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repository.AuthorRepository;
import guru.springframework.spring5webapp.domain.repository.BookRepository;
import guru.springframework.spring5webapp.domain.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private  final AuthorRepository authorRepository ;
    private  final BookRepository bookRepository;
    private  final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Warsaw");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: "+publisherRepository.count());


        Author erick = new Author("Erick","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        erick.getBooks().add(ddd);
        ddd.getAuthors().add(erick);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(erick);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Jhonson");
        Book noEJB = new Book("J2EE Development without EJB","123456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());
        System.out.println("Publisher Number of books: "+ publisher.getBooks().size());

    }
}
