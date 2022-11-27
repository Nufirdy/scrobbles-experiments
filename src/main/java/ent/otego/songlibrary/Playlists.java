package ent.otego.songlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class Playlists {

    private ScrobblesRepository repository;

    @Autowired
    public Playlists(ScrobblesRepository repository) {
        this.repository = repository;
        extractPlaylists();
    }

    public void extractPlaylists() {
        List<Scrobble> allScrobbles = repository.findAll(Sort.by(Sort.Direction.ASC, "time"));
        Set<List<String>> playlists = new HashSet<>();
        for (int i = 3; ; i++) {//размер блока поиска
            int prevSize = playlists.size();
            Set<List<String>> intermediateSet = new HashSet<>();
            Set<List<String>> playlistsBatch = new HashSet<>();
            for (int j = 0; j < allScrobbles.size() - i; j++) {//итерация списка
                List<String> possiblePlaylist = new ArrayList<>();
                for (int k = 0; k < i; k++) {//сбор песен в список
                    Scrobble scrobble = allScrobbles.get(j + k);
                    possiblePlaylist.add(scrobble.getArtist() +
                            " - " +
                            scrobble.getTrack() +
                            System.lineSeparator());
                }
                if (!intermediateSet.add(possiblePlaylist)) {
                    playlistsBatch.add(possiblePlaylist);
                }
            }

            Iterator<List<String>> iterator = playlists.iterator();
            while (iterator.hasNext()) {
                List<String> playlist = iterator.next();
                for (List<String> newPlaylist : playlistsBatch) {
                    if (newPlaylist.containsAll(playlist)) {
                        iterator.remove();
                        break;
                    }
                }
            }

            playlists.addAll(playlistsBatch);

            if (prevSize == playlists.size()) {
                break;
            }
        }

        try (PrintWriter writer = new PrintWriter("playlists.txt", StandardCharsets.UTF_8)) {
            int i = 1;
            for (List<String> playlist : playlists) {
                StringBuilder builder = new StringBuilder();

                builder.append("Playlist №").append(i).append(":").append(System.lineSeparator());
                playlist.forEach(builder::append);
                builder.append(System.lineSeparator());

                writer.println(builder);

                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
