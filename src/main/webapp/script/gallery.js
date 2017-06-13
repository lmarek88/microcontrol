var _app = _app || {};
(function () {
    var images = [];    
    var imagePreview = $('#image-carousel');
    imagePreview.modal('hide');
    var loadedCarouselTemplate = false;
    
    
    var init = function () {
        var tempName = "gallery";
        $.when(
             _app.helper.getTemplate(tempName),
             _app.dataProvider.getGallery(),
             _app.helper.getTemplate("thumbnail"),
             _app.helper.getTemplate("carousel-item")
         ).done(function (template, data) {
             images = data;
             var temp = $.templates[tempName];             
             var html = temp.render(data)
             $('#gallery .thumbnail-conainer').append(html);
             $('.image-thumbnail').click(thumbnailClick);
         });
    }
    var thumbnailClick = function (e) {
        var imageId = $(this).data("image");
        if(!loadedCarouselTemplate){
            loadedCarouselTemplate = true;
            var carouselItemTemplate = $.templates["carousel-item"];
            var html = carouselItemTemplate.render(images);
            $('.carousel-inner').empty().append(html);
            $('#modalCarousel').carousel({inerval: false});

        }
        $('.carousel-inner .item').removeClass("active");
        $('.carousel-inner .item[data-image="' + imageId + '"]').addClass('active');
        imagePreview.modal('show');
    }

    init();

    return _app.gallery = {
        init: init        
    }

})();