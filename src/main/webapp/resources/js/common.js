/** 
 * Setzt einen Wert auf den leeren String, wenn die Defaultinstellung
 * angegeben ist.
 * @param	value			angegebener Wert
 * @param	defaultValue	Defaulteinstellung
 * @return	neuer Wert
 */
function clearDefault(value, defaultValue) {
	if( value==defaultValue){ 
		return ''; 
	} else {
		return value;
	}
}

/**
 * Setzt einen Wert auf die Defaulteinstellung, wenn der leere String
 * angegeben ist.
 * @param	value			angegebener Wert
 * @param	defaultValue	Defaulteinstellung
 * @return	neuer Wert
 */
function setDefault( value, defaultValue ) {
	if( value==''){
		return defaultValue;
	} else {
		return value;
	}
}
