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
                        <h1 class="page-header">Editar Recurso</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <div class="panel-body">
                        <form role="form" name="formRecurso" >
                            <input type="hidden" id="idRecurso"/>

                            <div class="form-group">
                                <label for="disabledSelect">Nome</label>
                                <input class="form-control" id="designacao" type="text" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label>Nova Quantidade</label>
                                <input class="form-control" id="quantidade" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Valor Unitário (€)</label>
                                <input class="form-control" id="valorunitario" disabled>  
                            </div>
                         
                            <button type="button" class="btn btn-primary" id="okRecurso">Voltar</button>
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

 $.getJSON("/daihugo/webresources/Recurso/listarporid/"+getQueryVariable("idRecurso"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idRecurso").value= data[i].idRecurso;
       document.getElementById("designacao").value = data[i].designacao;
       document.getElementById("valorunitario").value = data[i].valorUnitario;
       document.getElementById("quantidade").value = data[i].quantidadeDisponivel;
    }
});



</script>

 <script>
                  $('#okRecurso').click(function(){            
                    history.go(-1);
                    
               });
        </script>

</body>

</html>
