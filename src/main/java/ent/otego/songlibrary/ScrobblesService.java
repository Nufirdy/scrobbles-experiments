package ent.otego.songlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ScrobblesService {

    private ScrobblesRepository scrobblesRepository;

//    @Autowired
    public ScrobblesService(ScrobblesRepository scrobblesRepository) {
        this.scrobblesRepository = scrobblesRepository;
    }

    public void saveScrobbles(List<ScrobbleCsvLine> scrobblesCsv) {
        List<Scrobble> scrobbles = scrobblesCsv.stream()
                .map(this::mapScrobbleCsvToEntity)
                .toList();
        scrobblesRepository.saveAll(scrobbles);
    }

    public Scrobble mapScrobbleCsvToEntity(ScrobbleCsvLine csv) {
        Scrobble scrobble = new Scrobble();
        scrobble.setUts(csv.getUts());
        scrobble.setTime(csv.getTime());
        scrobble.setArtist(csv.getArtist());
        scrobble.setArtistMbid(csv.getArtistMbid());
        scrobble.setAlbum(csv.getAlbum());
        scrobble.setAlbumMbid(csv.getAlbumMbid());
        scrobble.setTrack(csv.getTrack());
        scrobble.setTrackMbid(csv.getTrackMbid());
        return scrobble;
    }
}
