package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import com.bilgeadam.group1.repository.enums.ExpenditureType;
import com.bilgeadam.group1.repository.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ExpenditureType expenditureType;
    private int price;
    private PriceType priceType;
    private String fileUrl;
    private ConfirmationStatus confirmationType;
    private Long createRequestDate;
    private Long responseDate;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeProfile employeeProfile;


}
