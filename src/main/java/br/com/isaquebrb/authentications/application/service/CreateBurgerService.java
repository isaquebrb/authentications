package br.com.isaquebrb.authentications.application.service;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import br.com.isaquebrb.authentications.adapter.persistence.jpa.JpaBurgerRepository;
import br.com.isaquebrb.authentications.application.mapper.BurgerMapper;
import br.com.isaquebrb.authentications.core.domain.Burger;
import br.com.isaquebrb.authentications.core.service.CreateBurgerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateBurgerService implements CreateBurgerUseCase {

    private final JpaBurgerRepository burgerRepository;

    @Override
    public Burger createBurger(Burger newBurger) {
        BurgerEntity burgerEntity = BurgerMapper.toEntity(newBurger);
        burgerRepository.save(burgerEntity);

        log.info("Burger [{}] created", burgerEntity.getId());
        return BurgerMapper.fromEntity(burgerEntity);
    }
}
