$(document).ready(async function(){
    const isLogin = await $.ajax('is_login');
    try{
      if(isLogin == false){
        alert("로그인이 필요합니다.");
        location.href="/A-Zodeur_loginPage.html";}
    }catch(err) {
      console.log(err)
    }
  // 로그인 안되어있으이면 로그인이동
  let member = await $.ajax("/read")
  $("#userName").append(member.userName);
  // member가져와서 이름가져오는 메소드

$(".support").hover(function(){
  $(".mail").css("display","block")
},function(){
  $(".mail").css("display", "none")
})
// 고객지원 마우스 오버
$(".support").on("click",function(){
  $("#mailCopy").select()
  document.execCommand("copy");
  $(".copyText").css("display", "block")
  setTimeout(function(){
    $(".copyText").css("display", "none")
  },1000)
})
  // 클릭시 복사
  $(".PwChange").on("click", function (){
    const nowPw = "<div>"+
        "<div>바꿀 비밀번호를 입력하세요.<div>"+
        "<br/>"+
        "<input type='password' class='form-control azodeurPw'/><br/>"+
        "<br/>"+
        "<div>비밀번호를 한 번더 입력하세요.<div>"+
        "<br/>"+
        "<input type='password' class='form-control azodeurPw2'/><br/><br/>"+
        "<button class='btn btn-outline-primary button pwChange'>변경하기</button> <button class='btn btn-outline-primary button' id='cancel'>취소하기</button>"
      "</div>"
    $(".frameBox").empty();
    $(".frameBox").append(nowPw);
  })
  $(".userInfoChange").on("click",function (){
    const userInfo = "<table>"+
      "<tr><td><span class=''>아이디 : </span></td><td><span>"+member.azodeurId+"</span></td></tr>"+
      "<tr><td><hr/></td><td><hr/></td></tr>"+
      "<tr><td><span class=''>이름 : </span></td><td><span>"+member.userName+"</span></td></tr>"+
      "<tr><td><hr/></td><td><hr/></td></tr>"+
      "<tr><td><span class=''>생년월일 : </span></td><td><input type='text' class='form-control birthday' value="+member.birthday+" size={15}></input></td></tr>"+
      "<tr><td><hr/></td><td><hr/></td></tr>"+
      "<tr><td><span class=''>이메일 : </span></td><td><input type='text' class='form-control email' value="+member.email+" size={15}></input></td> </tr>"+
      "<tr><td><hr/></td><td><hr/></td></tr>"+
      "<tr><td><span class=''>주소 : </span></td><td><input type='text' class='form-control address' value="+member.address+" size={15}></input></td> </tr>"+
      "<tr><td><hr/></td><td><hr/></td></tr>"+
      "<tr><td><button class='btn btn-outline-primary button 'id='infoChange'>수정하기</button></td><td> <button class='btn btn-outline-primary button'id='cancel'>취소하기</button></td></tr>"+
    "</table>"
    $(".frameBox").empty();
    $(".frameBox").append(userInfo);
  })
  //회원정보 변경시 보여주는 화면 출력

  $(".withdrawal").on("click" ,function (){
    const msg = "<div><h1>정말로 삭제하시겠습니까?</h1></div>" +
        "<hr/>"+
        "<div><button class='btn btn-outline-primary button' id='yes'> 예 </button>" +
        "<button class='btn btn-outline-primary button' id='cancel'> 아니오 </button> </div>"
      $(".frameBox").empty();
      $(".frameBox").append(msg);
  })
  // 회원 탈퇴를 누를 시 화면 출력

  $(".frameBox").on("click",".yes", function (){
    $.ajax({
      url : "/delete",
      method : "delete" })
      .then(()=>{
      alert("회원탈퇴가 완료되었습니다.");
      $.ajax("logout","post");
      location.href="../index.html";
      }).catch(err=> console.log(err))
  })
  // 탈퇴 누를시 이벤트
  $(".frameBox").on("click", "#cancel", function (){
    alert("취소되었습니다.")
    $(".frameBox").empty();
  })
  // cancel클릭시 취소
  $(".frameBox").on("click", "#infoChange", function (){
    const userName = member.userName
    const azodeurId = member.azodeurId
    const azodeurPw= member.azodeurPw
    const birthday = $(".birthday").val();
    const gender = member.gender
    const email = $(".email").val();
    const address = $(".address").val();
    $.ajax({
      url : "/changeInfo",
      method : "put",
      data : {userName, azodeurId, azodeurPw, birthday, gender, email, address}
    }).then(()=>{
      alert("수정되었습니다.")
      // member = $.ajax("/read");
      $(".frameBox").empty();
    }).catch(err => console.log(err));
  })
  // info바꿈
  $(".frameBox").on("click", ".pwChange", function (){
    const userName = member.userName;
    const azodeurId = member.azodeurId;
    const azodeurPw= $(".azodeurPw").val();
    const birthday = member.birthday;
    const gender = member.gender;
    const email = member.email;
    const address = member.address;
    const PwTextCheck = $(".azodeurPw2").val();
    if(azodeurPw === ""){
      alert("비밀번호가 비어있습니다.")
      return
    }
    // if(azodeurPw.length<8){
    //   alert("보안을 위해 비밀번호를 8자이상 작성해주세요.")
    //   return
    // }
    if(azodeurPw !== PwTextCheck) {
      alert("비밀번호가 같지않습니다.")
      return
    }
    $.ajax({
      url : "/changeInfo",
      method :"put",
      data : {userName, azodeurId, azodeurPw, birthday, gender, email, address}
    }).then(()=>{
      alert("수정되었습니다.")
      $(".frameBox").empty();
    }).catch(err=>console.log(err));
  })




})