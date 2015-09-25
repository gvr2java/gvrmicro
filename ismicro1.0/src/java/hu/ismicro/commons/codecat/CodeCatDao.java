package hu.ismicro.commons.codecat;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * @author cstamas
 *
 */
public interface CodeCatDao {
    
    List getProperties() throws DataAccessException;

    List getProperties(String owner) throws DataAccessException;

    Property getProperty(String owner, String name) throws DataAccessException;

    Property getProperty(String owner, String name, boolean create) throws DataAccessException;
    
    void putProperty(Property property) throws DataAccessException;
    
    void removeProperty(Property property) throws DataAccessException;

    List getPropertyValues(Property property) throws DataAccessException;

    PropertyValue getPropertyValue(Property property, String value, boolean create) throws DataAccessException;
    
    void putPropertyValue(PropertyValue propertyValue) throws DataAccessException;
    
    void removePropertyValue(PropertyValue propertyValue) throws DataAccessException;

}
