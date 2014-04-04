/**
 * Author: julia
 * Date: 09.10.13
 */

/* Toggle */
$(document).ready(function() {
    $('.toggle-item').each(function(idx, itm) {
        $(itm).find('.toggle').on('click', function() {
            $(itm).find('.content').toggle(200);
        });
    });
});


