<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${bookClubKey.clubName}</h1>
<div class="container">
    <div class="row justify-content-center">

        <div class="col-auto">
            <table class="table table-responsive" style="width: 500pt">
                <tr>
                    <td style="font-weight: bolder;">Genre:</td>
                    <td onclick="window.location.href = '/genres/info/${bookClubKey.genre.id}'"
                        class="clickable-row">${bookClubKey.genre.genreName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Meeting Location:</td>
                    <td onclick="window.location.href = '/meetingLocation/info/${bookClubKey.meetingLocation.id}'"
                        class="clickable-row">${bookClubKey.meetingLocation.locationName}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Created By:</td>
                    <td onclick="window.location.href = '/user/profile?id=${bookClubKey.user.id}'"
                        class="clickable-row">${bookClubKey.user.username}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Description:</td>
                    <td>${bookClubKey.description}</td>
                </tr>
                <tr>
                    <td onclick="window.location.href = '/bookClub/addToClub?id=${bookClubKey.id}'" class="clickable-row">Add to your bookclubs!</td>
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
            Customers Found (${customers.size()})
        </a>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body body">

            <div class="row pt-5">
                <div class="col-12">
                    <h2 class="text-center">Active Customers</h2>
                </div>
            </div>
            <div class="row pt-3 justify-content-center">
                <div class="col-8">
                    <table class="table">
                        <tr>
                            <th>Customer ID:</th>
                            <th>Customer Name:</th>
                            <th>Contact Name</th>

                        </tr>
                        <c:forEach items="${customers}" var="customer">
                            <tr onclick="window.location.href = '/customer/info?id=${customer.id}'"
                                class="clickable-row">
                                <td>${customer.id}</td>
                                <td>${customer.customerName}</td>
                                <td>${customer.contactFirstName} ${customer.contactLastName}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../included/footer.jsp"/>