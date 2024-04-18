package guru.springframework.spring6webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;
    private String title;
    private String isbn;
    @ManyToMany(mappedBy = "books")
    @JoinTable(name = "author_book",joinColumns = @jakarta.persistence.JoinColumn(name = "book_id"),
    inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
    
    
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
