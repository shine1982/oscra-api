package fr.ospiea.oscra.user.object;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by taozheng on 19/09/2016.
 */
@Embeddable
public class Address implements Serializable {

    private String roadNumber;
    private String road;
    private String supplementaryAddress;
    private String postalCode;
    private String city;

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

}
