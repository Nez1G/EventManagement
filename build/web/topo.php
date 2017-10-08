<?php
require_once 'confirmacao_login.php';
?>
<!DOCTYPE html>

<html lang="pt">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Administração de Eventos</title>


    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Calendário -->
    
    <link rel='stylesheet' href='calendario/lib/cupertino/jquery-ui.min.css' />
    <link href='calendario/fullcalendar.min.css' rel='stylesheet' />
    <link href='calendario/fullcalendar.print.min.css' rel='stylesheet' media='print' />
    
    <script src="js/validacoes.js" type="text/javascript"></script>
    <script src="js/date.js" type="text/javascript"></script>
    
    <!-- Estilo para o Calendário -->
    <style> 
    	#calendar {
		max-width: 900px;
		margin: 0 auto;
        margin-bottom: 20px;
	   }
        
        .selected {
    background: lightBlue
}
    </style>
    
    
</head>

<body>
    <div id="wrapper">
        
        <!-- BARRA SUPERIOR -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="dashboard.php"><img src="img/logoCam.png"></a> 
            </div>
              
            <ul class="nav navbar-top-links navbar-right">
               
                
                <!-- DEFINIÇÕES UTILIZADOR -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                            <a href="perfil.php"><i class="fa fa-user fa-fw"></i> Perfil</a> 
                        </li>
                        
                         <li>
                             <a href="criar_utilizador.php"><i class="fa fa-plus-circle"></i> Novo Utilizador</a> 
                        </li>
                        
                        <li>
                            <a href="lista_utilizadores.php"><i class="fa fa-gear fa-users"></i> Utilizadores</a>
                        </li>
                        
                        <li>
                            <a href="lista_tipo_utilizador.php"><i class="fa fa-gear fa-fw"></i> Tipos Utilizador</a>
                        </li> 

                        <li class="divider"></li>
                        
                        <li>
                            <a href="index.php?logout=1"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
                <!-- FIM DEFINIÇÕES UTILIZADOR -->
            </ul>
            <!-- FIM BARRA SUPERIOR -->
            
            <!-- MENU LATERAL -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="dashboard.php"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Eventos <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                    <li>
                                        <a href="criar_evento.php"><i class="fa fa-plus-circle"></i>  Criar Evento</a>
                                    </li>
                                 
                                    <li>
                                        <a href="lista_eventos.php"><i class="fa fa-calendar"></i>  Lista de Eventos</a>
                                    </li>
                        
                                    <li>
                                        <a href="calendario.php"><i class="fa fa-calendar"></i>  Calendário</a>
                                    </li> 
                                   
                                    
                                    <li>
                                        <a href="lista_tipo_evento.php"><i class="fa fa-list"></i> Lista Tipo de Eventos</a>
                                    </li>
                                    

                                    
                            </ul>
                        </li>
                    
                     <!--   <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Estatísticas <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="estatistica_local.php">Por Localidade</a>
                                </li>
                                
                                <li>
                                    <a href="estatistica_mes.php">Por Mês</a>
                                </li>
                            </ul>
                        </li> -->
                     
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-truck"></i> Local <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="criar_local.php"><i class="fa fa-plus-circle"></i> Criar Local</a>
                                </li>
                                
                                <li>
                                    <a href="lista_locais.php"><i class="fa fa-list"></i>  Lista de Locais</a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-truck"></i> Recursos <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="criar_recurso.php"><i class="fa fa-plus-circle"></i> Criar Recurso</a>
                                </li>
                                
                                <li>
                                    <a href="lista_recursos.php"><i class="fa fa-list"></i>  Lista de Recursos</a>
                                </li>
                            </ul>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-truck"></i> Serviços <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="criar_servico.php"><i class="fa fa-plus-circle"></i> Criar Serviço</a>
                                </li>
                                
                                <li>
                                    <a href="lista_servicos.php"><i class="fa fa-list"></i>  Lista de Serviços</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- FIM MENU LATERAL-->
        </nav>