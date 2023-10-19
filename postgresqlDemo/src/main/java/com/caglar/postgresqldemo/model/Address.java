package com.caglar.postgresqldemo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
@Table(name = "person_address")
public class Address {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "p_address")
    private String address;

    @Enumerated
    private AddressType addressType;

    private boolean activity;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "p_address_id")
    private Person person;

    public enum AddressType{
        HOME_ADDRESS,
        BUSINESS_ADDRESS,
        OTHER
    }
}
