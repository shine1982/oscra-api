package fr.ospiea.oscra.employee.object;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by taozheng on 19/09/2016.
 */
@Embeddable
public class EmployeeDetail implements Serializable {

    private String phoneNumber;
    private String birthday;
    private String position;
    private String fixNumber;
    @Enumerated(EnumType.STRING)
    private Civility civility;

}
