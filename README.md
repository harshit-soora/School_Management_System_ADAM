# School_Management_System_ADAM

#Open a new project in Android studio and clone this project in it.

#Download Xampp Server 
  Add Android_ADAM directory into its htdocs folder
  Open phpMySQL page and import school.sql to it
  
#Now your server side to handle the request to database for android application is set

#Make appropiate changes for the URL in Connection_constants file, go with ifconfig/ipconfig and update the IP in ROOT_URL

#Any further made page should ba name as AppropiateClassName_Activity_Identifier, which page of app is it 0,1,2.. 
Else for supporting file name whatever you want

##Current Pages:

1.MainActivity-Login page

2.Home_Activity_0-Home page

3.Signup_Activity_1-Signup or register page

##Current Supporting Classes:

1.Connection_constants- Store the URL to the server where database request are handled

2.RequestHandler- Support for android.volley to handle the "StringRequest" made to server inside a single Java class

3.SharedPrefManager- Store data for the current user such that he/she don't have to login again and again,
                     this file will be more helpful once we start to find other information related to the user
                     with the help of its userID
                     
#Update the ReadMe each time you commit

#State the current edited pages and further changes to be made inside the commit


HAPPY CODING!!!
