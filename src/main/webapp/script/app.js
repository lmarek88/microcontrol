var _app = _app || {};
(function () {
    var target = $('#loader');
    var opts = {
        lines: 13 // The number of lines to draw
        , length: 28 // The length of each line
        , width: 14 // The line thickness
        , radius: 42 // The radius of the inner circle
        , scale: 1 // Scales overall size of the spinner
        , corners: 1 // Corner roundness (0..1)
        , color: 'rgb(3, 60, 115)' // #rgb or #rrggbb or array of colors
        , opacity: 0.25 // Opacity of the lines
        , rotate: 0 // The rotation offset
        , direction: 1 // 1: clockwise, -1: counterclockwise
        , speed: 1 // Rounds per second
        , trail: 60 // Afterglow percentage
        , fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
        , zIndex: 2e9 // The z-index (defaults to 2000000000)
        , className: 'spinner' // The CSS class to assign to the spinner
        , top: '50%' // Top position relative to parent
        , left: '50%' // Left position relative to parent
        , shadow: false // Whether to render a shadow
        , hwaccel: false // Whether to use hardware acceleration
        , position: 'absolute' // Element positioning
    }
    var spinner = new Spinner(opts);//.spin(target.get(0));


    var bindNavigation = function () {
        $('.navbar-brand').click(function () {
            setActiveContent('main');
        });

        $('.navbar-nav li').on("click", function (e) {
//            $('.navbar-nav li.active').removeClass('active');
            var element = $(e.currentTarget);

//            element.addClass('active');
            var id = element.data("id");
            setActiveContent(id);
//            $('.screen').hide();
//            $('#' + id).show();
        });
        $('.navbar-nav li[data-id="main"]').trigger('click');
    }

    var setActiveContent = function (id) {
        $('.navbar-nav li.active').removeClass('active');
        var element = $('#' + id);
        $('.navbar-nav li[data-id="' + id + '"').addClass('active');
        $('.screen').hide();
        element.show()
    }

    var mainColor = $('.navbar').css('background-color');
    $('#contact').css('color', mainColor + "!important");


    var showSpinner = function () {
        spinner.spin(target.get(0));
    };
    
    var hideSpinner = function(){
        spinner.stop();
    }

    return _app.main = {
        bindNavigation: bindNavigation,
        showSpinner: showSpinner,
        hideSpinner: hideSpinner
    };
}());

window.onload = function () {
    _app.main.bindNavigation();
}