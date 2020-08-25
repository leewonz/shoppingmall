<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.cart-tb {
	border: 1px solid black;
}

.cart-th {
	text-align: center;
	background-color: DimGray;
	color: white
}

.cart-td {
	text-align: right;
	background-color: LightGray;
}
</style>
</head>
<body>
  <h1>장바구니 페이지</h1>
  ${name}님이 장바구니에 추가하신 상품의 목록입니다.
  <br>
  <br>
  <form action="carttest">
    <input type="submit" value="추가" />
  </form>
  <table class="cart-tb">
    <tr>
      <th class="cart-th">번호</th>
      <th class="cart-th">상품번호</th>
      <th class="cart-th">카트번호</th>
      <th class="cart-th">삭제</th>
    </tr>

    <c:forEach items="${voList}" var="vo" varStatus="status">
      <tr>
        <td class="cart-td">${status.count}</td>
        <td class="cart-td">${vo.pnum}</td>
        <td class="cart-td">${vo.cnum}</td>
        <td class="cart-td">
          <form action="cartdelete">
            <input type="hidden" name="cnum" value="${vo.cnum}" /> <input
              type="submit" value="삭제" />
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  
</body>
</html>
