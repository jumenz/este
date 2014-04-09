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
	/** nächste Seite */
	private int nextPage;
	/** vorherige Seite */
	private int prevPage;
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
        return this.pageNumber;
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
        return this.pagesAvailable;
    }
    
    /* --------- vorherige und nachfolgende Seiten ----------*/
    /**
     * Setzt die vorherige Seitenzahl.
     * @param pageNumber	int		Nummer
     */
    public void setNextPage(int pageNumber) {
        this.nextPage = pageNumber;
    }
    /**
     * Liefert die vorherige Seitenzahl.
     * @return	int		Seitenzahl
     */
    public int getNextPage() {
        return this.nextPage;
    }
    /**
     * Setzt die nachfolgende Seitenzahl.
     * @param pageNumber	int		Nummer
     */
    public void setPrevPage(int pageNumber) {
        this.prevPage = pageNumber;
    }
    /**
     * Liefert die nachfolgende Seitenzahl.
     * @return	int		Seitenzahl
     */
    public int getPrevPage() {
        return this.prevPage;
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
        return this.pageItems;
    }
    
    /* ---------------- weitere Methoden ----------------- */
    /**
     * Berechnet die vorherige und folgende Seite der aktuellen Page.
     */
    public void initPagination() {
    	// nächste Seitenzahl berechnen oder auf Gesamtseitenzahl setzen, wenn schon
    	// auf letzter Seite
    	this.nextPage = (this.pageNumber < this.pagesAvailable) ? this.pageNumber+1 : this.pagesAvailable;
    	// vorherige Seite berechnen oder auf erste Seite setzen, wenn schon auf erster
    	this.prevPage = (this.pageNumber > 1) ? this.pageNumber-1 : 1;
    }
}