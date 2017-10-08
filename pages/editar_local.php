<?php
require_once('topo.php');
?>
<style>
h1{
    color: #337ab7;
}
</style>
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- TÍTULO -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Editar Local</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formLocal" >
                            <input type="hidden" id="idLocal"/>
                            <div class="form-group">
                                <label for="disabledSelect">Nome</label>
                                <input class="form-control" id="nome" type="text">
                            </div>
                            
                            <div class="form-group">
                                <label>Longitude</label>
                                <input class="form-control" id="longitude">  
                            </div>
                            
                            <div class="form-group">
                                <label>Latitude</label>
                                <input class="form-control" id="latitude">  
                            </div>
                            
                            <div class="form-group">
                                <label>Morada</label>
                                <input class="form-control" id="morada">  
                            </div>
                            
                            <button type="button" class="btn btn-danger" id="cancelar">Voltar</button>
                            <button type="button" class="btn btn-success" id="editarLocal" onclick="validarLocal()">Alterar</button>
                        </form>
                    </div>
                </div>
                <!-- FIM CORPO -->
            </div>
        </div>
    </div>

    <!-- JAVASCRIPT -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

    <!-- FIM JAVASCRIPT -->
    
           <script>
        
 function getQueryVariable(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if (pair[0] == variable) {
      return pair[1];
    }
  } 
  alert('Query Variable ' + variable + ' not found');
}

 $.getJSON("/daihugo/webresources/Local/listarPorId/"+getQueryVariable("idLocal"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idLocal").value= data[i].idLocal;
       document.getElementById("nome").value = data[i].nome;
       document.getElementById("latitude").value = data[i].coordenadaX;
       document.getElementById("longitude").value = data[i].coordenadaY;
       document.getElementById("morada").value = data[i].morada;
       

    }
});



</script>

 <script>
                  $('#editarLocal').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
                   
                   $.ajax({
                        url: "/daihugo/webresources/Local/editar/".concat($('#idLocal').val(),'/',$('#nome').val(),'/',$('#longitude').val(),'/',$('#latitude').val(),'/',$('#morada').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Local alterado com sucesso!");
                            window.location.replace("lista_locais.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível alterar o Local!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#cancelar').click(function() {
                   history.go(-1)
               });
        </script>

</body>

</html>
