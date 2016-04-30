<?php
	$dbhost = 'localhost';
	$dbuser = 'root';
	$dbpass = '';
	$dbname = 'webappdb';
	$conn = new mysqli($dbhost, $dbuser, $dbpass,$dbname);
	if($conn->connect_error)
	{
		//die("Connection failed");
	}

?>