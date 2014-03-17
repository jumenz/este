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