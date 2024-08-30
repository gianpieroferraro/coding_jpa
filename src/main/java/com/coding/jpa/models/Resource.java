package com.coding.jpa.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
/**** EREDITARIETà A TABELLA SINGOLA ****/
//-@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //strategia con tabella singola nel database che prende anche le classi figlie,
//usato con Hibernate o spring data jpa per definire l'ereditarietà nel database -> tutte le sottoclassi sono mappate nella stessa tabella
//-@DiscriminatorColumn(name = "resource_type") //(di default è Dtype) -> è utilizzata per specificare quale colonna 
//della tabella deve essere usata per indicare il tipo di sottoclasse. 
/*@DiscriminatorColumn(name = "resource_type"): indica che nella tabella associata alla classe Resource sarà presente una colonna 
chiamata resource_type. Questa colonna conterrà valori che permettono di distinguere a quale sottoclasse (Book, Video, ecc.) 
appartiene una riga specifica.
@DiscriminatorValue("V") e @DiscriminatorValue("F")ecc nelle classi figlie: specificano quali valori saranno inseriti nella colonna 
resource_type per identificare rispettivamente le sottoclassi Video, File e Text*/

/**** EREDITARIETà A TABELLA UNITA(joined table)****/
//@Inheritance(strategy = InheritanceType.JOINED) //mappa ogni classe della gerarchia a una tabella separata e usa join per 
//recuperare i dati completi. */

/**** STRATEGIA EREDITARIETà A TABELLA PER CLASSE(joined table)****/
/*ogni classe figlia avrà tutte le proprietà, anche quelle ereditate, nella sua tabella -> ci sarà una tabella per ogni sottoclasse */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource { //questa è la classe genitore di video file e text
    

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private int size;
    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

}
