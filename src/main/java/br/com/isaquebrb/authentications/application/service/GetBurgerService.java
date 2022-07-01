package br.com.isaquebrb.authentications.application.service;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import br.com.isaquebrb.authentications.application.mapper.BurgerMapper;
import br.com.isaquebrb.authentications.application.persistence.GetBurgerPersistence;
import br.com.isaquebrb.authentications.core.domain.Burger;
import br.com.isaquebrb.authentications.core.service.GetBurgerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class GetBurgerService implements GetBurgerUseCase {

    private final GetBurgerPersistence getBurgerPersistence;

    @Override
    public List<Burger> getAllBurgers() {
        log.info("Searching all burgers.");
        return getBurgerPersistence.getAllBurgers().stream()
                .map(BurgerMapper::fromEntity)
                .toList();
    }

    @Override
    public Burger getBurger(UUID burgerId) {
        log.info("Searching burger [{}].", burgerId);
        BurgerEntity entity = getBurgerPersistence.getBurger(burgerId);

        return BurgerMapper.fromEntity(entity);
    }
}
