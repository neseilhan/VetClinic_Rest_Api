package dev.vetclinic.vetClinic.core.exception;

import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class GlobalExceptionHandler  {



    @ExceptionHandler(appointmentHoursException.class)
    public ResponseEntity<Result> appointmentHoursException(appointmentHoursException e) {
        Result result = ResultHelper.appointmentHoursError();
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(appointmentAlreadyExistException.class)
    public ResponseEntity<ResultData<Void>> handleAlreadyExistsException(appointmentAlreadyExistException e) {
        ResultData<Void> result = new ResultData<>("409", e.getMessage(), false, null);
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(vaccineValidityDateException.class)
    public ResponseEntity<Result> handleVaccineValidityDateException(vaccineValidityDateException e){
        Result result = ResultHelper.vaccineValidityError();
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(appointmentAlreadyExistException.class)
//    public ResponseEntity<ResultData<Void>> handleAlreadyExistsException(appointmentAlreadyExistException ex) {
//        ResultData<Void> result = new ResultData<>("409", ex.getMessage(), false, null);
//        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
//    }


    @ExceptionHandler(VaccineNotApplicableException.class)
    public ResponseEntity<Result> handleVaccineNotApplicableError(VaccineNotApplicableException e) {
        Result result = ResultHelper.vaccineNotApplicableError();
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(recordNotFoundWithIdException.class)
    public ResponseEntity<Result> handleRecordNotFoundException(recordNotFoundWithIdException e) {
        Result result = ResultHelper.recordNotFoundWithId(e.getId());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(recordAlreadyExistException.class)
    public ResponseEntity<ResultData<Void>> handleAlreadyExistsException(recordAlreadyExistException e) {
        ResultData<Void> result = new ResultData<>("409", e.getMessage(), false, null);
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

//        ResultData<List<String>> resultData = new ResultData<>("400", Msg.VALIDATE_ERROR, false, validationErrorList );
        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }
}