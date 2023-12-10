<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<style>
	
section{
    padding: 60px 0;
}
#height_reset{
    height: 0;
}

.text_center{
    text-align: center;
}
.container{
    display: flex;
}

.model_left {
    width: 50%;
    position: relative;
}
.title_model_left{
    position: absolute;
    top: 2%;
    left: 3%;
}

.model_right {
    width: 50%;
    margin-left: 5%;
}
.model_right img{
    width: 40%;
}
.model_right h4{
    width: 87%;
    margin: auto;
    margin-bottom: 15px;
}
.model_left img{
    width: 100%;
}


.item_space{
    display: flex;
    justify-content: space-evenly;

}

.item_bottom{
    margin-top: 6%;
}

.text_left{
    width: 35%;
}
.text_left p {
    line-height: 2;
}
.text_right{
    width: 35%;
    text-align: justify;
}
.text_right p {
    line-height: 1.5;
}

.concept_text .container{
    display: flex;
    justify-content: space-evenly;
}
.concept_img .container h5{
   margin-top: 15px;
   display: block;
}
.img_left {
    width: 50%;
    height: 400px;
    cursor: pointer;
    overflow: hidden;
 
   
    
}
.img_left img{
    transition: all ease-in-out 0.5s;
}
.img_left:hover img{
    transform: scale(1.1);
   
   
}
.img_right{
    width: 50%;
    height: 400px;
    cursor: pointer;
    overflow: hidden;
   
}
.img_right img{
    transition: all ease-in-out 0.5s;
}
.img_right:hover img{
    transform: scale(1.1);
}
   

.concept_img .container{
    display: flex;
    justify-content: space-evenly;
    gap: 50px;
}
.concept_img img{
    width: 100%;
    display: block;
    margin: auto;
    height: 100%;
}



.width_50{
    width: 50%;
}
.width_100{
    width: 100%;
}

.width_25{

    width: 25%;
}

.width_30{
    width: 30%;
}
.width_70{
    width: 60%;
}


.bottom_item_img
{
    display: flex;
    gap: 2px;
}


.relative{
    position: relative;
}

.absolute{
    position: absolute;
    bottom: 2%;
    left: 3%;
    display: block;
    color: white;
}

.height_100{
    height: 100%;
}
.home_decoration{
    display: flex;
    gap: 2px;
}
.top_item{
    margin-bottom: 2px;
}.about_us .container{
    display: flex;
    justify-content: space-between;
}
.about_us .container p{
    line-height: 1.5;
    text-align: justify;
}

#style_slider{
    display: flex;
    gap: 10px;
}





.item_top img:hover {
    transform: scale(1.08);
  
    cursor: pointer;
}
.item_top img{
    transition: all ease 0.5s;
}
.item_bottom img:hover {
    transform: scale(1.08);
  
    cursor: pointer;
}
.item_bottom img{
    transition: all ease 0.5s;
}


#opacity{
    opacity: 0.6;
    cursor: pointer;
    
}

