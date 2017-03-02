function clear1(abc){
	//abc -> clear1 실행시 변수정보를 저장한다. 
	abc.value="";
}
function id_check(){
	window.open("ahome_pop.html","아이디","width=400,height=300,left=100,top=100");
}
function addr_number(){
	window.open("ahome_address.html","우편번호","width=400,height=400,left=100,top=300");
}
function layer(){
	document.getElementById('layer').style.display="block";
}
//http://kumbange.tistory.com/79 - javasript 아이디 중복체크 영문만 입력되도록 하기