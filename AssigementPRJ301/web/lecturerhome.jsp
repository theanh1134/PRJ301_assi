<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        li {
            display: inline-block;
            margin: 10px;
        }

        a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #ff6f00;
        }

        .logo {
            display: block;
            margin: 20px auto; 
            width: 200px;
            height: auto;
        }

        #updateOptions {
            display: none;
            margin: 20px auto; 
            text-align: center;
        }

        #updateOptions h2 {
            color: #333;
            text-align: center;
        }

        #updateOptions ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        #updateOptions li {
            margin: 10px;
             #updateOptions {
            display: none;
            margin: 20px auto; 
            padding: 20px; 
            background-color: #f9f9f9; 
            border: 1px solid #ddd; 
            text-align: center;
        }

        #updateOptions h2 {
            color: #333;
        }

        #updateOptions ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        #updateOptions li {
            margin: 10px 0;
        }

        #updateOptions li a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        #updateOptions li a:hover {
            color: #ff6f00;
        }
        }
    </style>
</head>
<body>
    <img class="logo" src="https://yt3.googleusercontent.com/MS0uwF-ouM_v5wQhg71Z1n6gkqi_THX_pguxhj-0H2L_nztOhcTBLbLkQt0cy9QDG8LA7LOdTw=s900-c-k-c0x00ffffff-no-rj" alt="Logo">
    <h1>Welcome, ${sessionScope.account.username}</h1>
    <ul>
        <li><a href="LecturerTimetable">Timetable</a></li>
        <li><a href="profile">Profile</a></li>  
         <li><a href="examschedule">View exam schedule</a></li>
          <li><a href="testscore">Table Test Score</a></li>  
        <li><a href="logout">Logout</a></li>
    </ul>
    
</body>

</html>