#opacity:hover{
    opacity: 1;
}
</style>
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.green.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <div id="carouselExampleDark" class="carousel carousel-dark slide">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="10000">
            <img src="https://theme.hstatic.net/1000280685/1000722794/14/img_slider_1.jpg?v=1313" class="d-block w-100" alt="...">
            
            <div class="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
          <div class="carousel-item" data-bs-interval="2000">
            <img src="https://theme.hstatic.net/1000280685/1000722794/14/img_slider_4.jpg?v=1313" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Some representative placeholder content for the second slide.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://theme.hstatic.net/1000280685/1000722794/14/img_slider_5.jpg?v=1313" class="d-block w-100" alt="...">
           
            <div class="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Some representative placeholder content for the third slide.</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>

      <section class="list_product" >
        <div class="container">
            <div class="model_left">
                <img src="https://file.hstatic.net/1000280685/file/launchingg--8_377f5834bf4344db994dd68b4d6fb6b6_grande.jpg" alt="">
               <h3 class="title_model_left" >  Sắc trắng <br>cho mỗi cá tính</h3>
            </div>
            <div class="model_right">
                <h4>Danh mục sản phẩm</h4>
                <div class="item_top item_space">
                    <img src="https://file.hstatic.net/1000280685/collection/chauhope__7__880dce60f6734cdba4ad0d16f4414c60.jpg" alt="">
                    <img src="https://file.hstatic.net/1000280685/collection/a011_01_98adf64f2d57418fa681c6ab8b0c5f39.jpg" alt="">
                </div>
                <div class="item_bottom item_space ">
                    <img src="https://file.hstatic.net/1000280685/collection/trangden_chanden_ban-lam-viec-h_2_aa8985d0584e439ca78528bc0216b12e.png" alt="">
                    <img src="https://file.hstatic.net/1000280685/collection/xanh_2_68b19a732ac341a0917ec13c996d57e0_master_b3c4d9a9bbb842d89e52aa725e2666ca.png" alt="">
                </div>


            </div>
        </div>
      </section>

      <section class="concept_text" >
        <div class="container">
            <div class="text_left">
                <h3 class="text_center" > Giải pháp nỗi bật toàn diện</h3>
                <p>Nguyễn Thị Minh Hà (23 tuổi) sinh ra trong một gia đình ở Đăk Nông có bố mẹ đều làm nông và đã già yếu. Bố em bị bệnh gout, thoái hóa xương và tràn dịch khớp còn mẹ cũng bị viêm đa khớp, thoái hóa cột sống và gai gót nặng nhưng không có điều kiện để chạy chữa. <br>  Đau lòng hơn, Hà có một em trai út đã không may qua đời và một em trai khác còn...</p>
            </div>
            <div class="text_right  ">
                <h3 class="text_center" >TRẢI NGHIỆM KHÔNG GIAN SỐNG MỚI CÙNG M-CONCEPT</h3>
                <P class="text_center" >TIẾT KIỆM THỜI GIAN <br> TỐI ƯU HÓA NGÂN SÁCH <br> ĐỊNH HÌNH THẨM MỸ CAO </P>
            </div>
        </div>
      </section>

      <section class="concept_img " >
        <div class="container">
            <div class="img_left  ">
                <img src="https://file.hstatic.net/1000280685/article/05_delux_606ea9a8e4db4b30bae9ac9fed9e2e8e.png" alt="">
               <h5>sản phẩm bán chạy</h5>

            </div>
            <div class="img_right">
                <img src="https://file.hstatic.net/1000280685/article/1.khach__32d5edc7f81f449f8d828e4da32f2e92.jpg" alt="">
               <h5> Độc lạ concept</h5>

            </div>
        </div>
      </section>
      <section class="home_decoration" >
        <div class="img_home_left width_50 ">
            <div class="top_item  ">
                <div class="top_item_img relative ">
                    <img class="width_100 " id="opacity" src="https://theme.hstatic.net/1000280685/1000722794/14/img_banner_5_1.jpg?v=1313" alt="">
                    <p class="absolute" > Home</p>
                </div>
            </div>
            <div class="bottom_item_img">

                <div class="bottom_item_img_left relative ">
                    <img class="width_100" id="opacity" src="https://theme.hstatic.net/1000280685/1000722794/14/img_banner_5_2.jpg?v=1313" alt="">
                    <p class="absolute" > Home</p>
                </div>
                <div class="bottom_item_img_right relative ">
                    <img class="width_100"  id="opacity"  src="https://theme.hstatic.net/1000280685/1000722794/14/img_banner_5_3.jpg?v=1313" alt="">
                    <p class="absolute" > Home</p>
                </div>
                
            </div>

        </div>  

        <div class="img_home_right relative width_50 ">
            <img class="height_100 width_100"  id="opacity"  src="https://theme.hstatic.net/1000280685/1000722794/14/img_banner_5_4.jpg?v=1313" alt="">
            <p class="absolute" > All about <br> inspriration in <br> home decoration ...</p>
            
        </div>
      </section>


      <section class="about_us" >
        <div class="container">
            <div class="text width_30">
                <h4 class="title" >
                    ABOUT US
                </h4>
                <p>Tại MAKE MY HOME, tất cả sản phẩm trang trí nội thất & giải pháp không gian sống không chỉ đơn thuần tuân thủ theo ngôn ngữ giản lược của Minimalism, mà còn cân bằng được tính năng và độ thẩm mỹ cần có. <br> <br>

                    “Ít tức là nhiều", nhưng mỗi chi tiết xuất hiện trên thiết kế đều là một sự chăm chút kỹ lưỡng và hoàn hảo. Và đó cũng chính là tôn chỉ hoạt động của MAKE MY HOME. Với tinh thần cầu tiến luôn cố gắng hết mình để cung cấp những sản phẩm chất lượng cộng với dịch vụ thân thiện cho khách hàng, chúng tôi hy vọng có thể chia sẻ một niềm tin cố hữu với tất cả mọi người: “Cuộc sống sẽ trở nên tốt đẹp hơn khi không gian sống được quan tâm và đầu tư đúng mực.</p>
            </div>

            <div class="img width_70 ">
                 <img class="width_100" src="https://theme.hstatic.net/1000280685/1000722794/14/img_Aboutus_title.jpg?v=1313" alt="">
            </div>
        </div>
        
    </section>
    
