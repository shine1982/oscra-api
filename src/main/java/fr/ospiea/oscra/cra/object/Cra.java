package fr.ospiea.oscra.cra.object;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by taozheng on 13/10/2016.
 */
@Entity
public class Cra extends AbstractEntity implements Serializable {
    private long id;
    private String month;
    private boolean validated;
    private User provider;
    private User validator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public User getValidator() {
        return validator;
    }

    public void setValidator(User validator) {
        this.validator = validator;
    }
}
