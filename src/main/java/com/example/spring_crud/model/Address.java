package com.example.spring_crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //User table join column many_to_one
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private User userAccount;
    @Transient
    private Long acctId;

    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String country;
}
