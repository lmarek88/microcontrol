var _app = _app || {};

(function () {
    var init = function () {
        $.when(
            _app.helper.getTemplate('reference'),
            _app.dataProvider.getReferences()
        ).done(function (template, data) {
            //var html = $.templates('<div>{{:name}}</div>').render({name:'fdsf'})
            var temp = $.templates['reference'];
            var html = temp.render(data)
            $('.reference-container').empty().append(html);

            $('.reference-container .preview').click(function (e) {
                let id = $(e.currentTarget).data('id');
                window.open("./api/reference/preview/" + id, "Referencja", "location=1,status=1,scrollbars=1,width=800,height=800");
            });
            $('.reference-container .download').click(function (e) {
                location.href = "./api/reference/download/" + id;
            });
        });
    }

    init();

    return _app.reference = {
        init: init
    }
})();