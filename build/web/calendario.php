<?php
require_once('topo.php');
?>
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <br><br>
                </div>
                
                <div class="row">
                    <div id='calendar'></div>
                </div>
            </div>
        </div>
    </div>


    <!-- JAVASCRIPT -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- CALENDARÁRIO JAVASCRIPT -->
    <script src='calendario/lib/moment.min.js'></script>
    <script src='calendario/lib/jquery.min.js'></script>
    <script src='calendario/fullcalendar.min.js'></script>
    <script src='calendario/locale/pt.js'></script>
    <script>

        $(document).ready(function(){      
                $.getJSON("/daihugo/webresources/Evento/listar",
    function (data) {

        $('#calendar').fullCalendar({  
           
            theme: true,
            header: {  
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay,listMonth'
            },
            defaultDate: '2017-02-12',
            navLinks: true, // can click day/week names to navigate views
            editable: true,
            eventLimit: true, // allow "more" link when too many events
            events: [
                {
                    title: Date.parse(data[5].dataInicio),
                    start: '2017-01-02',
                    backgroundColor: '#ff0000'
                    
                },
               
            ]
      
        });
        
        });
        });

    </script>

    <!-- FIM JAVASCRIPT -->

</body>

</html>
