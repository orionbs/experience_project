package fr.orionbs.experience_project.adapter.exception;

import fr.orionbs.experience_project.domain.exception.ExperienceInitiationException;
import fr.orionbs.experience_project.domain.exception.InformationAdditionException;
import fr.orionbs.experience_project.domain.exception.InformationAssociationException;
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
    public List<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
    }

    @ExceptionHandler({ExperienceInitiationException.class, InformationAdditionException.class, InformationAssociationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(Exception exception, Locale locale) {
        return exceptionMessageSource.getMessage(exception.getMessage(), null, locale);
    }

}
