var _app = _app || {};

(function () {
    var getTemplate = function (name) {
        var deferred = $.Deferred();
        if ($.templates[name]) {
            deferred.resolve();
        } else {
            $.get('./template/' + name + '.html', null, function (data) {
                $.templates[name] = $.templates(data);
                deferred.resolve(data);
            });
        }
        return deferred.promise();
    }
    
    return _app.helper = {
      getTemplate : getTemplate  
    };
})();

