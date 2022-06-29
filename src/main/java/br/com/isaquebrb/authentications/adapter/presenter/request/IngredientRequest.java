package br.com.isaquebrb.authentications.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class IngredientRequest {

    @NotBlank
    private String description;
}
