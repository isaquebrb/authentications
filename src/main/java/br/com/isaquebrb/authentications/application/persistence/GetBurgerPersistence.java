package br.com.isaquebrb.authentications.application.persistence;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;

import java.util.List;
import java.util.UUID;

public interface GetBurgerPersistence {

    BurgerEntity getBurger(UUID burgerId);

    List<BurgerEntity> getAllBurgers();
}
