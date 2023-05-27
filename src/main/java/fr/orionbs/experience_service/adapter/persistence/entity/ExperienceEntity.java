package fr.orionbs.experience_service.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "experience")
public class ExperienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "information_id", referencedColumnName = "id")
    private InformationEntity information;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;

    @ManyToMany
    @JoinTable(name="experience_task",
            joinColumns= @JoinColumn(name="experience_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="task_id", referencedColumnName="id")
    )
    private List<TaskEntity> tasks = new ArrayList<>();

}
