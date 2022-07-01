package br.com.isaquebrb.authentications.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Burger {

    private UUID id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Integer calories;

}
