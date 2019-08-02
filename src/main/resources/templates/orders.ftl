<#import "parts/common.ftl" as c>

<@c.page>


<main class="container">

    <h4 class="text-secondary text-center mb-4">List of Orders</h4>


    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Order #</th>
            <th scope="col">Date</th>
            <th scope="col">User</th>
            <th scope="col">Tel.</th>
            <th scope="col">Address</th>
            <th scope="col">Products</th>
            <th scope="col">Total, $</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
        <#assign laptopPrice = 0, tabletPrice = 0, phonePrice = 0 />
        <tr>
            <th scope="row">${order.id}</th>
            <td>${order.date}</td>
            <td>${order.user.username}</td>
            <td>${order.user.phoneNumber}</td>
            <td>${order.user.address}</td>
            <td>
                <#if order.laptops?size gt 0>
                     <div>
                         LaptopId:
                         <#list order.laptops as laptop>
                            <a href="/laptops/${laptop.id}">${laptop.id}</a>
                             <#assign laptopPrice += laptop.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
                </#if>
               <#if order.tablets?size gt 0>
                     <div>
                         TabletsId:
                         <#list order.tablets as tablet>
                            <a href="tablets/${tablet.id}">${tablet.id}</a>
                             <#assign tabletPrice += tablet.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
               </#if>

                <#if order.phones?size gt 0>
                     <div>
                         PhonesId:
                         <#list order.phones as phone>
                            <a href="phones/${phone.id}">${phone.id}</a>
                             <#assign phonePrice += phone.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
                </#if>


            </td>
            <th class="align-middle">${laptopPrice + tabletPrice + phonePrice}</th>
            <td>
                <form action="/ordersCompleted" method="post" class="d-inline">
                    <button class="btn btn-success" name="orderId" value="${order.id}" >Completed</button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </td>
        </tr>
        </#list>

        </tbody>
    </table>

</main>


</@c.page>