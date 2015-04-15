<?php
class DBmobile extends CI_Model{
function getData($pin){
	$rs=$this->db->query("SELECT * FROM MobileData WHERE pin=$pin");
	return $rs->result();
}

function inTable($pin){
	$rs=$this->db->query("SELECT * FROM MobileData WHERE pin=$pin");
	if ($rs->result()==null){
		return false;
	}
	else{
		return true;
	}
}

function putData($pi,$statu,$executed){
	if ($this->inTable($pi)){
	$rs=$this->db->query("UPDATE MobileData SET status=$statu , executed=$executed WHERE pin=$pi;");
	}
	else{
	$this->db->query("INSERT INTO MobileData VALUES ('$pi','$statu')");
	}
	$rs=$this->getData($pi);
	return $rs;
}

function setData($pin,$cmd,$val){
	if ($this->inTable($pin)){
	$rs=$this->db->query("UPDATE MobileData SET command='$cmd',value='$val',executed='0' WHERE pin=$pin;");
	}
	else{
	$this->db->query("INSERT INTO MobileData VALUES ('$pin','0','$cmd',$val,0)");
	}
	$rs=$this->getData($pin);
	return $rs;
}

}
?>