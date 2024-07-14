package backend.hanpum.exception.handler;

import backend.hanpum.exception.exception.test.TestNotFoundException;
import backend.hanpum.exception.format.code.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ApiResponse response;

    /* 예시 */
    @ExceptionHandler(TestNotFoundException.class)
    protected ResponseEntity<?> handle(TestNotFoundException e) {
        log.error("TestNotFoundException = {}", e.getErrorCode().getMessage());
        log.error("Error Message = {}", e.getMessage());
        return response.error(e.getErrorCode());
    }
}