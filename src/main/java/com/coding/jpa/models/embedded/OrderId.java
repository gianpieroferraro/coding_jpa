package com.coding.jpa.models.embedded;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* EMBEDDED ENTITY */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable 
public class OrderId implements Serializable { //--> bisogna implementare Serializable per utilizzare l'annotation @EmbeddedId in Order
    
    private String username;

    private LocalDateTime orderDate;


}
