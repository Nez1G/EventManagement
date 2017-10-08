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
                        <h1 class="page-header">Editar Serviço</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formServico" >
                            <input type="hidden" id="idServico"/>
                            <div class="form-group">
                                <label for="disabledSelect">Nome</label>
                                <input class="form-control" id="disabledInput" type="text" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label>E-mail</label>
                                <input class="form-control" id="email">  
                            </div>
                            
                            <div class="form-group">
                                <label>Contacto</label>
                                <input class="form-control" id="contacto">  
                            </div>
                            <button type="button" class="btn btn-danger" id="cancelar">Voltar</button>
                            <button type="button" class="btn btn-success" id="editarServico" onclick = "validarServico()">Alterar</button>
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

 $.getJSON("/daihugo/webresources/Servico/listarporid/"+getQueryVariable("idServico"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idServico").value= data[i].idServico;
       document.getElementById("disabledInput").value = data[i].nome;
       document.getElementById("email").value = data[i].email;
       document.getElementById("contacto").value = data[i].contacto;

    }
});



</script>

 <script>
                  $('#editarServico').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
                   
                   $.ajax({
                        url: "/daihugo/webresources/Servico/editar/".concat($('#idServico').val(),'/',$('#disabledInput').val(),'/',$('#email').val(),'/',$('#contacto').val()),
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Serviço alterado com sucesso!");
                            window.location.replace("lista_servicos.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível alterar o serviço!");
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
