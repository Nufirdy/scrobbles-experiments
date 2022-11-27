package ent.otego.songlibrary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScrobblesRepository extends JpaRepository<Scrobble, Long> {

    Scrobble findFirstByTrackMbid(UUID trackId);
}
