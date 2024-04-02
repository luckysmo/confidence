package ru.practicum.confidence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.confidence.dto.BasketDto;
import ru.practicum.confidence.exception.NotFoundException;
import ru.practicum.confidence.exception.UserDoesNotHaveEnoughFundsToPurchase;
import ru.practicum.confidence.model.Product;
import ru.practicum.confidence.model.User;
import ru.practicum.confidence.repository.BasketRepository;
import ru.practicum.confidence.repository.ProductRepository;
import ru.practicum.confidence.repository.UserRepository;
import ru.practicum.confidence.service.BasketService;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final BasketRepository basketRepository;

    @Override
    public BasketDto updateBasket(BasketDto basketDto, Long productId, Long userId) {
        Product product = getProduct(productId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователя с таким Id не существует"));
        if (product.getPrice() < user.getBalance()) {
            basketDto.setProduct(product);
        }
        throw new UserDoesNotHaveEnoughFundsToPurchase("У вас недостаточно средств для покупки");
    }

    @Override
    public void deleteProductsInBasket(Long basketId,Long productId) {
        Product product = getProduct(productId);
        basketRepository.deleteById(product.getId());
    }

    private Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(String.format("Предмета с id=%s не существует", productId)));
    }
}
