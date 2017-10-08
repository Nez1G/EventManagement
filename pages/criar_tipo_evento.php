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
                        <h1 class="page-header">Novo Tipo de Evento</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formTipoEvento">
                            
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" id="designacao">  
                            </div>
                            <button type="button" id="cancelar" class="btn btn-danger">Voltar</button>
                            <button type="button" id="criartipoevento" class="btn btn-success" onclick = "validarTipoEvento()">Criar</button>
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
                  $('#criartipoevento').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/TipoEvento/criar/".concat($('#designacao').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Novo tipo de Evento criado com sucesso!");
                            window.location.replace("criar_evento.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível criar!");
                              console.log(errorThrown);
                         }
                    });
                    
               });
               
               $('#cancelar').click(function() {
                   history.go(-1);
               });
               
        </script>
    <!-- FIM JAVASCRIPT -->

</body>

</html>
