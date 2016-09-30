package fr.ospiea.oscra.user.object;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by taozheng on 19/09/2016.
 */
@Embeddable
public class UserDetail implements Serializable {

    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    private String position;
    private String fixNumber;
    @Enumerated(EnumType.STRING)
    private Civility civility;

}
