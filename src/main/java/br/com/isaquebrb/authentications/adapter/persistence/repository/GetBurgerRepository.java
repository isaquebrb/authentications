package br.com.isaquebrb.authentications.adapter.persistence.repository;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import br.com.isaquebrb.authentications.adapter.persistence.jpa.JpaBurgerRepository;
import br.com.isaquebrb.authentications.application.exception.NotFoundException;
import br.com.isaquebrb.authentications.application.persistence.GetBurgerPersistence;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class GetBurgerRepository implements GetBurgerPersistence {

    private final JpaBurgerRepository burgerRepository;

    @Override
    public BurgerEntity getBurger(UUID burgerId) {
        return burgerRepository.findById(burgerId).orElseThrow(() ->
                new NotFoundException("Burger [" + burgerId + "] not found."));
    }

    @Override
    public List<BurgerEntity> getAllBurgers() {
        return burgerRepository.findAll();
    }
}
