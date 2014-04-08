package fhwedel.medienprojekt.fussball.model.pagination;

/** externe Klassen */
import java.util.ArrayList;
import java.util.List;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/**
 * Page-Klasse
 * Stellt die Seitenansicht einer Liste an Einträgen dar.
 * 
 * @author Ellen Schwartau Minf9888
 *
 * @param <E>	Unterklasse der Post Klasse
 */
public class Page<E extends Post> {

	/* ------------- Klassenvariablen ------------------- */
    /** Aktuelle Seite */
	private int pageNumber;
	/** Gesamtzahl der Seiten */
    private int pagesAvailable;
    /** Liste an Einträgen */
    private List<E> pageItems = new ArrayList<E>();

    /* ------------- Setter / Getter-Methoden ------------ */
    /* ------------- aktuelle Seitennummer --------------- */
    /**
     * Setzt die Seitennummer.
     * @param pageNumber	int		Nummer
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    /**
     * Liefert die aktuelle Seitenzahl.
     * @return	int		Seitenzahl
     */
    public int getPageNumber() {
        return pageNumber;
    }
    
    /* ------------- Gesamtseitenzahl --------------------- */
    /**
     * Setzt die Seitenzahl, der verfügbaren Seiten.
     * @param pagesAvailable	int		Anzahl
     */
    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }
    /**
     * Liefert die Gesamtseitenzahl.
     * @return	int		Gesamtanzahl
     */
    public int getPagesAvailable() {
        return pagesAvailable;
    }
    
    /* --------------- Einträge --------------------- */
    /**
     * Setzt die Liste der Einträge.
     * @param pageItems		List<E>		Liste der Einträge
     */
    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }
    /**
     * Liefert die Liste der Einträge.
     * @return	List<E>		Eintragsliste
     */
    public List<E> getPageItems() {
        return pageItems;
    }
}