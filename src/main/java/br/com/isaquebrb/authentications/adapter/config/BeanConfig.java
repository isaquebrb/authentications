package br.com.isaquebrb.authentications.adapter.config;

import br.com.isaquebrb.authentications.adapter.persistence.jpa.JpaBurgerRepository;
import br.com.isaquebrb.authentications.adapter.persistence.repository.GetBurgerRepository;
import br.com.isaquebrb.authentications.application.persistence.GetBurgerPersistence;
import br.com.isaquebrb.authentications.application.service.CreateBurgerService;
import br.com.isaquebrb.authentications.application.service.DeleteBurgerService;
import br.com.isaquebrb.authentications.application.service.GetBurgerService;
import br.com.isaquebrb.authentications.application.service.UpdateBurgerService;
import br.com.isaquebrb.authentications.core.service.CreateBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.DeleteBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.GetBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.UpdatedBurgerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateBurgerUseCase createBurgerUseCase(JpaBurgerRepository burgerRepository) {
        return new CreateBurgerService(burgerRepository);
    }

    @Bean
    public DeleteBurgerUseCase deleteBurgerUseCase(JpaBurgerRepository burgerRepository) {
        return new DeleteBurgerService(burgerRepository);
    }

    @Bean
    public GetBurgerUseCase getBurgerUseCase(GetBurgerPersistence getBurgerPersistence) {
        return new GetBurgerService(getBurgerPersistence);
    }

    @Bean
    public UpdatedBurgerUseCase updatedBurgerUseCase(GetBurgerPersistence getBurgerPersistence,
                                                     JpaBurgerRepository burgerRepository) {
        return new UpdateBurgerService(getBurgerPersistence, burgerRepository);
    }

    @Bean
    public GetBurgerPersistence getBurgerPersistence(JpaBurgerRepository burgerRepository){
        return new GetBurgerRepository(burgerRepository);
    }
}
