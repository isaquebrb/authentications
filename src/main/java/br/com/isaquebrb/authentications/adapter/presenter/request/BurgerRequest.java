package br.com.isaquebrb.authentications.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BurgerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @PositiveOrZero
    private Integer calories;
}
