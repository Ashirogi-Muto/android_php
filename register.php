<?php
	
	require 'db_connect.php';
	$name = $_POST['user'];
	$uname = $_POST['username'];
	$upass = $_POST['userpass'];
	$query = "INSERT INTO user_info (name,username,userpass) values('$name','$uname','$upass')";
	$res = mysqli_query($conn,$query);
	if($res)
	{
		//echo "Done";
	}
	else
	{
		//die(mysqli_error($conn));
	}

?>