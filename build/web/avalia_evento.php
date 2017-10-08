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
                        <h1 class="page-header">Feedback</h1>
                    </div>
                </div>
                <!-- FIM TÍTULO -->
                
                <!-- CORPO -->
                <div class="row">
                     <form role="form" name="formFeedback">
                         <input type="hidden" id="idEvento"/>    
                        <div class="form-group">
                            <label>Nota</label>
                                <select class="form-control" id="nota">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                         </div>
                            
                        <div class="form-group">
                            <label>Observação</label>
                            <textarea class="form-control" rows="3" id="observacao"></textarea>
                        </div>
                            
                            <button type="button" id="cancelar" class="btn btn-danger">Voltar</button>
                            <button type="button" class="btn btn-success" id="criarFeedback">Criar</button>
                        </form>
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

 $.getJSON("/daihugo/webresources/Evento/listarPorId/"+getQueryVariable("idEvento"),
function (data) {
    for (var i = 0; i < data.length; i++) {
       document.getElementById("idEvento").value= data[i].idEvento;
    }
});



</script>

 <script>
                  $('#criarFeedback').click(function(){
//                  $.getJSON('/WebApplication2/webresources/EventService/Soma/1/2', function(data){
//                      console.log(data);
//                    $('#res').text(JSON.stringify(data))
//                  });
               
                   $.ajax({
                        url: "/daihugo/webresources/Feedback/criar/".concat($('#nota').val(),'/',$('#observacao').val(),'/',$('#idEvento').val()),
                        method:"POST",
                        data: "",
                        dataType: 'json',
                         success: function(data,status,jqXHR){
                            console.log(data);
                            alert("Evento avaliado!");
                            window.location.replace("lista_eventos.php"); 
                         },
                         error: function(jqXHR, textStatus, errorThrown){
                              alert("Não foi possível avaliar o evento!");
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