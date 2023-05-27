package fr.orionbs.experience_service.adapter.exception;

import fr.orionbs.experience_service.adapter.exception.UnknownExperienceException;
import fr.orionbs.experience_service.adapter.exception.response.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionApiAdapter {

    private final MessageSource exceptionMessageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        exceptionResponse.setErrors(methodArgumentNotValidException.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        return exceptionResponse;
    }

    @ExceptionHandler({UnknownExperienceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleUnknownException(Exception exception, Locale locale) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        exceptionResponse.setErrors(List.of(exceptionMessageSource.getMessage(exception.getMessage(), null, locale)));
        return exceptionResponse;
    }

}
