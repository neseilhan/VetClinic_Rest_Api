package dev.vetclinic.vetClinic.core.exception;

public class recordAlreadyExistException extends RuntimeException {
        private final Long id;

        public recordAlreadyExistException(Long id) {
            super(id + " id’li kayıt zaten mevcut.");
            this.id = id;
        }

        public Long getId() {
            return id;
        }
//
//    public recordAlreadyExistException(String message) {
//        super(message);
//    }
}
