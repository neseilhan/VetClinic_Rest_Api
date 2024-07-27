package dev.vetclinic.vetClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "available_date")
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "available_date_id")
    private Long id;

    @Column(name = "available_date")
    private LocalDate availableDate;

    // Relations of tables
    @ManyToOne
    @JoinColumn(name = "date_doctor_id")
    private Doctor doctor;
}
