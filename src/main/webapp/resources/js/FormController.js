(function($) {
	
	/** 
	 * Setzt einen Wert auf den leeren String, wenn die Defaultinstellung
	 * angegeben ist.
	 * @param	value			angegebener Wert
	 * @param	defaultValue	Defaulteinstellung
	 * @return	neuer Wert
	 */
	var clearDefault = function ($input, defaultValue) {
		var value = $input.val();
		if( value==defaultValue){ 
			$input.val(''); 
		} 
	}

	/**
	 * Setzt einen Wert auf die Defaulteinstellung, wenn der leere String
	 * angegeben ist.
	 * @param	value			angegebener Wert
	 * @param	defaultValue	Defaulteinstellung
	 * @return	neuer Wert
	 */
	var setDefault = function( $input, defaultValue ) {
		var value = $input.val();
		if( value==''){
			$input.val(defaultValue); 
		} 
	}
	
	var install = function() {
		$("input[data-default]").each(function() {
			var $input = $(this);
			var dataDefault = $input.attr('data-default');
			$input.focus(function() {
				clearDefault($input,dataDefault);
			});
			$input.blur(function() {
				setDefault($input,dataDefault);
			});
		});
	};

	$( document ).ready(install);
	
})(jQuery);