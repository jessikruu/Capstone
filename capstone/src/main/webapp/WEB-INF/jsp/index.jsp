<jsp:include page="included/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<h1>Finders Readers</h1>

Search for a book!

<section>

    <div class="container">

        <div class="row justify-content-center pt-5 pb-3">

            <div class="col-8 text-center">

                <form action="/bookClub/search">

                    <div class="mb-3">

                        <label for="search" class="form-label"><h4>Search Below</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search"
                               placeholder="Enter search term"/>


                    </div>
                    <button type="submit" class="btn btn-primary custom-primary custom-primary:hover">&#128269; Search</button>

                </form>
            </div>
        </div>
    </div>
</section>

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


<jsp:include page="included/footer.jsp"/>