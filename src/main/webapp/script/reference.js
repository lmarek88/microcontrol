var _app = _app || {};

(function () {
    var init = function(){
        $('.reference-item .preview').click(function(e){
            window.open("./reference/preview/1", "Referencja", "location=1,status=1,scrollbars=1,width=800,height=800");
        });
        $('.reference-item .download').click(function(e){
            location.href = "./reference/download/1";
        });
    }
    
    init();
    
    return _app.reference = {
        init: init        
    }
})();