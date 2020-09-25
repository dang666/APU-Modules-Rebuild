<?php
  $db = mysqli_connect('localhost', 'root', '', 'testajax');
  
  if (isset($_POST['log'])){
     $username = $_POST['username'];
     $password = $_POST['password'];
     $mpassword = md5($password);
     
     $sql = "SELECT * FROM users WHERE username = '$username' and password='$mpassword'";
     $results = mysqli_query($db, $sql);
     if(mysqli_num_rows($results)>0){
        echo "success";
        }
        else{
          echo "failed";
          }
          exit();
          }
?>
