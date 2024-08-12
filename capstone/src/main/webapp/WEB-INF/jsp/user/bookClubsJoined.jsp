<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${userKey.username}'s Current Bookclubs! (${clubMembers.size()})</h1>



<div class="container">
    <div class="row justify-content-center">
        <div class="col-auto">
            <table class="table table-responsive">
                <!-- Header Row -->
                <tr>
                    <th>Name</th>
                    <th>Genre</th>
                    <th>Meeting Location</th>
                    <th>Created By</th>
                    <th>Description</th>
                </tr>

                <!-- Iterate Over Each BookClub -->
                <c:forEach var="bookClub" items="${bookClubDetails}">
                    <tr>
                        <td>${bookClub.clubName}</td>
                        <td onclick="window.location.href = '/genres/info/${bookClub.genre.id}'" class="clickable-row">${bookClub.genre.genreName}</td>
                        <td onclick="window.location.href = '/meetingLocation/info/${bookClub.meetingLocation.id}'" class="clickable-row">${bookClub.meetingLocation.locationName}</td>
                        <td onclick="window.location.href = '/user/profile?id=${bookClub.user.id}'" class="clickable-row">${bookClub.user.username}</td>
                        <td>${bookClub.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>












<%--<div class="container">--%>
<%--    <div class="row justify-content-center">--%>

<%--        <div class="col-auto">--%>
<%--            <table class="table table-responsive" style="width: 500pt">--%>
<%--                <tr>--%>
<%--                    <td style="font-weight: bolder;">Name:</td>--%>
<%--                    <td onclick="window.location.href = '/genres/info/${bookClubInfo.clubName}'"--%>
<%--                        class="clickable-row">${bookClubInfo.clubName}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td style="font-weight: bolder;">Genre:</td>--%>
<%--                    <td onclick="window.location.href = '/genres/info/${bookClubInfo.genre.id}'"--%>
<%--                        class="clickable-row">${bookClubInfo.genre.genreName}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td style="font-weight: bolder;">Meeting Location:</td>--%>
<%--                    <td onclick="window.location.href = '/meetingLocation/info/${bookClubInfo.meetingLocation.id}'"--%>
<%--                        class="clickable-row">${bookClubInfo.meetingLocation.locationName}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td style="font-weight: bolder;">Created By:</td>--%>
<%--                    <td onclick="window.location.href = '/user/profile?id=${bookClubInfo.user.id}'"--%>
<%--                        class="clickable-row">${bookClubInfo.user.username}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td style="font-weight: bolder;">Description:</td>--%>
<%--                    <td>${bookClubInfo.description}</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td onclick="window.location.href = '/bookClub/addToClub?id=${bookClubKey.id}'" class="clickable-row">Add to your bookclubs!</td>--%>
<%--                </tr>--%>


<%--            </table>--%>


<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>



<jsp:include page="../included/footer.jsp"/>