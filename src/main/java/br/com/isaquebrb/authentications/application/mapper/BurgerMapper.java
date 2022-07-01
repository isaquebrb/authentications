package br.com.isaquebrb.authentications.application.mapper;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import br.com.isaquebrb.authentications.adapter.presenter.request.BurgerRequest;
import br.com.isaquebrb.authentications.core.domain.Burger;

public interface BurgerMapper {

    static Burger fromRequest(BurgerRequest burgerRequest) {
        return new Burger(null, burgerRequest.getName(), burgerRequest.getDescription(),
                burgerRequest.getCalories());
    }

    static BurgerEntity toEntity(Burger burger) {
        return new BurgerEntity(burger.getId(), burger.getName(), burger.getDescription(),
                burger.getCalories());
    }

    static Burger fromEntity(BurgerEntity entity) {
        return new Burger(entity.getId(), entity.getName(), entity.getDescription(),
                entity.getCalories());
    }
}
