package fr.orionbs.experience_service.adapter.exception.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private List<String> errors = new ArrayList<>();
}
