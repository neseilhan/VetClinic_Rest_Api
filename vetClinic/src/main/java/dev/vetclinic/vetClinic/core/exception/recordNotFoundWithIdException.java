package dev.vetclinic.vetClinic.core.exception;

public class recordNotFoundWithIdException extends RuntimeException {
    private Long id;

    public Long getId() {
        return id;
    }
    public recordNotFoundWithIdException(Long id) {
        super(id + " id’li kayıt sistemde bulunamadı.");
        this.id = id;
    }

}
