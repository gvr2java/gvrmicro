package hu.ismicro.commons.codecat;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

/**
 * @author cstamas
 *
 */
public class NoSuchPropertyException extends IncorrectResultSizeDataAccessException {

    public NoSuchPropertyException() {
        super(1, 0);
    }

    public NoSuchPropertyException(String message) {
        super(message, 1, 0);
    }

}
