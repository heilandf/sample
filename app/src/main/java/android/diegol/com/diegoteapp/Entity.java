package android.diegol.com.diegoteapp;

import java.io.Serializable;

/**
 * Created by fheiland on 12/15/17.
 */

public class Entity implements Serializable {
    private String name;
    private String lastName;

    public Entity(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
