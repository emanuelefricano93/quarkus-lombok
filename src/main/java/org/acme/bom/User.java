package org.acme.bom;

import com.mongodb.DBObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private String name;
    private String lastname;
    private Double age;

    public User(DBObject userObj) {
        this.name = String.valueOf(userObj.get("name"));
        this.lastname = String.valueOf(userObj.get("lastname"));
        this.age = Double.valueOf(String.valueOf(userObj.get("age")));
    }
}
