// db에서 물건 받아오기
const printProduct = async function (){
    await $.ajax({
        url :"product_read",
        method : "post",
        success :function (data){
            $.each(data,function (i,p){
                const productno = `${p.productno}`;
                const product =
                    `
                    <img data-no="${p.productno}" class="product"src="${p.image}" alt="product">
                    <div class="textBox">
                      <p class="productName text">${p.productname}</p>
                      <p class="productPerfumer text">조향사 : ${p.perfumer}</p>
                    </div>
                    <div>
                      <p class="productCost text" >1개 당 가격: </br>${p.productcost}원</p>
                      <button class="btn productDec" data-no="${p.productno}">-</button>
                      <span id="${p.productno}">1</span>
                      <button class="btn productInc" data-no="${p.productno}">+</button><hr>
                      <button class="btn btn-success" id="basket" data-no="${p.productno}">장바구니</button>
                      <button class="btn btn-success" id="Buy" data-no="${p.productno}">구매하기</button>`
                if(p.category == "1"){
                    $(".imgPerfume").append(product);
                }
                else if(p.category == "2"){
                    $(".imgHandCream").append(product);
                }
                else if(p.category == "3"){
                    $(".imgEtc").append(product);
                }
            })
        }
    }).catch(err=>console.log(err))}
$(document).ready(async function (){
    printProduct();

    $(".imgPerfume").on("click",".productInc",function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        $.ajax({
            url: "quantity_read",
            method : "get",
            data : {productno},
        }).then(r=>{
            if(r<= count){
                alert("수량이 부족합니다.")
                return
            }else {
                ++count;
                $(`#${productno}`).empty();
                $(`#${productno}`).text(count);

            }
        }).catch(err=> console.log(err))
    })
    $(".imgPerfume").on("click", ".productDec", function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        if(count>1){
            --count;
            $(`#${productno}`).empty();
            $(`#${productno}`).text(count);
        }
    })
    $(".imgHandCream").on("click",".productInc",function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        $.ajax({
            url: "quantity_read",
            method : "get",
            data : {productno},
        }).then(r=>{
            if(r<= count){
                alert("수량이 부족합니다.")
                return
            }else {
                ++count;
                $(`#${productno}`).empty();
                $(`#${productno}`).text(count);

            }
        }).catch(err=> console.log(err))
    })
    $(".imgHandCream").on("click", ".productDec", function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        if(count>1){
            --count;
            $(`#${productno}`).empty();
            $(`#${productno}`).text(count);
        }
    })
    $(".imgEtc").on("click",".productInc",function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        $.ajax({
            url: "quantity_read",
            method : "get",
            data : {productno},
        }).then(r=>{
            if(r<= count){
                alert("수량이 부족합니다.")
                return
            }else {
                ++count;
                $(`#${productno}`).empty();
                $(`#${productno}`).text(count);

            }
        }).catch(err=> console.log(err))
    })
    $(".imgEtc").on("click", ".productDec", function(e){
        const productno =parseInt(e.target.dataset.no);
        let count = parseInt($(`#${productno}`).text());
        if(count>1){
            --count;
            $(`#${productno}`).empty();
            $(`#${productno}`).text(count);
        }
    })
    $(".imgPerfume").on("click", "#basket", async function (e){
        const productNum = parseInt(e.target.dataset.no);
        const count = parseInt($(`#${productNum}`).text());
        try{
            const isLogin = await $.ajax('/is_login');
            const isCart = await $.ajax({url : "/readCartsNo",method : "get", data :{productNum}})
            const cartsCount = await $.ajax("/readCount");
            console.log(cartsCount);
            if(!isLogin){
                alert("로그인이 필요합니다.");
                location.href="/A-Zodeur_loginPage.html";
                return;
            }else if(parseInt(isCart) > 0){
                alert("장바구니에 물건이 있습니다.")
                return;
            }else if(parseInt(cartsCount) > 4){
                alert("장바구니에는 5개 까지 담을 수 있습니다.")
                return;
            }else{
                $.ajax({
                    url : "/carts_save",
                    method : "post",
                    data : {count, productNum},
                }).then(()=>alert("장바구니에 담겼습니다.")).catch(err=>console.log(err))
            }
        }catch(err) {
            console.log(err)}
    })
    $(".imgHandCream").on("click", "#basket", async function (e){
        const productNum = parseInt(e.target.dataset.no);
        const count = parseInt($(`#${productNum}`).text());
        try{
            const isLogin = await $.ajax('/is_login');
            const isCart = await $.ajax({url : "/readCartsNo",method : "get", data :{productNum}})
            const cartsCount = await $.ajax("/readCount");
            console.log(cartsCount);
            if(!isLogin){
                alert("로그인이 필요합니다.");
                location.href="/A-Zodeur_loginPage.html";
                return;
            }else if(parseInt(isCart) > 0){
                alert("장바구니에 물건이 있습니다.")
                return;
            }else if(parseInt(cartsCount) > 4){
                alert("장바구니에는 5개 까지 담을 수 있습니다.")
                return;
            }else{
                $.ajax({
                    url : "/carts_save",
                    method : "post",
                    data : {count, productNum},
                }).then(()=>alert("장바구니에 담겼습니다.")).catch(err=>console.log(err))
            }
        }catch(err) {
            console.log(err)}
    })
    $(".imgEtc").on("click", "#basket", async function (e){
        const productNum = parseInt(e.target.dataset.no);
        const count = parseInt($(`#${productNum}`).text());
        try{
            const isLogin = await $.ajax('/is_login');
            const isCart = await $.ajax({url : "/readCartsNo",method : "get", data :{productNum}})
            const cartsCount = await $.ajax("/readCount");
            console.log(cartsCount);
            if(!isLogin){
                alert("로그인이 필요합니다.");
                location.href="/A-Zodeur_loginPage.html";
                return;
            }else if(parseInt(isCart) > 0){
                alert("장바구니에 물건이 있습니다.")
                return;
            }else if(parseInt(cartsCount) > 4){
                alert("장바구니에는 5개 까지 담을 수 있습니다.")
                return;
            }else{
                $.ajax({
                    url : "/carts_save",
                    method : "post",
                    data : {count, productNum},
                }).then(()=>alert("장바구니에 담겼습니다.")).catch(err=>console.log(err))
            }
        }catch(err) {
            console.log(err)}
    })

})