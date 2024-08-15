<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${userKey.username}</h1>
<div class="container justify-content-center">
<div class="row  col-4">
    <a style="display: block; margin: auto; width: fit-content; margin-bottom: 10px" class="btn btn-primary custom-primary custom-primary:hover" data-bs-toggle="collapse" href="#collapseExample"
       role="button" aria-expanded="false"
       aria-controls="collapseExample"
       onclick="window.location.href = '/user/bookClubsJoined?id=${userKey.id}'">
        Joined Bookclubs
    </a>
    <a style="display: block; margin: auto; width: fit-content; margin-bottom: 10px" class="btn btn-primary custom-primary custom-primary:hover" data-bs-toggle="collapse" href="#collapseExample"
       role="button" aria-expanded="false"
       aria-controls="collapseExample"
       onclick="window.location.href = '/user/discussionsPosted?id=${userKey.id}'">
        Posted Discussions
    </a>
</div></div>
<div class="container">
    <div class="row justify-content-center">

        <div class="col-auto">
            <table class="table table-responsive" style="width: 500pt">
                <tr>
                    <td style="font-weight: bolder;">First Name:</td>
                    <td>${userKey.firstName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Last Name:</td>
                    <td>${userKey.lastName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Email:</td>
                    <td>${userKey.email}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Zip Code:</td>
                    <td>${userKey.zipCode}</td>
                </tr>


            </table>


        </div>
    </div>
</div>


<div class="container">

    <p>
        <a class="btn btn-primary custom-primary custom-primary:hover" data-bs-toggle="collapse" href="#collapseExample"
           role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Book Clubs Created (${bookClubsCreated.size()})
        </a>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="row justify-content-evenly">
            <div class="card body" style="width: 50rem">
                <div class="card-body ">

                    <div class="row pt-3 justify-content-center">
                        <div class="col-8">
                            <table class="table">
                                <tr>
                                    <th>Book Club Name</th>
                                    <th>Genre</th>
                                </tr>
                                <c:forEach items="${bookClubs}" var="bookClub">
                                    <tr onclick="window.location.href = '/bookClub/info?id=${bookClub.id}'"
                                        class="clickable-row">
                                        <td>${bookClub.clubName}</td>
                                        <td>${bookClub.genre.genreName}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<jsp:include page="../included/footer.jsp"/>