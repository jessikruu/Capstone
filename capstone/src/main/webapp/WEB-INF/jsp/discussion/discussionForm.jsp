<jsp:include page="../included/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- page header -->
<c:if test="${empty form.discussionId}">
    <h1 class="text-center">Create Discussion Post! </h1>
</c:if>
<c:if test="${not empty form.discussionId}">
    <h1 class="text-center">Edit Discussion Post</h1>
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

            <form class="form-container" action="/discussion/createSubmit">

                <input type="hidden" name="discussionId" value="${form.discussionId}">
                <input type="hidden" name="discussionCreatorId" value="${form.discussionCreatorId}">
                <input type="hidden" name="clubId" value="${form.clubId}">



                <!-- club name input -->

                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-6">
                        <label class="visually-hidden" for="titleID">Title</label>
                        <div>
                            <input type="text" id="titleID" name="title" placeholder="Title"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('title')}">is-invalid</c:if>"
                                   value="${form.title}">
                            <c:if test="${bindingResult.hasFieldErrors('title')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('title')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>


                </div>

                <%--                description input--%>

                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-6">
                        <label class="visually-hidden" for="bodyID">body</label>
                        <div>
                            <textarea rows="6" id="bodyID" name="body" placeholder="What do you want to write about?"
                                      class="form-control <c:if test="${bindingResult.hasFieldErrors('body')}">is-invalid</c:if>"
                                      >${form.body}</textarea>
                            <c:if test="${bindingResult.hasFieldErrors('body')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('body')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
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
            </form>

        </div>

    </div>

</div>


<jsp:include page="../included/footer.jsp"/>