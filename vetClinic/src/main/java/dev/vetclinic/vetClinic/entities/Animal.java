package dev.vetclinic.vetClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;

    @Column( name = "animal_name")
    private String name;

    @Column( name = "animal_species" )
    private String species;

    @Column(length = 100, name = "animal_breed")
    private String breed;

    @Column(length = 100, name = "animal_gender")
    private String gender;

    @Column(length = 100, name = "animal_color")
    private String color;

    @Column(name = "animal_bdate")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

   // Relations of tables

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Appointment> appointmentList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccineList;



}
