<jsp:include page="../included/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<!-- page header -->
<c:if test="${empty form.bookClubId}">
    <h1 class="text-center">Create Book Club</h1>
</c:if>
<c:if test="${not empty form.bookClubId}">
    <h1 class="text-center">Edit Book Club</h1>
</c:if>


<div>
    <c:if test="${not empty errorMessage}">
        <section>
            <div class="text-danger alert alert-danger" style="text-align: center">
                    ${errorMessage}
            </div>
        </section>
    </c:if>

    <div class="container">
        <div class="pt-5">

            <%--                method="post"--%>

            <form class="form-container" action="/bookClub/createSubmit">

                <input type="hidden" name="bookClubId" value="${form.bookClubId}">
                <input type="hidden" name="createdBy" value="${userId}">


                <!-- club name input -->

                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-4">
                        <label class="visually-hidden" for="clubNameID">Club Name</label>
                        <div>
                            <input type="text" id="clubNameID" name="clubName" placeholder="Book Club Name"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('clubName')}">is-invalid</c:if>"
                                   value="${form.clubName}">
                            <c:if test="${bindingResult.hasFieldErrors('clubName')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('clubName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>


                </div>

<%--                description input--%>

                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-4">
                        <label class="visually-hidden" for="descriptionID">description</label>
                        <div>
                            <textarea rows="6" id="descriptionID" name="description" placeholder="Description"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('description')}">is-invalid</c:if>"
                                      value="${form.description}"></textarea>
                            <c:if test="${bindingResult.hasFieldErrors('description')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('description')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>

                </div>



                <%--                    meeting id input--%>

                <div class="row g-4 p-3 justify-content-center">
                    <div class="col-md-2">
                        <label for="meetingLocationID" class="visually-hidden">Meeting Location:</label>
                        <div>
                            <select id="meetingLocationID" name="meetingLocationId" class="form-select">
                                <option disabled selected value="">Meeting Location</option>
                                <c:forEach items="${possibleLocations}" var="meetingLocation">
                                    <option
                                            value="${meetingLocation.id}"
                                            <c:if test="${meetingLocation.id eq form.meetingLocationId}">selected</c:if>
                                    >
                                            ${meetingLocation.locationName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

<%--                    genres input--%>

                    <div class="col-md-2">
                        <label for="genresID" class="visually-hidden">Genre:</label>
                        <div>
                            <select id="genresID" name="genreId" class="form-select">
                                <option disabled selected value="">Genre</option>
                                <c:forEach items="${possibleGenres}" var="possibleGenre">
                                    <option
                                            value="${possibleGenre.id}"
                                            <c:if test="${possibleGenre.id eq form.genreID}">selected</c:if>
                                    >
                                            ${possibleGenre.genreName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>



                </div>


                <div class="row justify-content-center">

                    <div class="col-auto">

                        <button type="submit" class="btn btn-primary  custom-primary custom-primary:hover">&#9998;
                            Submit
                        </button>

                    </div>

                </div>
        </div>

    </div>
    </form>

</div>

</section>


<jsp:include page="../included/footer.jsp"/>