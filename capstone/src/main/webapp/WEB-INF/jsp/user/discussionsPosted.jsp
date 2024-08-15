<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${userKey.username}'s Current Discussions! (${posts.size()})</h1>



<div class="container">
    <div class="row justify-content-center">
        <div class="col-auto">
            <table class="table table-responsive">
                <!-- Header Row -->
                <tr>
                    <th>Title:</th>
                    <th>Creator:</th>
                    <th>Date Created:</th>
                </tr>



                    <c:forEach items="${posts}" var="post">
                        <tr onclick="window.location.href = '/discussion/info?id=${post.id}'"
                            class="clickable-row">
                            <td>${post.title}</td>
                            <td>${post.discussionCreatorUser.username}</td>
                            <td>${post.creationDate}</td>

                        </tr>
                    </c:forEach>

                    <!-- Iterate Over Each BookClub -->
<%--                    <c:forEach var="bookClub" items="${bookClubDetails}">--%>
<%--                    <tr>--%>
<%--                        <td onclick="window.location.href = '/bookClub/info?id=${bookClub.id}'" class="clickable-row">${bookClub.clubName}</td>--%>
<%--                        <td onclick="window.location.href = '/genres/info/${bookClub.genre.id}'" class="clickable-row">${bookClub.genre.genreName}</td>--%>
<%--                        <td onclick="window.location.href = '/meetingLocation/info/${bookClub.meetingLocation.id}'" class="clickable-row">${bookClub.meetingLocation.locationName}</td>--%>
<%--                        <td onclick="window.location.href = '/user/profile?id=${bookClub.user.id}'" class="clickable-row">${bookClub.user.username}</td>--%>
<%--                        <td>${bookClub.description}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../included/footer.jsp"/>