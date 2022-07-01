package br.com.isaquebrb.authentications.application.service;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import br.com.isaquebrb.authentications.adapter.persistence.jpa.JpaBurgerRepository;
import br.com.isaquebrb.authentications.adapter.presenter.request.BurgerRequest;
import br.com.isaquebrb.authentications.application.mapper.BurgerMapper;
import br.com.isaquebrb.authentications.application.persistence.GetBurgerPersistence;
import br.com.isaquebrb.authentications.core.domain.Burger;
import br.com.isaquebrb.authentications.core.service.UpdatedBurgerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class UpdateBurgerService implements UpdatedBurgerUseCase {

    private final GetBurgerPersistence getBurgerPersistence;
    private final JpaBurgerRepository burgerRepository;

    @Override
    public Burger updateBurger(UUID burgerId, BurgerRequest burgerRequest) {
        BurgerEntity burgerEntity = getBurgerPersistence.getBurger(burgerId);

        burgerEntity.update(burgerEntity.getName(), burgerEntity.getDescription(), burgerEntity.getCalories());

        burgerRepository.save(burgerEntity);

        log.info("Burger [{}] updated.", burgerId);
        return BurgerMapper.fromEntity(burgerEntity);
    }
}
