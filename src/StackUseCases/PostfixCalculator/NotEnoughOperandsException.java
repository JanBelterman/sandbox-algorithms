package StackUseCases.PostfixCalculator;

public class NotEnoughOperandsException extends Exception {

    public NotEnoughOperandsException(String message) {
        super(message);
    }

}
