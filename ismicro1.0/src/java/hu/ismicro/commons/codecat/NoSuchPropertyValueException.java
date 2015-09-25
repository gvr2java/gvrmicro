package hu.ismicro.commons.codecat;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

/**
 * @author cstamas
 *
 */
public class NoSuchPropertyValueException extends IncorrectResultSizeDataAccessException {

    public NoSuchPropertyValueException() {
        super(1, 0);
    }
    
    public NoSuchPropertyValueException(String message) {
        super(message, 1, 0);
    }

}
