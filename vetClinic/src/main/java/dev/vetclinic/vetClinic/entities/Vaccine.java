package dev.vetclinic.vetClinic.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "vaccine_id")
    private Long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_code")
    private String code;

    @Column(name = "vaccine_start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "vaccine_end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    // Relations of tables

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;


}
