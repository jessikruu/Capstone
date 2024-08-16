<jsp:include page="../included/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<h1>Create Account</h1>

<div>
    <c:if test="${not empty errorMessage}">
        <section>
            <div class="text-danger alert alert-danger" style="text-align: center">
                    ${errorMessage}
            </div>
        </section>
    </c:if>

    <div class="container form-container">
        <div class="pt-5">

            <form onsubmit="return onSubmit()" class="form-container-smaller" action="/account/create-account" method="post">



                <!-- first name input -->
                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-2">
                        <label class="visually-hidden" for="firstNameID">Name</label>
                        <div>
                            <input type="text" id="firstNameID" name="firstName" placeholder="First Name"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('firstName')}">is-invalid</c:if>"
                                   value="${form.firstName}">
                            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>

                    <!-- last name input -->
                    <div class="col-md-2">
                        <label class="visually-hidden" for="lastNameID">Name</label>
                        <div>
                            <input  type="text" id="lastNameID" name="lastName" placeholder="Last Name"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('lastName')}">is-invalid</c:if>"
                                   value="${form.lastName}">
                            <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>
                </div>

                <!-- zip code input -->
                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-2">
                        <label class="visually-hidden" for="zipCodeID">Zip Code</label>
                        <div>
                            <input type="text" id="zipCodeID" name="zipCode" placeholder="Zip Code"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('zipCode')}">is-invalid</c:if>"
                                   value="${form.zipCode}">
                            <c:if test="${bindingResult.hasFieldErrors('zipCode')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('zipCode')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>

                    <!-- username input -->
                    <div class="col-md-2">
                        <label class="visually-hidden" for="usernameID">username</label>
                        <div>
                            <input type="text" id="usernameID" name="username" placeholder="Username"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('username')}">is-invalid</c:if>"
                                   value="${form.username}">
                            <c:if test="${bindingResult.hasFieldErrors('username')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('username')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>
                </div>

                <!-- email input -->
                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-2">
                        <label class="visually-hidden" for="emailID">email</label>
                        <div>
                            <input  type="text" id="emailID" name="email" placeholder="Email"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                   value="${form.email}">
                            <c:if test="${bindingResult.hasFieldErrors('email')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                            <div id="emailHelp" class="form-text"></div>
                        </div>

                    </div>

                    <!-- password input -->
                    <div class="col-md-2">
                        <label class="visually-hidden" for="passwordID">password</label>
                        <div>
                            <input type="text" id="passwordID" name="password" placeholder="Password"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('password')}">is-invalid</c:if>"
                                   value="${form.password}">
                            <c:if test="${bindingResult.hasFieldErrors('password')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>

                    </div>
                </div>

<%--                are you human--%>

                <div class=" row g-4  p-3 justify-content-center">
                    <div class="col-md-2">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name = "human" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault" style="color: #93592B; font-weight: bold">
                                Are you human?
                            </label>
                            <c:if test="${bindingResult.hasFieldErrors('human')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('human')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>
                    </div>


<%--                    are you sure--%>

                    <div class="col-md-2">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name = "sure" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault" style="color: #93592B; font-weight: bold">
                                Are you suuuuure?
                            </label>
                            <c:if test="${bindingResult.hasFieldErrors('sure')}">
                                <div class="text-danger">
                                    <c:forEach items="${bindingResult.getFieldErrors('sure')}" var="error">
                                        ${error.defaultMessage}<br>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>
                    </div>

                </div>


                <div class="row justify-content-center pt-3 ">
                    <div class="col-auto text-center">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</section>


<jsp:include page="../included/footer.jsp"/>