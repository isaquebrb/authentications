package br.com.isaquebrb.authentications.adapter.presenter.request;

import br.com.isaquebrb.authentications.core.domain.Burger;
import br.com.isaquebrb.authentications.core.domain.Ingredient;
import br.com.isaquebrb.authentications.core.domain.NutritionalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BurgerRequest {

    @NotBlank
    private String name;

    @NotEmpty
    private List<IngredientRequest> ingredients;

    @NotNull
    private NutritionalInfoRequest nutritionalInfo;

    public Burger newBurger() {
        Burger burger = new Burger();
        burger.setName(this.name);
        burger.setNutritionalInfo(new NutritionalInfo(this.nutritionalInfo.getCalories()));

        this.ingredients.forEach(ingredient ->
                burger.getIngredients().add(
                        new Ingredient(ingredient.getDescription()))
        );

        return burger;
    }
}
