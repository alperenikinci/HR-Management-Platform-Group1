package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.AdvanceType;
import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
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
public class Advance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ConfirmationStatus confirmationType;
    private PriceType priceType;
    private Long salaryCount;
    private String details;
    private Long createRequestDate;;
    private Long responseDate;
    private AdvanceType advanceType;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeProfile employeeProfile;
}
