<?php

	class User {

		private $conn;
		private $table = 'userdata';

		//users properties
		public $name;
		public $email;
		public $mobile;
	    public $password;

		public function __construct($db) {
			$this->conn = $db;
		}

		//GET users

		public function get_all() {

			//Create a query
			$query = 'SELECT 
				u.name,
				u.email,
				u.mobile,
				u.password
				FROM 
				' . $this->table . ' u ';

			//Prepare statement
				$stmt = $this->conn->prepare($query);

			//Execute query
				$stmt->execute();

				return $stmt;
		}

		//Get Single User Details

		public function get_single() {
			//Create a query
			$query = 'SELECT 
				u.name,
				u.email,
				u.mobile,
				u.password
			FROM 
				' . $this->table . ' u 
			WHERE 
				u.email = ?
			LIMIT 0, 1';

			// Prepare statement
			$stmt = $this->conn->prepare($query);

			//Bind name
			$stmt->bindParam(1, $this->email);

			//Execute query
			$stmt->execute();

			return $stmt;


		}

		public function register_user() {
			// Create query
			$query = 'INSERT INTO ' . 
				$this->table .'
			SET
			  name = :name,
			  email = :email,
			  mobile = :mobile,
			  password = :password';

			//Prepare statement
			$stmt = $this->conn->prepare($query);

			//Clean data
			$this->name = htmlspecialchars(strip_tags($this->name));
			$this->email = htmlspecialchars(strip_tags($this->email));
			$this->mobile = htmlspecialchars(strip_tags($this->mobile));
			$this->password = htmlspecialchars(strip_tags($this->password));

			// Bind data
			$stmt->bindParam(':name', $this->name);
			$stmt->bindParam(':email', $this->email);
			$stmt->bindParam(':mobile', $this->mobile);
		    $stmt->bindParam(':password', $this->password);

			// Execute query
			if($stmt->execute()) {
				return true;
			}	 

			// Print error if something goes wrong
			printf("Error: %s.\n", $stmt->error);

			return false;
		}

	}