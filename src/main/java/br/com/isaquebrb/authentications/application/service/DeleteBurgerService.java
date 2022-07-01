package br.com.isaquebrb.authentications.application.service;

import br.com.isaquebrb.authentications.adapter.persistence.jpa.JpaBurgerRepository;
import br.com.isaquebrb.authentications.core.service.DeleteBurgerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class DeleteBurgerService implements DeleteBurgerUseCase {

    private final JpaBurgerRepository burgerRepository;

    @Override
    public void deleteBurger(UUID burgerId) {
        burgerRepository.deleteById(burgerId);
        log.info("Burger [{}] deleted.", burgerId);
    }
}
