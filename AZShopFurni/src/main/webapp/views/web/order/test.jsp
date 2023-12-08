<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<title>test</title>
<style>
.track-line {
height: 2px !important;
background-color: #488978;
opacity: 1;
flex: 1 1 auto !important;
}

.dot {
height: 10px;
width: 10px;
margin-left: 3px;
margin-right: 3px;
margin-top: 0px;
background-color: #488978;
border-radius: 50%;
display: inline-block
}

.big-dot {
height: 25px;
width: 25px;
margin-left: 0px;
margin-right: 0px;
margin-top: 0px;
background-color: #488978;
border-radius: 50%;
display: inline-block;
}

.big-dot i {
font-size: 12px;
}

.card-stepper {
z-index: 0
}
</style>

<section class="vh-100" style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-stepper" style="border-radius: 10px;">
          <div class="card-body p-4">
            <hr class="my-4">
            <div class="d-flex flex-row justify-content-between align-items-center align-content-center">
              <span class="dot"></span>
              <hr class="flex-fill track-line"><span class="dot"></span>
              <hr class="flex-fill track-line"><span class="dot"></span>
              <hr class="flex-fill track-line"><span class="dot"></span>
              <hr class="flex-fill track-line"><span
                class="d-flex justify-content-center align-items-center big-dot dot">
                <i class="fa fa-check text-white"></i></span>
            </div>

            <div class="d-flex flex-row justify-content-between align-items-center">
              <div class="d-flex flex-column align-items-start"><span>Chờ xác nhận</span></div>
              <div class="d-flex flex-column justify-content-center"><span>Chuẩn bị hàng</span></div>
              <div class="d-flex flex-column justify-content-center align-items-center"><span>Đang giao hàng</span></div>
              <div class="d-flex flex-column align-items-center"><span>Đã giao hàng</span></div>
              <div class="d-flex flex-column align-items-end"><span>Hoàn thành đơn hàng</span></div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>