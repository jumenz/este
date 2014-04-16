/**
	FH Wedel - Projekt Medieninformatik

	Ellen Schwartau 	- Minf9888 
	Julia Menzel 		- Minf9950
	
	@date 	2014-04-16
	@author	Julia Menzel
*/
/** Ein- oder ausblenden der Toggle-Elemente */
$(document).ready(function() {
    $('.toggle-item').each(function(idx, itm) {
        $(itm).find('.toggle').on('click', function() {
            $(itm).find('.toggle-content').toggle(200);
        });
    });
});
$(document).ready(function() {
    $('.further-toggle-item').each(function(idx, itm) {
        $(itm).find('.further-toggle').on('click', function() {
            $(itm).find('.further-toggle-content').toggle(200);
        });
    });
});