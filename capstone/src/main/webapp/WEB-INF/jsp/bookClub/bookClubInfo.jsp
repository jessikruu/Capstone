<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${bookClubKey.clubName}</h1>
<div class="container">
    <div class="row justify-content-center">

        <div class="col-auto">
            <table class="table table-responsive" style="width: 500pt">
                <tr>
                    <td style="font-weight: bolder;">Genre:</td>
                    <td onclick="window.location.href = '/genres/info/${bookClubKey.genre.id}'"
                        class="clickable-row">${bookClubKey.genre.genreName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Meeting Location:</td>
                    <td onclick="window.location.href = '/meetingLocation/info/${bookClubKey.meetingLocation.id}'"
                        class="clickable-row">${bookClubKey.meetingLocation.locationName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Created By:</td>
                    <td onclick="window.location.href = '/user/profile?id=${bookClubKey.user.id}'"
                        class="clickable-row">${bookClubKey.user.username}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Description:</td>
                    <td>${bookClubKey.description}</td>
                </tr>


            </table>


        </div>
    </div>
</div>


<jsp:include page="../included/footer.jsp"/>