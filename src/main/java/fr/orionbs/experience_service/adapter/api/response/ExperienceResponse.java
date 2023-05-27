package fr.orionbs.experience_service.adapter.api.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ExperienceResponse {

    private String id;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private CompanyResponse company;
    private List<TaskResponse> tasks = new ArrayList<>();
    private List<String> languages = new ArrayList<>();
    private List<String> architectures = new ArrayList<>();
    private List<String> designPatterns = new ArrayList<>();
    private List<String> deployments = new ArrayList<>();
    private List<String> environments = new ArrayList<>();

    @Data
    public static class CompanyResponse {
        private String name;
        private String description;
    }

    @Data
    public static class TaskResponse {
        private String icon;
        private String value;
    }

}
