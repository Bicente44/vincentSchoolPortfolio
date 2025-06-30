<html>
<head lang="en">
        <title>Random</title>
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
<div style="text-align: center; padding: 20px;">
<?php
//Define and declarations
$range1 = 0;
$range2 = 0;
$range3 = 0;
$range4 = 0;
$range5 = 0;

for ($i = 0; $i < 500; $i++) {
	$num = rand(1,50);
	if ($num <= 10) $range1++;
	else if ($num <= 20) $range2++;
	else if ($num <= 30) $range3++;
	else if ($num <= 40) $range4++;
	else $range5++;
}
echo "Given 500 values from 1-50<br>";
echo "$range1 numbers are randomly generated in the range between 01 - 10<br>";
echo "$range2 numbers are randomly generated in the range between 11 - 20<br>";
echo "$range3 numbers are randomly generated in the range between 21 - 30<br>";
echo "$range4 numbers are randomly generated in the range between 31 - 40<br>";
echo "$range5 numbers are randomly generated in the range between 41 - 50<br><br>";

function Stars($c) {
	$percentage = ($c * 100) / 500;
	for ($i = 0; $i < round($percentage); $i++) {
		echo "*";
	}
	echo "<br>";
}
echo "Histogram of stars as a percentage of the number of values are displayed below<br>";
echo "01 - 10: "; Stars($range1);
echo "11 - 20: "; Stars($range2);
echo "21 - 30: "; Stars($range3);
echo "31 - 40: "; Stars($range4);
echo "41 - 50: "; Stars($range5);

?>
</div>
<?php
include "footer.php";
?>
</body>
</html>
