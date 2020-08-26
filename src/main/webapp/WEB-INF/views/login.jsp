<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/shop/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/shop/resources/css/shop-homepage.css" rel="stylesheet">
</head>
<body>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/shop/">multi campus</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarResponsive" aria-controls="navbarResponsive"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a class="nav-link" href="">Home
              <span class="sr-only">(current)</span>
          </a></li>
          <li class="nav-item"><a class="nav-link" href="/shop/login">Login</a></li>
          <li class="nav-item"><a class="nav-link" href="/shop/mypage">My page</a>
          <li class="nav-item"><a class="nav-link" href="/shop/signup">SignUp</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<center>
<h1>로그인</h1>
<hr/>

<form action="login.do" method="post">

<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="memberid" value=""/></td>
		
	
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type="password" name="password" value=""/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인"/>
		</td>
	</tr>
</table>
</form>

</center>
  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Multi Campus 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="/shop/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/shop/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>

