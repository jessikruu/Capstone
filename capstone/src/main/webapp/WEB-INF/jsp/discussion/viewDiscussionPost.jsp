<jsp:include page="../included/header.jsp"/>
<link rel="stylesheet" href="/pub/css/global.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Discussion Post</h1>


<div class="container">
    <div class="row justify-content-center">

        <div class="col-auto">
            <table class="table table-responsive" style="width: 500pt">
                <tr>
                    <td style="font-weight: bolder;">Title:</td>
                    <td>${discussions.title}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Created By:</td>
                    <td onclick="window.location.href = '/user/profile?id=${discussions.discussionCreatorUser.id}'"
                        class="clickable-row">${discussions.discussionCreatorUser.username}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Book Club:</td>
                    <td onclick="window.location.href = '/user/profile?id=${discussions.discussionCreatorUser.id}'"
                        class="clickable-row">${discussions.discussionCreatorUser.username}</td>
                </tr>
                <tr>
                    <td style="font-weight: bolder;">Body:</td>
                    <td>${discussions.body}</td>
                </tr>





            </table>


        </div>
    </div>
</div>