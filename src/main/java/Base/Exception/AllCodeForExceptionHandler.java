package Base.Exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;


@ControllerAdvice
@RestControllerAdvice
public class AllCodeForExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllCodeForExceptionHandler.class);

    @ExceptionHandler(value = MakeYourOwnException.class)
    public ResponseEntity<Object> handleMakeYourOwnException(MakeYourOwnException makeYourOwnException) {
        LOGGER.error("Exception error", makeYourOwnException);
        // We can add as many response key value pairs here which we want as a response
        LinkedHashMap<String, Object> response = new LinkedHashMap<>();
        response.put("STATUS", "FAILURE");
        response.put("Exception Type", "Customized");
        response.put("TIME", LocalDateTime.now());
        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.FORBIDDEN);
        return responseEntity;
    }


}
