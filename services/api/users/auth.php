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

	// Get email
	$user->email = isset($_GET['email']) ? $_GET['email'] : die();

	// Get user
	$result = $user->get_single();

	$num = $result->rowCount();

	if($num > 0) {

	$row = $result->fetch(PDO::FETCH_ASSOC);

			//Set properties 
			$user->name = $row['name'];
			$user->email = $row['email'];
			$user->mobile = $row['mobile'];
			$user->password = $row['password'];

	// Create array
	
		$status = 1;
		$code = 200;
		$body = array('name' => $user->name, 
					  'email' => $user->email,
					  'mobile' => $user->mobile,
					  'password' => $user->password);
	} else {
		$status = 0;
		$code = 401;
		$body = null;
	}

	$user_array = array(
		'status' => $status,
		'code' => $code,
		'result' => $body
    );

    	
	//Make JSON
	print_r(json_encode($user_array));

?>



