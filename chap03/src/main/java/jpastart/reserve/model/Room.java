package jpastart.reserve.model;

import javax.persistence.*;

@Entity
@Table(name="room_info")
public class Room {

    public Room(){}
    public Room(String number, String name, String description) {
        this.number      = number;
        this.name        = name;
        this.description = description;
    }

    @Id
    private String number;
    private String name;
    private String description;

    @Column(name="id", insertable = false, updatable = false)
    @Access(AccessType.PROPERTY)
    private Long dbId;


    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
