package fhwedel.medienprojekt.fussball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fhwedel.medienprojekt.fussball.model.PlayerView;
import fhwedel.medienprojekt.fussball.model.PlayersView;

@Service // Liefert die Daten zurück
public class TopPlayerService {

	public PlayersView getTopPlayers() {
		PlayersView result = new PlayersView();
		result.setPlayers(createTopPlayers());
		return result;
	}

	private List<PlayerView> createTopPlayers() {
		List<PlayerView> result = new ArrayList<PlayerView>();
		result.add(new PlayerView("Ellen", "Schwartau"));
		result.add(new PlayerView("Merret", "Schwartau"));
		result.add(new PlayerView("Yasmin", "Musterfrau"));
		return result;
	}
}
