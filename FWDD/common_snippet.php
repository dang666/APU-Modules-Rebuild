<?php
$db = mysqli_connect('localhost', 'root', '', 'testajax'); #sql database connection

if (isset($_POST[''])){ #if condition based on post method
}

$results = mysqli_query($db, $sql); #execute the sql statement

if(mysqli_num_rows($results)>0){ #if there is data returned
}

while ($result = mysqli_fetch_array($execQuery)){ #call mysqli_fetch_array fucntion
}
?>
