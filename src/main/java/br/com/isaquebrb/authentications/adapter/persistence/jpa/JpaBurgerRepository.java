package br.com.isaquebrb.authentications.adapter.persistence.jpa;

import br.com.isaquebrb.authentications.adapter.persistence.entity.BurgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBurgerRepository extends JpaRepository<BurgerEntity, UUID> {
}
