package com.example.spring_crud.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "addresses")
    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
