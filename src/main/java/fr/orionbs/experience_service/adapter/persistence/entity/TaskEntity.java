package fr.orionbs.experience_service.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToMany(mappedBy = "tasks")
    private List<ExperienceEntity> experiences = new ArrayList<>();

}
