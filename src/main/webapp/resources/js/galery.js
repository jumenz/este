/** Array zum speichern der Bilder, die angezeigt werden sollen. */
var pictures = new Array();
/** zurzeit angezeigtes Bild. */
var currPicture = 0;

/**
 * Initialisiert das Picture-Array.
 */
function initPictures() {											/* TODO Array über PHP füllen */
	var count = 37;
	var i = 0;
	/* wenn array noch nicht initialisiert, mit Pfaden füllen */
	if(pictures.length <= 0) {
		for (i = 0; i < count; i++) {
			pictures[i] = "../data/galery/picture" + i + ".jpg";
		}
	}
}
/* Initlialisieren ausführen */
initPictures();

/**
 * wählt das nächste Bild aus.
 */
function nextPicture() {
	if (currPicture < pictures.length) {
		currPicture++;
		showPicture();
	}
}

/** 
 * wählt das vorherige Bild zur Anzeige aus.
 */
function prevPicture() {
	if (currPicture > 0) {
		currPicture--;
		showPicture();
	}
}

/**
 * Bringt das aktuelle Bild zur Anzeige.
 */
function showPicture() {
	/* Anzeigebild */
	var imgElement = document.getElementById("galery_picture");
	imgElement.src = pictures[currPicture];
	/* Vorschaubilder */												/* TODO Indexüberprüfung */
	imgElement = document.getElementById("next_picture1");
	imgElement.src = pictures[(currPicture+1)];
	imgElement = document.getElementById("next_picture2");
	imgElement.src = pictures[(currPicture+2)];
	imgElement = document.getElementById("next_picture3");
	imgElement.src = pictures[(currPicture+3)];
}

/**
 * Slideshow Funktion initialisieren.
 */
function initSlideshow() {
	initPicture();
	slide();
}

/**
 * Schaltet die Bilder nach 2 Sekunden weiter.
 */
function slide() {
	nextPicture();
	window.setTimeout(slide, 2000);
} 

/* ------------------------------------------------------------------ */

/**
 * Zeigt das übergebene Bild in fullview an.
 */
 function fullView( src ) {
	var fullViewElement = document.getElementById("galery_preview_full_img");
	fullViewElement.src = src;
	toggleDisplay( "galery_preview--full" );
}

