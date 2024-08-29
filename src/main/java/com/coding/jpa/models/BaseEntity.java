package com.coding.jpa.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder //-> per una classe "padre" non si usa @Builder ma @SuperBuilder anche nelle classi che estendono questa
@MappedSuperclass // indica che è una superclass e che ogni Entity che estenderà questa classe estenderà tutto
public class BaseEntity {
    
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedAt;

    //chi l'ha creato
    private String createdBy;
    
    private String lastModifiedBy;


}
