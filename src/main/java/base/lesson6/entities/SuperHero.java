package base.lesson6.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SuperHero {
    Integer number;
    String user;
    String desciption;


    public SuperHero(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.desciption = description;
    }


}
