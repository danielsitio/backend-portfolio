package com.danest.portfoliobackend.domain;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String position;
    @NotBlank
    @Column(nullable = false)
    private String description;
    @NotNull
    @Column(nullable = false)
    private LocalDate startDate;
    @NotNull
    @Column(nullable = false)
    private LocalDate finishDate;
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "workplace_name", nullable = false))
    @AttributeOverride(name = "logo.url", column = @Column(name = "workplace_logo"))
    private Institute workplace;

    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Institute getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Institute workplace) {
        this.workplace = workplace;
    }

    public String getWorkplaceIdentifier() {
        return "workplace" + id;
    }

    public void copyExperience(Experience experience) {
        this.workplace = experience.workplace;
        this.position = experience.position;
        this.description = experience.description;
        this.startDate = experience.startDate;
        this.finishDate = experience.finishDate;
    }

    public void updateFromMap(Map<String, String> partialExperience) {
        partialExperience.keySet()
                .stream()
                .forEach(fieldToChange -> {
                    switch (fieldToChange) {
                        case "position":
                            setPosition(partialExperience.get(fieldToChange));
                            break;
                        case "description":
                            setDescription(partialExperience.get(fieldToChange));
                            break;
                        case "startDate":
                            setStartDate(LocalDate.parse(partialExperience.get(fieldToChange)));
                            break;
                        case "finishDate":
                            setFinishDate(LocalDate.parse(partialExperience.get(fieldToChange)));
                            break;
                    }
                });
    }
}
