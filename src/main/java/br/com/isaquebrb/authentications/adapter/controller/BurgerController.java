package br.com.isaquebrb.authentications.adapter.controller;

import br.com.isaquebrb.authentications.adapter.presenter.request.BurgerRequest;
import br.com.isaquebrb.authentications.application.mapper.BurgerMapper;
import br.com.isaquebrb.authentications.core.domain.Burger;
import br.com.isaquebrb.authentications.core.service.CreateBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.DeleteBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.GetBurgerUseCase;
import br.com.isaquebrb.authentications.core.service.UpdatedBurgerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/burgers")
@RequiredArgsConstructor
public class BurgerController {

    private final GetBurgerUseCase getBurgerUseCase;
    private final CreateBurgerUseCase createBurgerUseCase;
    private final UpdatedBurgerUseCase updatedBurgerUseCase;
    private final DeleteBurgerUseCase deleteBurgerUseCase;

    @GetMapping
    public ResponseEntity<List<Burger>> getAllBurgers() {
        return ResponseEntity.ok(getBurgerUseCase.getAllBurgers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Burger> getBurger(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(getBurgerUseCase.getBurger(id));
    }

    @PostMapping
    public ResponseEntity<Burger> createBurger(@RequestBody @Valid BurgerRequest burgerRequest) {
        Burger burger = BurgerMapper.fromRequest(burgerRequest);
        return new ResponseEntity<>(createBurgerUseCase.createBurger(burger), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Burger> updateBurger(@PathVariable("id") UUID id,
                                               @RequestBody @Valid BurgerRequest burgerRequest) {
        return ResponseEntity.ok(updatedBurgerUseCase.updateBurger(id, burgerRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBurger(@PathVariable("id") UUID id) {
        deleteBurgerUseCase.deleteBurger(id);
        return ResponseEntity.noContent().build();
    }
}
