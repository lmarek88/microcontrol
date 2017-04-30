var _app = _app || {};
(function () {
    var bindNavigation = function () {
        $('.navbar-brand').click(function () {
            setActivePage('main');
        });

        $('.navbar-nav li').on("click", function (e) {
            var element = $(e.currentTarget);            
            var id = element.data("id");
            setActivePage(id);
        });
        //$('.navbar-nav li[data-id="references"]').trigger('click');
    }

    var setActivePage = function (id) {
        $('.navbar-nav li.active').removeClass('active');
        var element = $('#' + id);
        $('.navbar-nav li[data-id="' + id + '"').addClass('active');
        $('.screen').hide();
        element.show()}    

    return _app.main = {
        bindNavigation: bindNavigation,
        
    };
})();

window.onload = function () {
    _app.main.bindNavigation();
}