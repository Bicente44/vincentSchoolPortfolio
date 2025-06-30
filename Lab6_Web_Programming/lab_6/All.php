<html>
<head lang="en">
        <title>All</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body class="d-flex flex-column min-vh-100">
<?php
include "header.php";
?>
<div style="text-align: center; padding: 50px;">
<?php
//Define and declarations
	for ($i = 99; $i > 0;){
	echo "<br>$i bottles of beer on the wall...<br>";
	echo "You take one down you pass it around ...<br>";
	$i--;
	echo "$i bottles of beer on the wall.<br>";
	}
?>
</div>
<?php
include "footer.php";
?>
</body>
</html>
