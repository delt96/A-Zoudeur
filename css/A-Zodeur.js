<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.7.1/gsap.min.js"></script>
function horizontalScroll(){
  let target = document.querySelector('#baesong');
  let timeline =gsap.timeline({
    scrollTrigger:{
      trigger : target,
      start: function start(){
        return "top top";
      },
      end: function end(){
        return "+=".concat(target.offsetWidth, "px");
      },
      scrub: 1, 
      pin : true,
      ease: 'none'
    }
  });
  timeline.addLabel('horizon').fromTo("#target",{
    xPercent: 0,
    x:'0'
  }, {
    xPercent: -100,
    x:'100vw',
    ease : 'none',
    delay:0.05
  }).fromTo('#target',{
    delay:0
  },{
    delay:0.01
  }, 'horizon=+0.15');
}