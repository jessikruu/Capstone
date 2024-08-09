<jsp:include page="included/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<h1>Finders Readers</h1>


<section>

    <div class="container">

        <div class="row justify-content-center pt-5 pb-3">

            <div class="col-8 text-center">

                <form action="/bookClub/search">

                    <div class="mb-3">

                        <label for="search" class="form-label"><h4>Search for a book club!</h4></label>
                        <input type="text" value="${search}" class="form-control" id="search" name="search"
                               placeholder="Enter search term"/>


                    </div>
                    <button type="submit" class="btn btn-primary custom-primary custom-primary:hover">&#128269; Search</button>

                </form>
            </div>
        </div>
    </div>
</section>




<jsp:include page="included/footer.jsp"/>