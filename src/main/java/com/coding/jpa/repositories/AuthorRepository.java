package com.coding.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.jpa.models.Author;

//estendiamo la classe di JPA e indiciamo le specifiche richieste (tipo classe e tipo dell'id della classe)
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    
    //per poter usare questa AuthorRepository dobbiamo creare un controller
    


}
