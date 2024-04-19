package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;

public class BootstrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        
        

         Author rod = new Author("Rod", "Johnson");
         Book noEJB = new Book("J2EE Development without EJB", "3939459459");
         rod.getBooks().add(noEJB);
         noEJB.getAuthors().add(rod);

         authorRepository.save(rod);
         bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
    
}
