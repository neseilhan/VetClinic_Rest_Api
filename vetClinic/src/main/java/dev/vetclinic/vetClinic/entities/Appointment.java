package dev.vetclinic.vetClinic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column( name = "appointment_time")
    private LocalTime appointmentTime;

    // Relations of tables
    @ManyToOne
    @JsonIgnore //postmande sonsuz donguyu onlemek icin.
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    private Animal animal;


}

