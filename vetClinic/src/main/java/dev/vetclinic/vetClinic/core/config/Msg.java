package dev.vetclinic.vetClinic.core.config;

public class Msg {
    public static final String CREATED = "Data successfully saved.";
    public static final String VALIDATE_ERROR = "Data validation error.";
    public static final String OK = "Process successfully executed.";
    public static final String NOT_FOUND = "Data not found.";
    public static final String DATE_ERROR = "The protection finish date has been expired.";
    public static final String VACCINE_ERROR = "The vaccine with the same code and name was administered recently. ";
    public static final String DOCTOR_ERROR = "This doctor is unavailable at this date.";
    public static final String APPOINTMENT_ERROR = "There should be at least 1 hour between two appointments.";
    public static final String NOT_AVAILABLE_ERROR = "No appointment available at this hour.";
    public static final String ANIMAL_SELECT_ID_NULL = "An animal should be selected.";
    public static final String DOCTOR_SELECT_ID_NULL = "A doctor should be selected.";
    public static final String VACCINE_NULL = "No vaccines found for the given date range.";
    public static final String RECORD_ALREADY_EXISTS = " Record already exists in the system with id : ";
    public static final String APPOINTMENT_ALREADY_EXISTS = " Appointment already exists in that day and time. ";
    public static final String RECORD_NOT_FOUND_WITH_ID = "Record not found in the system with id : ";
}