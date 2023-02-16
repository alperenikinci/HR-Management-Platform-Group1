package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.AdvanceType;
import com.bilgeadam.group1.repository.enums.ConfirmationType;
import com.bilgeadam.group1.repository.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Advance {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private ConfirmationType confirmationType;
    private PriceType priceType;
    private String details;
    private AdvanceType advanceType;
}
