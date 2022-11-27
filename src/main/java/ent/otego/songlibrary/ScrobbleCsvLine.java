package ent.otego.songlibrary;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScrobbleCsvLine {

    int uts;

    LocalDateTime time;

    String artist;

    UUID artistMbid;

    String album;

    UUID albumMbid;

    String track;

    UUID trackMbid;
}
