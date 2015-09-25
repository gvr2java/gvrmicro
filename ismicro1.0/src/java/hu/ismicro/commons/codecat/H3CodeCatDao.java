package hu.ismicro.commons.codecat;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author cstamas
 * 
 */
public class H3CodeCatDao extends HibernateDaoSupport implements CodeCatDao {

    public List getProperties() throws DataAccessException {
        return getHibernateTemplate().find("from Property");
    }

    public List getProperties(String owner) throws DataAccessException {
        return getHibernateTemplate().find("from Property as p where p.Owner = ?", owner);
    }

    public Property getProperty(String owner, String name) throws DataAccessException {
        return getProperty(owner, name, false);
    }

    public Property getProperty(String owner, String name, boolean create) throws DataAccessException {
        List props = getHibernateTemplate().find("from Property as p where p.Owner = ? and p.Name = ?",
                new Object[] { owner, name });
        if (props.size() == 1) {
            return (Property) props.get(0);
        } else if (props.size() > 1) {
            throw new IncorrectResultSizeDataAccessException("Found more than one Property for owner " + owner
                    + " and name " + name, 1, props.size());
        } else {
            if (create) {
                Property prop = new Property();
                prop.setOwner(owner);
                prop.setName(name);
                return prop;
            } else {
                throw new NoSuchPropertyException("No property for Owner " + owner + " with name " + name);
            }
        }
    }

    public void putProperty(Property property) throws DataAccessException {
        getHibernateTemplate().merge(property);
        getHibernateTemplate().flush();
    }

    public void removeProperty(Property property) throws DataAccessException {
        getHibernateTemplate().delete(property);
        getHibernateTemplate().flush();
    }

    public List getPropertyValues(Property property) throws DataAccessException {
        return getHibernateTemplate().find("from PropertyValue as p where p.Property = ?", property);
    }

    public PropertyValue getPropertyValue(Property property, String value, boolean create) throws DataAccessException {
        List vals = getHibernateTemplate().find("from PropertyValue as pv where pv.Property = ? and pv.Value = ?", new Object[] {property, value});
        if (vals.size() == 1) {
            return (PropertyValue) vals.get(0);
        } else if (vals.size() > 1) {
            throw new IncorrectResultSizeDataAccessException("Found more than one PropertyValue for owner " + property.getOwner()
                    + " and name " + property.getName() + " and value " + value, 1, vals.size());
        } else {
            if (create) {
                getHibernateTemplate().merge(property);
                PropertyValue pv = new PropertyValue();
                pv.setProperty(property);
                pv.setValue(value);
                return pv;
            } else {
                throw new NoSuchPropertyValueException("No PropValue for Owner " + property.getOwner() + " with name " + property.getName());
            }
            
        }
    }

    public void putPropertyValue(PropertyValue propertyValue) throws DataAccessException {
        getHibernateTemplate().merge(propertyValue);
        getHibernateTemplate().flush();
    }

    public void removePropertyValue(PropertyValue propertyValue) throws DataAccessException {
        getHibernateTemplate().delete(propertyValue);
        getHibernateTemplate().flush();
    }

}
