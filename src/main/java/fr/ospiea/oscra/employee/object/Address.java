package fr.ospiea.oscra.employee.object;

import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by taozheng on 19/09/2016.
 */
@Embeddable
public class Address implements Serializable {
    public String getRoadNumber() {
        return roadNumber;
    }

    public String getRoad() {
        return road;
    }

    public String getSupplementaryAddress() {
        return supplementaryAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    private String roadNumber;

    private String road;

    private String supplementaryAddress;

    private String postalCode;

    private String city;

}
