<!DOCTYPE html>
<html>

<body>

<h2>Customers</h2>
<button id="doit"> abc </button>


        <script>
                  $('#faz').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
                    var id = $("#idevento").val();
                    var est = $("#estadoe").val();
                    var desc = $("#descricaoe").val();
                    var dat = $("#datae").val();
                    var hor = $("#horae").val();
                    var idt = $("#idtipoeventoe").val();
                    var idf = $("#idfeedbacke").val();
                    var json = {"idEvento" : id, "estado" : est, "descricao" : desc, "data" : dat, "hora" : hor, "idTipoEvento" : idt, "idFeedback" : idf };
                    var ayylmao = JSON.stringify(json);

                   $.ajax({
                        url: "/daihugo/webresources/Evento/listar/",
                        type: 'GET',
                        data : ayylmao,
                         success: function(data,status,jqXHR){
                            console.log(data);
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              console.log(errorThrown);
                         }
                    });
               });
        </script>
<button id="faz">sadas</button>
</body>
</html>

