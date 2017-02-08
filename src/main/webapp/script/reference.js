var _app = _app || {};

(function () {
    var init = function(){
        $('.reference-item .preview').click(function(e){
            alert('a');
        });
        
        $('.reference-item .download').click(function(e){
            alert('d');
        });
    }
    
    init();
    
    return _app.reference = {
        init: init        
    }

}());