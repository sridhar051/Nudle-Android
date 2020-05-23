<?php 
	//Headers
	header('Access-Control-Allow-Origin: *');
	header('Content-type: application/json');

	include_once '../../config/Database.php';
	include_once '../../models/User.php';

	// Instantiate DB & connect
	$database = new Database();
	$db = $database->connect();

	// Instantiate User object
	$user = new User($db);

	// User query
	$result = $user->get();
	
	// Get row count
	$num = $result->rowCount();

	// Check if any info
	if($num > 0) {
		// user array
		$user_array = array();
		$user_array = array();

		while($row = $result->fetch(PDO::FETCH_ASSOC)) {

			extract($row);
			$user_info = array(
				'name' => $name,
				'email' => $email,
				'password' => $password
			);

			// Push to "data"
			array_push($user_array['data'], $user_info);
		}

		// Turn to JSON and output
		echo json_encode($user_array);

	} else {
		// No users
		echo json_encode(
			array('message' => 'No users found')
		);
	}

?>