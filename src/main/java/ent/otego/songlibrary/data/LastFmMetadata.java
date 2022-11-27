package ent.otego.songlibrary.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LastFmMetadata {

    UUID artistMbid;
    UUID albumMbid;
    UUID trackMbid;
}
