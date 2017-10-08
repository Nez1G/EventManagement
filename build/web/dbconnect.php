    <?php
    function Connect()
    {   
        $dbname = 'dai1617';
        $dbuser = 'dai1617';
        $dbpass = 'dezassete';
        $dbhost = 'mercurio.dsi.uminho.pt';
        $connect = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname) or die("Unable
to Connect to '$dbhost'");
return $connect;
    }
?>