<section class="product">
	<h2 class="product-category">sản phẩm bán chạy</h2>
	<button class="pre-btn">
		<img src="images/arrow.png" alt="">
	</button>
	<button class="nxt-btn">
		<img src="images/arrow.png" alt="">
	</button>
	<div class="product-container">
		<c:forEach var="i" items="${list}">
			<div class="product-card">
				<input type="hidden" name="itemID" value="${i.get(1)}"> <input
					type="hidden" name="productID" value="${i.get(0)}">
				<div class="product-image">
					<img src="${i.get(6)}" class="product-thumb" alt="">
				</div>
				<div class="product-info">
					<h2 class="product-brand">${i.get(2)}</h2>
					<p class="product-short-description">${i.get(3)}</p>

					<c:if test="${i.get(5) != 0}">
						<span class="price"> <fmt:formatNumber type="currency"
								value="${i.get(5)}" currencyCode="VND" pattern="#,##0 VND"
								var="formattedOriginalPrice" />${formattedOriginalPrice}
						</span>
						<span class="actual-price"> <fmt:formatNumber
								type="currency" value="${i.get(4)}" currencyCode="VND"
								pattern="#,##0 VND" var="formattedOriginalPrice" />${formattedOriginalPrice}
							${i.get(4)}
						</span>
					</c:if>
					<c:if test="${i.get(5) == 0}">
						<span class="price"> <fmt:formatNumber type="currency"
								value="${i.get(4)}" currencyCode="VND" pattern="#,##0 VND"
								var="formattedOriginalPrice" />${formattedOriginalPrice}
						</span>
					</c:if>

				</div>
			</div>
		</c:forEach>
	</div>
</section>
          <!-- edit slider -->
      
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" > </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
     <script>
     const productContainers = [...document.querySelectorAll('.product-container')];
     const nxtBtn = [...document.querySelectorAll('.nxt-btn')];
     const preBtn = [...document.querySelectorAll('.pre-btn')];

     productContainers.forEach((item, i) => {
         let containerDimensions = item.getBoundingClientRect();
         let containerWidth = containerDimensions.width;

         nxtBtn[i].addEventListener('click', () => {
             item.scrollLeft += containerWidth;
         })

         preBtn[i].addEventListener('click', () => {
             item.scrollLeft -= containerWidth;
         })
     })
     </script>
     <script >
     $('.owl-carousel').owlCarousel({
    	    loop:true,
    	    margin:10,
    	    nav:true,
    	    responsive:{
    	        0:{
    	            items:1
    	        },
    	        600:{
    	            items:3
    	        },
    	        1000:{
    	            items:5
    	        }
    	    }
    	})
     </script>