package com.coding.jpa.models;


import org.hibernate.annotations.Polymorphism;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
/**** EREDITARIETà A TABELLA SINGOLA ****/
//@DiscriminatorValue("V")

/**** EREDITARIETà A TABELLA UNITA(joined table)****/
//@PrimaryKeyJoinColumn(name = "video_id ") //rinomina la chiave primaria per la join altrimenti usa quella ereditata dalla classe padre

/**** STRATEGIA EREDITARIETà A TABELLA PER CLASSE(joined table) non ha bisogno di nulla****/

public class Video extends Resource{

    private int length;
    
}
