var _app = _app || {};

(function () {

    var getReferences = function (callback) {
        var deferred = $.Deferred();
        $.ajax({
            method: 'GET',
            url: './api/reference',
            success: function (response) {
                deferred.resolve(response);
            },
            error: function () {
                deferred.resolve(false);
            }
        });
        return deferred.promise();
    };

    var getGallery = function (callback) {
        var deferred = $.Deferred();
        $.ajax({
            method: 'GET',
            url: './api/gallery',
            success: function (response) {
                deferred.resolve(response);
            },
            error: function () {
                deferred.resolve(false);
            }
        });
        return deferred.promise();
    };


    return _app.dataProvider = {
        getReferences: getReferences,
        getGallery: getGallery
    }
})();