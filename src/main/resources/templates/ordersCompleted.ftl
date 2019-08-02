<#import "parts/common.ftl" as c>

<@c.page>
    <main class="container">

        <h4 class="text-secondary text-center mb-4">List of Orders</h4>


        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Order #</th>
                <th scope="col">Date Completed</th>
                <th scope="col">User</th>
                <th scope="col">Tel.</th>
                <th scope="col">Address</th>
                <th scope="col">Products</th>
                <th scope="col">Total, $</th>
            </tr>
            </thead>
            <tbody>

        <#list ordersCompleted as orderCompleted>
        <#assign laptopPrice = 0, tabletPrice = 0, phonePrice = 0/>
        <tr>
            <th scope="row">${orderCompleted.id}</th>
            <td>${orderCompleted.date}</td>
            <td>${orderCompleted.user.username}</td>
            <td>${orderCompleted.user.phoneNumber}</td>
            <td>${orderCompleted.user.address}</td>
            <td>
                <#if orderCompleted.laptops?size gt 0>
                     <div>
                         LaptopId:
                         <#list orderCompleted.laptops as laptop>
                            <a href="/laptops/${laptop.id}">${laptop.id}</a>
                             <#assign laptopPrice += laptop.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
                </#if>
               <#if orderCompleted.tablets?size gt 0>
                     <div>
                         TabletsId:
                         <#list orderCompleted.tablets as tablet>
                            <a href="tablets/${tablet.id}">${tablet.id}</a>
                             <#assign tabletPrice += tablet.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
               </#if>

                 <#if orderCompleted.phones?size gt 0>
                     <div>
                         PhoneId:
                         <#list orderCompleted.phones as phone>
                            <a href="phones/${phone.id}">${phone.id}</a>
                             <#assign phonePrice += phone.getPrice() />
                             <#sep >,
                         </#list>
                     </div>
               </#if>



            </td>
            <th class="align-middle">${laptopPrice + tabletPrice + phonePrice}</th>
        </tr>
        </#list>

            </tbody>
        </table>

    </main>
</@c.page>