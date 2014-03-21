/**
 * Blendet angezeigte Elemente aus, bzw. versteckte Elemente ein.
 * @author Ellen
 */
function toggleDisplay(elementId) {
	var element = document.getElementById(elementId);
	var currentView = element.className;
	if ( currentView == "hidden") {
		element.className = "visible";
	} else {
		element.className = "hidden";
	}
}

/**
 * Blendet das Element zur zugehörigen Id aus.
 * @author Ellen
 */
function hideElement(elementId) {
	var element = document.getElementById(elementId);
	element.className = "hidden";
}

/**
 * Blendet das Element zur zugehörigen Id aus.
 * @author Ellen
 */
function showElement(elementId) {
	var element = document.getElementById(elementId);
	element.className = "visible";
}

