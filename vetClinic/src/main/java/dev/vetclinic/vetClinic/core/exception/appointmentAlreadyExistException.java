package dev.vetclinic.vetClinic.core.exception;

public class appointmentAlreadyExistException extends  RuntimeException{
    private final Long id;

    public appointmentAlreadyExistException(Long id) {
        super(id + " id’li kayıt zaten mevcut.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
