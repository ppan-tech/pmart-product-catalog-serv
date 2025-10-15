package com.pmart.pmartproductcatalogserv.advises;

import com.pmart.pmartproductcatalogserv.dtos.ErrorDTO;
import com.pmart.pmartproductcatalogserv.exceptions.OperationException;
import com.pmart.pmartproductcatalogserv.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
    Global Exception Handler to manage common exceptions across the application.(checked & unchecked)
    This improves code reusability, maintainability, and provides a consistent error response structure.
    It also helps in logging exceptions in a centralized manner.
*/

@Slf4j // This creates 'private static final Logger log = LoggerFactory.getLogger(MyApiController.class);'
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles the common NullPointerException, for robustness of the application ,and avoids exposing stack traces to clients.
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 Status
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        // Log the exception details (this is important! for debugging)
        log.error("An unexpected null pointer exception occurred", ex);

        // Returns a clean, user-friendly error response
        return new ResponseEntity<>("An internal server error occurred due to missing data.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException pexp){
        //code to handle the exception & beatify the response

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage(pexp.getMessage());
        log.error("ProductNotFound exception occurred", pexp);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OperationException.class)
    public ResponseEntity<ErrorDTO> handleOperationException(OperationException opexp){
        //code to handle the exception & beautify the response
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage(opexp.getMessage());
        log.error("An OperationException occurred", opexp);
        return new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(400));
    }
}