package br.com.isaquebrb.authentications.core.service;

import br.com.isaquebrb.authentications.core.domain.Burger;

import java.util.List;
import java.util.UUID;

public interface GetBurgerUseCase {

    List<Burger> getAllBurgers();

    Burger getBurger(UUID burgerId);
}
