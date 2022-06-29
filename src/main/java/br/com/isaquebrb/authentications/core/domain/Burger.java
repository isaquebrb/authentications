package br.com.isaquebrb.authentications.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Burger {

    private UUID id;

    @Setter
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

    @Setter
    private NutritionalInfo nutritionalInfo;

}
