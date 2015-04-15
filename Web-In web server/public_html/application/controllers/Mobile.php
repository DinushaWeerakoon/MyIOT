<?php 

class Mobile extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -  
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in 
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see http://codeigniter.com/user_guide/general/urls.html
	 */
	public function index()
	{
		$this->load->view('mobileview');
	}
	
	public function mobileupload($pin,$status,$executed)
	{ 
		$this->load->Model('DBmobile');
		$r['isall']=false;
		$r['isup']=true;
		$r['pin']=$pin;
		//$r['ip']=$this->get_client_ip();
		$r['upout'] = $this->DBmobile->putData($pin,$status,$executed);
		$this->load->view('mobileview',$r);
	}
	
	public function mobiledownload($pin)
	{
		
		$this->load->Model('DBmobile');
		//$r['ip']=$this->get_client_ip();
		$r['isall']=false;
		$r['isup']=false;
		$r['dwnout'] = $this->DBmobile->getData($pin);
		$this->load->view('mobileview',$r);
	}
	public function mobilecommand($pin,$comnd,$value)
	{
		$this->load->Model('DBmobile');
		//$r['ip']=$this->get_client_ip();
		$r['isall']=false;
		$r['isup']=true;
		$r['upout'] = $this->DBmobile->setData($pin,$comnd,$value);
		$this->load->view('mobileview',$r);
	}
	
function get_client_ip() {
    $ipaddress = '';
    if (@$_SERVER['HTTP_CLIENT_IP'])
        $ipaddress = $_SERVER['HTTP_CLIENT_IP'];
    else if(@$_SERVER['HTTP_X_FORWARDED_FOR'])
        $ipaddress = $_SERVER['HTTP_X_FORWARDED_FOR'];
    else if(@$_SERVER['HTTP_X_FORWARDED'])
        $ipaddress = $_SERVER['HTTP_X_FORWARDED'];
    else if(@$_SERVER['HTTP_FORWARDED_FOR'])
        $ipaddress = $_SERVER['HTTP_FORWARDED_FOR'];
    else if(@$_SERVER['HTTP_FORWARDED'])
        $ipaddress = $_SERVER['HTTP_FORWARDED'];
    else if(@$_SERVER['REMOTE_ADDR'])
        $ipaddress = $_SERVER['REMOTE_ADDR'];
    else
        $ipaddress = 'UNKNOWN';
	echo $ipaddress,$_SERVER['REMOTE_PORT'];
    return $ipaddress;
}
function decoder($upout){
$x=array('pin_out' => $upout[0]->pin, 'status' => $upout[0]->status,'lst_cmd' => $upout[0]->command, 'new_value' => $upout[0]->value,'executed' => $upout[0]->executed);
return $x;
}

function getAll(){

		$this->load->Model('DBmobile');
		//$r['ip']=$this->get_client_ip();
		$r['isall']=true;
		$r['isup']=false;
		$myar['pin0'] = $this->decoder($this->DBmobile->getData(0));
		$myar['pin1'] = $this->decoder($this->DBmobile->getData(1));
		$myar['pin2'] = $this->decoder($this->DBmobile->getData(2));
		$myar['pin3'] = $this->decoder($this->DBmobile->getData(3));
		$myar['pin4'] = $this->decoder($this->DBmobile->getData(4));
		$myar['pin5'] = $this->decoder($this->DBmobile->getData(5));
		$myar['pin6'] = $this->decoder($this->DBmobile->getData(6));
		$r['dwnout']=$myar;
		$this->load->view('mobileview',$r);
}

}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */