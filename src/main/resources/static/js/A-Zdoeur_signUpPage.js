
$(document).ready(function(){
  //텍스트 확인
$(".nameText").on("blur",function(){
  const name = $(".nameText").val();
  const noneNameText = $("#noneNameText")
  if(name ===""){
    noneNameText.css("display","block");
  }
  else{
    noneNameText.css("display", "none")
  }
})
  //비밀번호 확인
$(".PwText").on("blur",function(){
  const Pw1=$(".PwText").val();
  const nonePwText =$("#nonePwText")
  if(Pw1 === ""){
    nonePwText.css("display", "block");
  }
  else{
    nonePwText.css("display","none")
  }
})
  //비밀번호 재확인
$(".PwTextCheck").on("blur", function(){
  const Pw1=$(".PwText").val();
  const Pw2=$(".PwTextCheck").val();
  const nonePwTextCheck = $("#nonePwTextCheck")
  if(Pw2 !== Pw1){
    nonePwTextCheck.css("display","block")
  }
  else {
    nonePwTextCheck.css("display", "none")
  }
})
  $(".userName").on("blur",function(){
    const userId = $(".userName").val();
    const noneId = $("#noneId")
    if(userId ===""){
      noneId.css("display","block");
    }
    else{
      noneId.css("display", "none")
    }
  })


})