package dev.vetclinic.vetClinic.core.config;

public class ResultHelper {

    public static <T> ResultData<T> created(T data){
        return new ResultData<>("201", Msg.CREATED, true, data);
    }

    public static <T> ResultData<T> validateError(T data){
        return new ResultData<>("400", Msg.VALIDATE_ERROR, false, data);
    }

    public static <T> ResultData<T> success(T data){
        return new ResultData<>("200", Msg.OK, true, data);
    }

    public static Result ok(){
        return new Result("200", Msg.OK, true);
    }

    public static Result notFoundError(){
        return new Result("404", Msg.NOT_FOUND, false);
    }


    public static Result notAvailableError(){
        return new Result("400", Msg.NOT_AVAILABLE_ERROR, false);
    }

    public static Result animalSelectIdNullError(){
        return new Result("400", Msg.ANIMAL_SELECT_ID_NULL, false);
    }

    public static Result doctorSelectIdNullError(){
        return new Result("400", Msg.DOCTOR_SELECT_ID_NULL, false);
    }

//    public static Result recordAlreadyExistsError(Long id, Class<CustomerResponse> customerResponseClass) {
//        return new Result("409", id + Msg.RECORD_ALREADY_EXISTS, false);
//    }
    public static <T> ResultData<T> recordAlreadyExistsError(Long id, T data) {
        return new ResultData<>("409",  Msg.RECORD_ALREADY_EXISTS +id, false, data);
    }
    public static Result recordNotFoundWithId(Long id) {
        return new Result("404",  Msg.RECORD_NOT_FOUND_WITH_ID +id,   false);
    }

    public static Result vaccineValidityError(String Message) {
        return new Result("400", Msg.DATE_ERROR, false);
    }

    public static Result vaccineNotApplicableError(String Message) {
        return new Result("409",  Msg.VACCINE_ERROR , false);
    }

    public static <T> ResultData<T> appointmentAlreadyExistError(Long id, T data) {
        return new ResultData<>("409",  Msg.DOCTOR_ERROR +id, false, data);
    }

    public static Result appointmentHoursError(String Message) {
        return new Result("409",  Msg.APPOINTMENT_ERROR , false);
    }
}