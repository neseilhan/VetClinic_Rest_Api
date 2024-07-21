package dev.vetclinic.vetClinic.core.config;

import dev.vetclinic.vetClinic.dto.response.AnimalResponse;

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

    public static Result dateError(){
        return new Result("400", Msg.DATE_ERROR, false);
    }

    public static Result vaccineError(){
        return new Result("400", Msg.VACCINE_ERROR, false);
    }

    public static Result doctorError(){
        return new Result("400", Msg.DOCTOR_ERROR, false);
    }

    public static Result appointmentError(){
        return new Result("400", Msg.APPOINTMENT_ERROR, false);
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
    public static Result recordAlreadyExistsError(Long id) {
        return new Result("409", id + Msg.RECORD_ALREADY_EXISTS, false);
    }
    public static Result recordNotFoundWithId(Long id) {
        return new Result("404", id + Msg.RECORD_NOT_FOUND_WITH_ID, false);
    }



    //    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
//        CursorResponse<T> cursor = new CursorResponse<>();
//        cursor.setItems(pageData.getContent());
//        cursor.setPageNumber(pageData.getNumber());
//        cursor.setPageSize(pageData.getSize());
//        cursor.setTotalElements(pageData.getTotalElements());
//
//        return ResultHelper.success(cursor);
//    }
}