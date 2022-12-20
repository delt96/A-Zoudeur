
 // 포레스트 가로 스크롤
/* 2021-12-28 수정 [E] */


function forestHorizontalScroll() {
  var targetEl = document.querySelector('#forest');
  var timeline = gsap.timeline({
    scrollTrigger: {
      trigger: targetEl,
      start: function start() {
        return "top top";
      },
      end: function end() {
        return "+=".concat(targetEl.offsetWidth, "px");
      },
      scrub: 1,
      pin: true,
      ease: 'none'
    }
  });
  timeline.addLabel('horizon').fromTo('#forest', {
    xPercent: 0,
    x: '0'
  }, {
    xPercent: -100,
    x: '100vw',
    ease: 'none',
    delay: 0.05
  }).fromTo('#forest', {
    delay: 0
  }, {
    delay: 0.01
  }, 'horizon+=0.15');
} // 포레스트 가로스크롤 이미지 & 텍스트
function forestHorizontalImg(section) {
  section.reduce(function (acc, cur, idx) {
    var pics = "".concat(cur, " .img-box");
    ScrollTrigger.create({
      trigger: cur,
      start: function start() {
        if (idx === 3) {
          return "".concat(document.querySelector("".concat(cur)).offsetLeft - window.innerWidth / 1.8, "px"); //많이 나눌수록 앞에서 나옴
        } else {
          return "".concat(document.querySelector("".concat(cur)).offsetLeft - window.innerWidth / 20, "px"); //많이 나눌수록 앞에서 나옴
        }
      },
      onEnter: function onEnter() {
        gsap.utils.toArray(pics).forEach(function (pic) {
          ScrollTrigger.create({
            trigger: pic,
            start: function start() {
              return "+=".concat(pic.offsetLeft - window.innerWidth / 2, "px");
            },
            onEnter: function onEnter() {
              return pic.classList.add('img-hello');
            }
          });
        });
      }
    });
  }, 0);
}