<?php


if ($isup){

$arr = array('pin_out' => $upout[0]->pin, 'status' => $upout[0]->status,'lst_cmd' => $upout[0]->command, 'new_value' => $upout[0]->value,'executed' => $upout[0]->executed);
//echo "$ip";
  echo json_encode($arr);
}
else if(!$isall){
	$arr = array('pin_out' => $dwnout[0]->pin, 'status' => $dwnout[0]->status,'lst_cmd' => $dwnout[0]->command, 'new_value' => $dwnout[0]->value,'executed' => $dwnout[0]->executed);
   
   echo "#",json_encode($arr);
   //echo "$ip";
 //echo $dwnout[0]->pin;
 //echo $dwnout[0]->status;
}
else{
echo "All",json_encode($dwnout);
}
?>