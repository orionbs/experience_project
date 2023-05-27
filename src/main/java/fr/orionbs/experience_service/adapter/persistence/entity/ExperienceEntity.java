package fr.orionbs.experience_service.adapter.persistence.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "experience")
@Data
public class ExperienceEntity {

    @MongoId
    private String id;
    @Field(write = Field.Write.ALWAYS)
    private String title;
    @Field(write = Field.Write.ALWAYS)
    private String description;
    @Field(write = Field.Write.ALWAYS)
    private LocalDate start;
    private LocalDate end;
    @Field(write = Field.Write.ALWAYS)
    private CompanyEntity company;
    private List<TaskEntity> tasks = new ArrayList<>();
    private List<String> languages = new ArrayList<>();
    private List<String> architectures = new ArrayList<>();
    private List<String> designPatterns = new ArrayList<>();
    private List<String> deployments = new ArrayList<>();
    private List<String> environments = new ArrayList<>();

    @Data
    public static class CompanyEntity {
        @Field(write = Field.Write.ALWAYS)
        private String name;
        @Field(write = Field.Write.ALWAYS)
        private String description;
    }

    @Data
    public static class TaskEntity {
        @Field(write = Field.Write.ALWAYS)
        private String icon;
        @Field(write = Field.Write.ALWAYS)
        private String value;
    }

}
