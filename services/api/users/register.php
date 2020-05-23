<?php 
	//Headers
	header('Access-Control-Allow-Origin: *');
	header('Content-type: application/json');
	header('Access-Control-Allow-Methods: POST');
	header('Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-type,Authorization');
	header('Access-Control-Allow-Headers: Access-Control-Allow-Methods, X-Requested-With');

	include_once '../../config/Database.php';
	include_once '../../models/User.php';

	// Instantiate DB & connect
	$database = new Database();
	$db = $database->connect();

	// Instantiate User object
	$user = new User($db);

	$user->name = $_POST['name'];
	$user->email = $_POST['email'];
	$user->mobile = $_POST['mobile'];
	$user->password = $_POST['password'];

	//Register user
	if($user->register_user()) {
		print_r(json_encode(array(
			'status' => 1,
			'code' => 201
		)));
	} else {
		print_r(json_encode(array(
			'status' => 0,
			'code' => 500
		)));
	}

 ?>