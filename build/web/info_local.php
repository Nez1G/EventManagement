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
                        <h1 class="page-header">Informação Local</h1>
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
                                <input class="form-control" id="nome" type="text" disabled>
                            </div>
                            
                            <div class="form-group">
                                <label>Longitude</label>
                                <input class="form-control" id="longitude" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Latitude</label>
                                <input class="form-control" id="latitude" disabled>  
                            </div>
                            
                            <div class="form-group">
                                <label>Morada</label>
                                <input class="form-control" id="morada" disabled>  
                            </div>
                            
                            
                            <button type="button" class="btn btn-primary" id="okLocal">Voltar</button>
                        </form>
                    </div>
                </div>
                <!-- FIM CORPO -->
            </div>
        </div>
    </div>
    
    <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: <?php echo $longitude?>, lng: <?php echo $latitude?>};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 17,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB8Q6Jahov8JG3mb4IHY72i7XtsZi0q9QM&callback=initMap">
    </script>

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
                  $('#okLocal').click(function(){

                    history.go(-1);

      
               });
        </script>

</body>

</html>
