// function Explanation(){
//   console.log("변경")
//   $(".Explanation").css("display", "block")
// }
// function ExplanationOff(){
//   console.log("변경")
//   $(".Explanation").css("display", "none")
// }
  function reset () {
    $("#citrus").removeAttr("checked");
    $("#green").removeAttr("checked");
    $("#herb").removeAttr("checked");
    $("#floral").removeAttr("checked");
    $("#vanilla").removeAttr("checked");
    $("#whiteMusk").removeAttr("checked");
    $("#woody").removeAttr("checked");
    // const perfume = ["citrus", "green","herb", "floral", "vanilla", "whiteMusk", "woody" ]
    // for(let c of perfume)
    // {
    //   $(`#${c}`).removeAttr("checked")
    // }

  
}
$(document).ready(function(){
  $(".help").hover(function(){
    $(".Explanation").css("display","block")
  },function(){
    $(".Explanation").css("display", "none")
  })
  
  $(".citrus").hover(function(){
    $(".citrusText").css("display","block")
  },function(){
    $(".citrusText").css("display", "none")
  })

  $(".green").hover(function(){
    $(".greenText").css("display","block")
  },function(){
    $(".greenText").css("display", "none")
  })

  $(".whiteMusk").hover(function(){
    $(".whiteMuskText").css("display","block")
  },function(){
    $(".whiteMuskText").css("display", "none")
  })

  $(".vanilla").hover(function(){
    $(".vanillaText").css("display","block")
  },function(){
    $(".vanillaText").css("display", "none")
  })

  $(".herb").hover(function(){
    $(".herbText").css("display","block")
  },function(){
    $(".herbText").css("display", "none")
  })
  
  $(".woody").hover(function(){
    $(".woodyText").css("display","block")
  },function(){
    $(".woodyText").css("display", "none")
  })

  $(".floral").hover(function(){
    $(".floralText").css("display","block")
  },function(){
    $(".floralText").css("display", "none")
  })

  $(".selectBox img, radio").on("click",function(e){
    const alt= e.target.alt
    reset();
    $(`#${alt}`).attr("checked", true);
    // for()

  })
})