var _app = _app || {};
(function () {
    var images = [{
        url: 'http://placehold.it/300x150',
        name: 'ale'
    },
    {
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
	{
        url: 'http://placehold.it/200x150',
        name: 'photo'
    },
    {
        url: 'http://placehold.it/300x250',
        name: 'podpis'
    }
    ];

    var imagePreview = $('#image-carousel');
    imagePreview.modal('hide');
    
    
    var init = function () {
        var tempName = "thumbnail";
        $.when(
             _app.helper.getTemplate(tempName)
         ).done(function (data) {
             var temp = $.templates[tempName];
             //var html = $.templates('<div>{{:name}}</div>').render({name:'fdsf'})
             var html = temp.render({data:images})
             $('#gallery .thumbnail-conainer').append(html);
             $('.image-thumbnail').click(thumbnailClick);
         });
    }
    var thumbnailClick = function (e) {
        imagePreview.modal('show');
    }

    init();

    return _app.gallery = {
        init: init        
    }

})();