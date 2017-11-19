package jpastart.reserve.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    private String id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Hotel(){}
    public Hotel(String id, String name, Grade grade) {
        this.id    = id;
        this.name  = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
