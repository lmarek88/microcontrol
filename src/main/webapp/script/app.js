var _app = _app || {};
(function () {

    var bindNavigation = function () {
        $('.navbar-nav li').on("click", function (e) {
            $('.navbar-nav li.active').removeClass('active');
            var element = $(e.currentTarget);
            element.addClass('active');
            var id = element.data("id");
            $('.screen').hide();
            $('#' + id).show();
        });
        $('.navbar-nav li[data-id="gallery"]').trigger('click');
    }

    

    return _app.main= { 
        bindNavigation: bindNavigation
    }
}());

window.onload = function () {
    _app.main.bindNavigation();    
}