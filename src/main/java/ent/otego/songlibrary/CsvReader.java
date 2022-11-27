package ent.otego.songlibrary;

import ent.otego.songlibrary.data.Song;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class CsvReader {

    private ScrobblesService scrobblesService;

    public CsvReader(ScrobblesService scrobblesService) {
        this.scrobblesService = scrobblesService;

//        try {
//            List<ScrobbleCsvLine> scrobbleCsvLines = readLastFmScrobblesCsv();
//            scrobblesService.saveScrobbles(scrobbleCsvLines);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private List<Song> readLastFmScrobblesCsv() throws IOException {
        File csv = new File("C:/Users/masta/Downloads/scrobbles-Nufirdy-1662663166.csv");
        CSVParser parser = CSVParser.parse(csv, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader());
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd LLL yyyy, HH:mm")
                .toFormatter(Locale.ENGLISH);
        List<Song> songs = new ArrayList<>();
        for (CSVRecord record : parser.getRecords()) {
//            ScrobbleCsvLine scrobble = new ScrobbleCsvLine();
//            scrobble.setUts(Integer.parseInt(record.get(0)));
//            scrobble.setTime(LocalDateTime.parse(record.get(1), dateFormat));
//            scrobble.setArtist(record.get(2));
//            scrobble.setArtistMbid(uuidOrNull(record.get(3)));
//            scrobble.setAlbum(record.get(4));
//            scrobble.setAlbumMbid(uuidOrNull(record.get(5)));
//            scrobble.setTrack(record.get(6));
//            scrobble.setTrackMbid(uuidOrNull(record.get(7)));

            Song song = new Song();
            song.setArtist(record.get(2));
            song.setAlbum(record.get(4));
            song.setTrack(record.get(6));

            songs.add(song);
        }

        return songs;
    }

    private UUID uuidOrNull(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (Exception ignored) {}
        return null;
    }
}
