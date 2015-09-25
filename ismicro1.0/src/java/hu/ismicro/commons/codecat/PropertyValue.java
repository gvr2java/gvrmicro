package hu.ismicro.commons.codecat;

import hu.ismicro.commons.dbattributes.EntityWithAttributes;

/**
 * @author cstamas
 *
 */
public class PropertyValue implements EntityWithAttributes {
    
    private Long oid;
    
    private String value;
    
    private Property property;

    public Object getPrimaryKey() {
        return getOid();
    }

    public Class getAttributeClass() {
        return PropertyValueAttribute.class;
    }

    /**
     * @param oid The oid to set.
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }

    /**
     * @return Returns the oid.
     */
    public Long getOid() {
        return oid;
    }

    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param property The property to set.
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * @return Returns the property.
     */
    public Property getProperty() {
        return property;
    }

}
