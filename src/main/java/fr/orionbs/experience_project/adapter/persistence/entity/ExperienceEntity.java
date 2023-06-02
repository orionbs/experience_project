package fr.orionbs.experience_project.adapter.persistence.entity;

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

    @OneToMany(mappedBy = "experience")
    private List<TaskEntity> tasks = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="experience_skill",
            joinColumns= @JoinColumn(name="experience_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="skill_id", referencedColumnName="id")
    )
    private List<SkillEntity> skills = new ArrayList<>();

}
