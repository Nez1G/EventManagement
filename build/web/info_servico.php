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
                                <input class="form-control" id="email" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Contacto</label>
                                <input class="form-control" id="contacto" disabled>  
                            </div>
                            <button type="button" class="btn btn-primary" id="okServico">Voltar</button>
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
                  $('#okServico').click(function(){
                    history.go(-1);
                    
               });
        </script>

</body>

</html>
