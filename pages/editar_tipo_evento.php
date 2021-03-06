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
                        <h1 class="page-header">Alterar Tipo de Evento</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formTipoEvento">
                            <input type="hidden" id="idTipoEvento">
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" id="designacao">  
                            </div>
                            <button type="button" class="btn btn-danger" id="cancelar">Voltar</button>
                            <button type="button" class="btn btn-success" id="editarTipoevento" onclick = "validarTipoEvento()">Alterar</button>
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

 $.getJSON("/daihugo/webresources/TipoEvento/listarPorId/"+getQueryVariable("idTipoEvento"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idTipoEvento").value= data[i].idTipoEvento;
       document.getElementById("designacao").value = data[i].designacao;

    }
});



</script>

 <script>
                  $('#editarTipoevento').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
                   
                   $.ajax({
                        url: "/daihugo/webresources/TipoEvento/editar/".concat($('#idTipoEvento').val(),'/',$('#designacao').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Tipo de evento alterado com sucesso!");
                            window.location.replace("lista_tipo_evento.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível alterar o tipo de evento!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#cancelar').click(function() {
                   history.go(-1)
               });
        </script>

    <!-- FIM JAVASCRIPT -->

</body>

</html>
