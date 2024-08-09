<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-12">

<h1>Meeting Location Info</h1>
</div>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-auto">
            <table class="table table-responsive" style="width: 500pt">
                <tr>
                    <td style="font-weight: bolder;">Meeting Location:</td>
                    <td>${meetingLocations.locationName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Description:</td>
                    <td>${meetingLocations.description}</td>
                </tr>
                <%--        <tr>--%>
                <%--            <td style="font-weight: bolder;">Created By:</td>--%>
                <%--            <td onclick="window.location.href = '/user/profile?id=${bookClubByMeetingLocation.user.id}'"--%>
                <%--                class="clickable-row">${bookClubByMeetingLocation.user.username}</td>--%>
                <%--        </tr>--%>


            </table>


        </div>
    </div>
</div>


<jsp:include page="../included/footer.jsp"/>