<?php
	require 'db_connect.php';
	$uname = $_POST['logName'];
	$upass = $_POST['logPass'];
	$log = "SELECT * FROM user_info WHERE username = '$uname' AND userpass = '$upass'";
	$res = mysqli_query($conn, $log);
	while ($row = mysqli_fetch_assoc($res)) {
			if($row)
			{
				$name = $row['name'];
				echo "Welcome ".$name;
				
			}
			else
			{
				echo "Email or password incorrect";
			}
		}
?>