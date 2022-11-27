package ent.otego.songlibrary.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Scrobble extends Listening {

    int uts;
    LastFmMetadata metadata;
    Song song;
}
