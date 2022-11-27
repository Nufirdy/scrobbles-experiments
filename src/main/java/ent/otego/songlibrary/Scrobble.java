package ent.otego.songlibrary;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "scrobbles_raw")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Scrobble {

    @Id
    long uts;

    LocalDateTime time;

    @Column
    String artist;

    @Column
    UUID artistMbid;

    @Column
    String album;

    @Column
    UUID albumMbid;

    @Column
    String track;

    @Column
    UUID trackMbid;
}
