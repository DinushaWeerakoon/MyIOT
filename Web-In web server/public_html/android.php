<?php
  if( $_POST["name"] || $_POST["age"] )
  {
     echo "Welcome ". $_POST['name']. "<br />";
     echo "My  ". $_POST['email']. " Email.";
     exit();
  }
?>