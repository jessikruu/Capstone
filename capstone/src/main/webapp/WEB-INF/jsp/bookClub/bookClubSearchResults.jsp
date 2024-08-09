<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Search Results</h1>
<section>

    <div class="container">
        <div class="row pt-5">
            <div class="col-12">

                <h2 class="text-center">Book Clubs Found: (${bookClubs.size()})</h2>

            </div>


        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <table class="table table-responsive">
                    <tr>
                        <th>Book Club Name</th>
                        <th>Genre</th>


                    </tr>

                    <c:forEach items="${bookClubs}" var="bookClub">

                        <tr onclick="window.location.href = '/bookClub/info?id=${bookClub.id}'" class="clickable-row">
                            <td>${bookClub.clubName}</td>
                            <td>${bookClub.genre}</td>


                        </tr>
                    </c:forEach>

                </table>
            </div>


        </div>

    </div>


</section>

<jsp:include page="../included/footer.jsp"/>