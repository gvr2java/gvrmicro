package hu.ismicro.commons.codecat;

import hu.ismicro.commons.dbattributes.EntityWithAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

/**
 * @author cstamas
 *
 */
public class Property implements EntityWithAttributes {
    
    private Long oid;
    
    private String owner;
    
    private String name;
    
    private Integer length;
    
    private Integer precision;
    
    private String type;
    
    private Set propertyValues;

    public Object getPrimaryKey() {
        return getOid();
    }

    public Class getAttributeClass() {
        return PropertyAttribute.class;
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
     * @param owner The owner to set.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return Returns the owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param length The length to set.
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @return Returns the length.
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param precision The precision to set.
     */
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    /**
     * @return Returns the precision.
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param propertyValues The propertyValues to set.
     */
    public void setPropertyValuesInternal(Set propertyValues) {
        this.propertyValues = propertyValues;
    }

    /**
     * @return Returns the propertyValues.
     */
    public Set getPropertyValuesInternal() {
        if (this.propertyValues == null) {
            this.propertyValues = new HashSet();
        }
        return propertyValues;
    }

    public List getPropertyValues() {
        List sortedPVs = new ArrayList(getPropertyValuesInternal());
        PropertyComparator.sort(sortedPVs, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPVs);
    }

}
