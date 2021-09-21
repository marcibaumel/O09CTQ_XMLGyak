var personObject =
    {   "name":"",
        "pin":"",
        "fruit":"",
        "age":"",
        "foot":"",
        "sense":"",
};


$("#submit-id").click(function(){
    
    var name = $("#inputName").val();
    var pin = $("#inputSim").val();
    var fruit = $("#inputFruit").val();
    var age = $("#inputAge").val();
    var foot = $("#inputFoot").val();
    var sense = $("#inputSens").val();

    

    alert("Név: "+name+"\nPIN: "+pin+"\nGyümölcs: "+fruit+"\nÉletkor: "+age+"\nLábméret: "+foot+"\nÖnbizalom: "+sense);

    $("#submit-id").addClass("pressed").delay(100).queue(function(next){
    $(this).removeClass('pressed');
    next();})
    
});

function dataWriteOut(){
    
}

