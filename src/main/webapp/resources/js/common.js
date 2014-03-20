/**
 * Lässt den Header mitscrollen  
 */
$(function (){
	$(window).scroll(function (){
		var header = $('.header');
		var top = header.offset().top;
		if ($(this).scrollTop() > header.position().top){
			/* TODO css dafür setzen */
			//header.css('position','fixed');
			//header.css('top','0');
			//header.css('left','0');
		}
	});
})(jQuery);

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
