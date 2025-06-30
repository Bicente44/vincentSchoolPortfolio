<html>
<head lang="en">
        <title>Pattern</title>
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
<div style="text-align: left; padding: 40px;">
<pre style="font-family: monospace;">
<?php
//Define and declarations
$n = 10;

for ($i = 1; $i <= $n; $i++) {
	for ($j = 1; $j <= $i; $j++) {
		echo "*";
	}
	echo "\n";
}

for ($i = $n - 1; $i >= 1; $i--) {
	for ($j = 1; $j <= $i; $j++) {
		echo "*";
	}
	echo "\n";
}

?>
</pre>
</div>
<?php
include "footer.php";
?>
</body>
</html>
