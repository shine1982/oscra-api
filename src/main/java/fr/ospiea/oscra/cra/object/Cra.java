package fr.ospiea.oscra.cra.object;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by taozheng on 13/10/2016.
 */
@Entity
public class Cra extends AbstractEntity implements Serializable {
    private long id;
    private String month;
    private boolean validated;


    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="provider_id")
    private User provider;

    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="validator_id")
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

    public void copyFrom(Cra cra){
        Field[] attributes =  cra.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                field.set(this,field.get(cra));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
