
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
  }
  // if (window.scrollY >= 7500) {
  //   let thisScroll = document.querySelector(this).scrollTop(); 
  //   console.log("ts="+thisScroll)
  //    target.classList.remove("fixed");
  // }
});