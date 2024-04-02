package ru.practicum.confidence.exception;

public class UserDoesNotHaveEnoughFundsToPurchase extends RuntimeException{
    public UserDoesNotHaveEnoughFundsToPurchase(String message) {
        super(message);
    }
}
