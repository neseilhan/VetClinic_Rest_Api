package dev.vetclinic.vetClinic.core.exception;

public class appointmentAlreadyExistException extends  RuntimeException{
    public appointmentAlreadyExistException(String message) {
        super(message);
    }

}
