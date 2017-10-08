<?php
require_once('topo.php');
?>
   <div id="page-wrapper">
            <div class="container-fluid">
                <!-- TÍTULO -->
                <div class="row">
                    <div class="col-lg-12">
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                    <!-- -->
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


                 window.onload = function(){
                      
                   $.ajax({
                        url: "/daihugo/webresources/TipoUtilizador/remover/"+ getQueryVariable("idTipoUtilizador") ,
                        method: "POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Tipo de Utilizador removido com sucesso!");
                            window.location.replace("lista_tipo_utilizador.php");
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                             alert("Não foi possível remover o tipo de Utilizador!");
                              console.log(errorThrown);
                         }
                    });
                    
               };
               
 </script>
        
</body>

</html>
