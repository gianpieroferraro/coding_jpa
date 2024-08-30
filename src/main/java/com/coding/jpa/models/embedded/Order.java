package com.coding.jpa.models.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_order") //-> rinominiamo la tabella altrimenti da un errore 
public class Order {

    //come id vogliamo usare la classe OrderId.java e non un id come solito-> QUINDI le 2 proprietà di OrderId.java saranno le chiavi primarie 
    @EmbeddedId // -> specifica che si tratta dell'id embeddato
    private OrderId id;

    /* informazione embendata, in questa classe saranno associati anche gli attributi della classe Address.java*/
    @Embedded 
    private Address address;

    private String orderInfo;

    private String anotherField; 
    
}
