package ent.otego.songlibrary.data.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "artists")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist {

    @Id
    private Long id;

    String name;

}
