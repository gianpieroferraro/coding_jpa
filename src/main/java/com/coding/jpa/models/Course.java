package com.coding.jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Entity 
public class Course {
    
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    //abbiamo deciso che l'owner della relazione con autori è questa classe, quindi dobbiamo specificarlo in Author.java con MappedBy
    @ManyToMany
    @JoinTable( //questo crea la Join con autori
        name = "author_courses", //-> il nome della join table
        joinColumns = {
            @JoinColumn(name = "course_id")//-> questa è responsabile di quella che ha le informazioni della primaryKey della relazione
        },
        inverseJoinColumns = {
            @JoinColumn(name="author_id")
        }
    )
    private List<Author> authors;


}
