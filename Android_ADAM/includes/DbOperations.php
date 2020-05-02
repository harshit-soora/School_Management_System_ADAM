<?php 

	class DbOperations{

		private $con; 

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}

		
		//Register related queries
		public function createUser($username, $pass, $email){
			if($this->isUserExist($username,$email)){
				return 0; 
			}else{
				$password = md5($pass);
				$stmt = $this->con->prepare("INSERT INTO `users` (`id`, `username`, `password`, `email`) VALUES (NULL, ?, ?, ?);");
				$stmt->bind_param("sss",$username,$password,$email);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		private function isUserExist($username, $email){
			$stmt = $this->con->prepare("SELECT id FROM users WHERE username = ? OR email = ?");
			$stmt->bind_param("ss", $username, $email);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}


		//User Login related queries
		public function userLogin($username, $pass){
			$password = md5($pass);
			$stmt = $this->con->prepare("SELECT id FROM users WHERE username = ? AND password = ?");
			$stmt->bind_param("ss",$username,$password);
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

		public function getUserByUsername($username){
			$stmt = $this->con->prepare("SELECT * FROM users WHERE username = ?");
			$stmt->bind_param("s",$username);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}


		//Class related queries
		public function createClass($class, $section){
			if($this->isClassExist($class, $section)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `class` (`cid`, `cname`, `csec`) VALUES (NULL, ?, ?);");
				$stmt->bind_param("ss",$class,$section);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		public function showClasses($display){
			if($display == 'true'){
				$stmt = $this->con->prepare("SELECT cname as Class , csec as Section FROM class");
				$stmt->execute();
				$result = $stmt->get_result();
				$result_array = array();
				$result_array["length"] = $result->num_rows;
				$i = 1;
				while($data = $result->fetch_assoc())
				{
					$result_array[$i] = $data;
					$i = $i + 1;
				}
				return $result_array;
			}
			else{
				return NULL;
			}
		}


		public function deleteClass($class, $section, $del)
		{
			if($del == true)
			{
				if($this->isClassExist($class, $section))
				{
					$stmt = $this->con->prepare("DELETE FROM class WHERE cname = ? AND csec = ?");
					$stmt->bind_param("ss",$class,$section);

					if($stmt->execute()){
						return 1; 
					}else{
						return 2; 
					}
				}else{
					return 0; 
				}
			}
			else
			{
				return 3;
			}
		}

		private function isClassExist($class, $section){
			$stmt = $this->con->prepare("SELECT cid FROM class WHERE cname = ? AND csec = ?");
			$stmt->bind_param("ss", $class, $section);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}




		//Subject related queries
		public function createSubject($subjectname, $subjectTeacher){
			if($this->isSubjectExist($subjectname, $subjectTeacher)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `subject` (`sid`, `sname`, `steacher`) VALUES (NULL, ?, ?);");
				$stmt->bind_param("ss",$subjectname,$subjectTeacher);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		public function showSubjects($display){
			if($display == 'true'){
				$stmt = $this->con->prepare("SELECT sname as Subject , steacher as Teacher FROM subject");
				$stmt->execute();
				$result = $stmt->get_result();

				if($result->num_rows >0)
				{
					$result_array = array();
					$result_array["length"] = $result->num_rows;

					$i = 1;
					while($data = $result->fetch_assoc())
					{
						$result_array[$i] = $data;
						$i = $i + 1;
					}
					return $result_array;
				}
				else
				{
					return NULL;
				}
			}
			else{
				return NULL;
			}
		}

		public function deleteSubject($subjectname, $subjectTeacher, $del)
		{
			if($del == "true")
			{
				if($this->isSubjectExist($subjectname, $subjectTeacher))
				{
					$stmt = $this->con->prepare("DELETE FROM `subject` WHERE sname = ? AND steacher = ?");
					$stmt->bind_param("ss",$subjectname,$subjectTeacher);

					if($stmt->execute()){
						return 1; 
					}else{
						return 2; 
					}
				}else{
					return 0; 
				}
			}
			else
			{
				return 3;
			}
			
		}

		private function isSubjectExist($subjectname, $subjectTeacher){
			$stmt = $this->con->prepare("SELECT sid FROM subject WHERE sname = ? AND steacher = ?");
			$stmt->bind_param("ss", $subjectname, $subjectTeacher);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

	}