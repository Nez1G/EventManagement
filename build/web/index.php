<?php
session_start();

require_once 'funcoes.php';

    
    $username = "";
    $password = "";
    
	
    if (isset($_GET['logout'])){
        unset($_SESSION['username']);
    }
    
    if (isset($_SESSION['username'])){
        redirect('dashboard.php');
    }
    
    if (isset($_POST['username'])){
        $username = $_POST['username'];
        $password = $_POST['password'];
        $valido = utilizador_valido($username, $password);               
        
        if ($valido){
            redirect('dashboard.php');
            $_SESSION['username'] = $username;
        }               
    }       
    
?>
<!DOCTYPE html>
<html lang="pt">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Gestão Eventos v1.0</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src="js/login.js" type="text/javascript"></script>
</head>

<body>
    
    <div class="container">
        <div class="row">
             <!-- img src="img/logo.jpg" alt="logo" --> 
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form method="post" name="frmLogin">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" type="text" id="username" name="username" value="<?= $username ?>" placeholder=" Username" />
                                </div>
                                <div class="form-group">
                                        <input class="form-control" type="password" id="password" name="password" placeholder=" Password"/>
                                        <?php
                                            if (isset($valido) && !$valido){
                                                echo"<script language='javascript' type='text/javascript'>alert('Login e/ou senha incorretos');window.location.href='index.php';</script>";
                                            }                
                                        ?>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="button" class="btn btn-lg btn-success btn-block" onclick="validar()" id="autenticar" name="autenticar" value="Autenticar">
                            </fieldset>
                        </form>
                    </div>
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
    
    <!-- FIM JAVASCRIPT -->
    
</body>

</html>
