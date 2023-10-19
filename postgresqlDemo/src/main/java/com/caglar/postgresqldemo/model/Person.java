package com.caglar.postgresqldemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "person")
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "p_address")
    private List<Address> addresses;
}
