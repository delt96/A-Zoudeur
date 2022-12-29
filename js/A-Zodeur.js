
window.addEventListener("scroll", (e) => {
  // console.log(window.scrollY);
  const target = document.querySelector(".baesong-wrap");
  const body = document.querySelector("#bodyId")
  const trX1 =scrollY
  if(window.scrollY<2100)
  target.classList.remove("fixed");
  if (window.scrollY >= 2280) {
    target.classList.add("fixed");
    target.style.transform = `translate(-${trX1-2280}px,0px)`;
  }// 가로스크롤
    // if (window.scrollY >= 7500) {
  //   let thisScroll = document.querySelector(this).scrollTop(); 
  //   console.log("ts="+thisScroll)
  //    target.classList.remove("fixed");
  // }

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
  //고객지원 마우스 클릭
});