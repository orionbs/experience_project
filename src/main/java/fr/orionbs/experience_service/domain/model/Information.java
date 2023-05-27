package fr.orionbs.experience_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Information {

    private Integer id;

    private String title;

    private String description;

    private LocalDate start;

    private LocalDate end;

    private Experience experience;

}
