var _app = _app || {};
(function () {

    var bindNavigation = function () {
        $('.navbar-brand').click(function(){
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
        $('.navbar-nav li[data-id="gallery"]').trigger('click');
    }
    
    var setActiveContent = function(id){
        $('.navbar-nav li.active').removeClass('active');
        var element = $('#' + id);
        $('.navbar-nav li[data-id="' + id + '"').addClass('active');
        $('.screen').hide();
        element.show()
    }
    
    var mainColor = $('.navbar').css('background-color');
    $('#contact').css('color', mainColor + "!important");
    

    

    return _app.main= { 
        bindNavigation: bindNavigation
    }
}());

window.onload = function () {
    _app.main.bindNavigation();    
}