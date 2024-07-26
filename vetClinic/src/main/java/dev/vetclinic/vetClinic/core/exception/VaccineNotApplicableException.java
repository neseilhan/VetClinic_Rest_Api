package dev.vetclinic.vetClinic.core.exception;

public class VaccineNotApplicableException extends RuntimeException{
//    private final Long id;
//
//    public VaccineNotApplicableException(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
public VaccineNotApplicableException(String message) {
    super(message);
}
}
