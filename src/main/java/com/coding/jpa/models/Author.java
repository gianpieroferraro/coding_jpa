package com.coding.jpa.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


//con le annotation lombok possiamo dire di generare i getters e setteres
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// o usare l'annotation di lombol @Data che prende tutti insieme e Getter, Setter, RequiredArgsConstructor
//ToString e EqualsAndHashCode

@EqualsAndHashCode(callSuper = true) //-> usare quando c'è l'ereditarietà
@Data
@NoArgsConstructor
@AllArgsConstructor //construttore con tutti gli argomenti
@SuperBuilder    //ci aiuta a creare un oggetto builder
@Entity //-> specifica a spring che questa è una Entity
// @Table(name = "AUTHOR_TBL") //-> possiamo definire un nome per la tabella del db, in quale schema deve essere ecc
public class Author extends BaseEntity{
    
    /* @Id Specifica l'identificatore dell'entity nel database - sarà usata come primary key nel db.
     * Usiamo come tipo Integer perché di default è null, mentre int di default è 0 e non andrebbe bene.
     * @GeneratedValue -> richiesto per le primary keys semplici - lasciamo decidere ad hibernite decidere
     * - AUTO -> hibernate decide qual'è la giusta strategia per generare gli id in sequenza (in mysql crea 
     *   una nuova tabella _seq)
     * - Specificando le strategie creaimo una sequenza che verrà poi gestita da hibernate V
    */
    //@Id
    /*@GeneratedValue (
        strategy = GenerationType.SEQUENCE,
        generator = "author_sequence"
    ) 
    @SequenceGenerator(
        name = "author_sequence",
        sequenceName = "author_sequence",
        allocationSize = 1
    )*/
    //private Integer id; -->SPOSTATO IN BASEENTITY.JAVA

    /*specifica come deve essere la voce nel db della colonna nel db, altrimente usa il nome della prorieta 
    con snake_case; possiamo indicare altre specifiche come unique, se può essere null ecc*/
    @Column(
        name = "f_name",
        length = 35
    )
    private String firstName;

    private String lastName;

    @Column(
        unique = true,
        nullable = false
    )
    private String email;

    private int age;

    // @Column(updatable = false, nullable = false) // la rendiamo inseribile ma non aggiornabile, è solo per la creazione(esempio)
    // private LocalDateTime createdAt;
    
    // @Column(insertable = false)
    // private LocalDateTime lastModified;


    /* -- creiamo una lista relativa alla relazione many to many con corsi;
     * In jpa, le relazioni manytomany, una delle entity è considerata l'owner della relazione ed è repsponsabile di avere la 
     * foreignKey per la join, mentre l'altra non ha una foreignKey. In questo caso vogliamo che la owner della relazione sia 
     * la classe Course, quindi mettiamo l'annotation mappedby qui, mentre in Course mettiamo l'annotation  @JoinTable 
     */
    @ManyToMany(mappedBy = "authors") //-> author fa rifermimento al nome della lista di autori in Course.java
    private List<Course> courses;


}
