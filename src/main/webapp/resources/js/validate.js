/**
 * Prüft, ob eine Eingabe dem geforderten Muster entspricht.
 */
function compareInput (input, pattern) {
	var ergebnis = pattern.test(string);
	window.alert("Ergebnis compareInput: " + ergebnis + "\n");
	return pattern.test(string);
}

/**
 * Prüft ob die Eingabe einem Namen entspricht.
 * Ein Name kann mehrere Wörter aus Buchstaben enthalten.
 */
function checkName ( input ) {
	var pattern = new RegExp("^[a-z A-Z]+$","ig");
	return compareInput(input, pattern);
}

/**
 * Prüft, ob die Eingabe einer Email entspricht.
 */
function checkEMail ( input ){
	var pattern = new RegExp("^[a-z]+@[a-z]+\\.[a-z]+$","ig");
	return compareInput(input, pattern);
}

/**
 * Prüft, ob eine Eingabe nicht leer ist.
 */
function isEmpty ( input ) {
	return input != "";
}

/**
 * Prüft ob eine Eingabe einem Datum der Form tt.mm.jjjj entspricht.
 */
function isDate ( input ) {
	window.alert("isDate wird aufgerufen mit: " + input + "\n");
	var pattern = new RegExp("^\d\d\.\d\d\.\d\d\d\d$","ig");
	return compareInput(input, pattern);
}

/**
 * Prüft die Eingaben zum schreiben eines neuen Berichts.
 */
function checkReport() {
	var out = "Fehlerhafte Eingaben\nFolgende Fehler sind aufgetreten:\n\n";
	var res = true;
	/* Eingaben auslesen */
	var date = document.getElementById("new_report_date").value;
	var saison = document.getElementById("new_report_saison").value;
	var matchday = document.getElementById("new_report_matchday").value;
	var report = document.getElementById("new_report_report").value;
	var opposer = document.getElementById("new_report_opposer").value;
	/* DEBUG */ window.alert("Eingaben werden geprüft\n" + date + saison + matchday + report + opposer);
	/* Fehlerausgabe anpassen */
	if ( !isDate(date)) {
		document.write("Datumsangabe ist falsch<br>");
		res = false;
		out = out + "Datumsangabe entspricht nicht der Form tt.mm.jjjj\n";
	}
	if ( isEmpty(saison) || compareInput(saison, 'Saison')) {
		document.write("Saisonangabe ist falsch<br>");
		res = false;
		out = out + "Die Saison ist nicht angegeben\n";
	}
	if ( isEmpty(matchday) || compareInput(matchday, 'Spieltag')) {
		document.write("Spieltag ist falsch<br>");
		res = false;
		out = out + "Der Spieltag ist nicht angegeben\n";
	}
	if ( isEmpty(opposer) || compareInput(opposer, 'Gegner')) {
		document.write("Gegner ist falsch<br>");
		res = false;
		out = out + "Es wurde kein Gegner genannt\n";
	}
	if ( isEmpty(report) || compareInput(report, 'Inhalt')) {
		document.write("Bericht ist falsch<br>");
		res = false;
		out = out + "Es wurde kein Bericht verfasst\n";
	}
	if ( !res ) {
		window.alert(out);
	}
	return res;
}
