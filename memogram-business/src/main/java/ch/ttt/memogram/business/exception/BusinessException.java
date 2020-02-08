package ch.ttt.memogram.business.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(final String msg) {
        super(msg);
    }
}
