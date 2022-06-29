package br.com.isaquebrb.authentications.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@AllArgsConstructor
public class NutritionalInfoRequest {

    @NotNull
    @PositiveOrZero
    private Integer calories;
}
