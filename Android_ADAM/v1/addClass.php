
<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){

	//Request to add a class
	if(
		isset($_POST['classname']) and 
			isset($_POST['section']) and
				!isset($_POST['delete']) 
		){
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->createClass( $_POST['classname'],
									$_POST['section']
								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "Class successfully added";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred at database please try again";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "Class already exists";						
		}
	}


	//Request to display the entries in database
	if(isset($_POST['displayClass']) )
	{
		$db = new DbOperations(); 

		$result = $db->showClasses($_POST['displayClass']);
		if($result != NULL)
		{
			$response['error'] = false;
			$response['data'] = $result;
		}
		else
		{
			$response['error'] = true;
			$response['message'] = "Nothing to show in database";
			$response['data'] = $result;
		}

	}


	//Request to remove a row
	if(
		isset($_POST['classname']) and 
			isset($_POST['section']) and 
				isset($_POST['delete']) 
		){
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->deleteClass( $_POST['classname'],
									$_POST['section'],
									$_POST['delete']
								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "Class successfully deleted";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred at database please try again";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "Class doesnot exists";						
		}elseif($result == 3){
			$response['error'] = true; 
			$response['message'] = "(Developer) Please set delete flag true";
		}
	}


}else{
	$response['error'] = true; 
	$response['message'] = "Invalid Request";
}

echo json_encode($response);
