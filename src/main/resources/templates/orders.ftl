<#import "parts/common.ftl" as c>

<@c.page>

<h5 class="text-secondary text-center">List of Orders</h5>

<main class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Order #</th>
            <th scope="col">Date</th>
            <th scope="col">User</th>
            <th scope="col">Tel.</th>
            <th scope="col">Address</th>
            <th scope="col">Products</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
        <tr>
            <th scope="row">${order.id}</th>
            <td>${order.date}</td>
            <td>${order.user.username}</td>
            <td>${order.user.phoneNumber}</td>
            <td>${order.user.address}</td>
            <td>
                <div>
                    LaptopId: <#list order.laptops as laptop>${laptop.id}<#sep >, </#list>
                </div>
                <div>
                    TabletsId: <#list order.tablets as tablets>${tablets.id}<#sep >,</#list>
                </div>
            </td>
        </tr>
        </#list>

        </tbody>
    </table>

</main>


</@c.page>