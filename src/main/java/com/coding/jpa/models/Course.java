package com.coding.jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder 
@Entity 
public class Course extends BaseEntity{
    

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
    

    //-> ONE TO MANY - un corso ha piu sessioni
    @OneToMany(mappedBy = "course") //->indichiamo come si chiama la proprietà in Section a cui fa riferimento
    private List<Section> sections;



}
