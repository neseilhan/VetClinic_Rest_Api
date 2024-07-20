package dev.vetclinic.vetClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "appointment_id")
    private Long id;

    @Column( name = "appointment_date")
    private LocalDateTime appointmentDate;

    // Relations of tables
    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id")
    private Animal animal;


}

