<section>

    <div class="container">
        <div class="row pt-5">
            <div class="col-12">

                <h2 class="text-center">Employees Found: (${employees.size()})</h2>

            </div>


        </div>
        <div class="row justify-content-center">
            <div class="col-auto">
                <table class="table table-responsive">
                    <tr>
                        <th>Employee ID</th>
                        <th>Office ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Assigned Customers</th>


                    </tr>

                    <c:forEach items="${employees}" var="employee">

                        <tr onclick="window.location.href = '/employee/info?id=${employee.id}'" class="clickable-row">
                            <td>${employee.id}</td>
                            <td>${employee.officeId}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td onclick="window.location.href = '/customer/search?search=${employeeKey.id}'" class="clickable-row" style="text-align: ">Customers</td>


                        </tr>
                    </c:forEach>

                </table>
            </div>


        </div>

    </div>


</section>