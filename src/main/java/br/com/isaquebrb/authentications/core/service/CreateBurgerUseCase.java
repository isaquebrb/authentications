package br.com.isaquebrb.authentications.core.service;

import br.com.isaquebrb.authentications.core.domain.Burger;

public interface CreateBurgerUseCase {

    Burger createBurger(Burger newBurger);
}
