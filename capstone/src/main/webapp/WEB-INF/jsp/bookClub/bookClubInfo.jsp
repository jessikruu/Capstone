<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Book Club Info</h1>
<p>${bookClubKey.clubName}</p>
<div class="container">
    <div class="row justify-content-center">

        <div class="col-auto">
            <table class="table table-responsive" style="width: 750pt">
                <tr>
                    <td style="font-weight: bolder;">Genre:</td>
                    <td>${bookClubKey.genre}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Created By:</td>
                    <td>${bookClubKey.user.email}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Created By:</td>
                    <td>${bookClubKey.user.email}</td>
                </tr>



            </table>


        </div>
    </div>
</div>



<jsp:include page="../included/footer.jsp"/>