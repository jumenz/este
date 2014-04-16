/**
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Julia Menzel
*/

/* Toggle */
$(document).ready(function() {
    $('.toggle-item').each(function(idx, itm) {
        $(itm).find('.toggle').on('click', function() {
            $(itm).find('.content').toggle(200);
        });
    });
});


