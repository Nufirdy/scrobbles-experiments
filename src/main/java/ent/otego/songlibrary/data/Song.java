package ent.otego.songlibrary.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Song {

    String artist;
    String album;
    String track;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return artist.equals(song.artist) && Objects.equals(album, song.album) && track.equals(song.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, album, track);
    }
}
