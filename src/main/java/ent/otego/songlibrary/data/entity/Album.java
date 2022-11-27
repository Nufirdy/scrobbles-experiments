package ent.otego.songlibrary.data.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "albums")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album {

    @Id
    long id;

    @Column
    String name;

    @OneToMany
    Set<Artist> artists;
}
