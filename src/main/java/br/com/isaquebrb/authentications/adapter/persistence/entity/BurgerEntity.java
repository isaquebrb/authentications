package br.com.isaquebrb.authentications.adapter.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BurgerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Integer calories;

    public void update(String name, String description, Integer calories) {
        this.name = name;
        this.description = description;
        this.calories = calories;
    }
}
