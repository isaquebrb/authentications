package br.com.isaquebrb.authentications.core.service;

import br.com.isaquebrb.authentications.adapter.presenter.request.BurgerRequest;
import br.com.isaquebrb.authentications.core.domain.Burger;

import java.util.UUID;

public interface UpdatedBurgerUseCase {

    Burger updateBurger(UUID burgerId, BurgerRequest burgerRequest);
}
