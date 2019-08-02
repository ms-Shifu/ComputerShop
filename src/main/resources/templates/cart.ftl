<#import "parts/common.ftl" as c>
<#assign laptopPrice = 0, tabletPrice = 0, phonePrice = 0 />
<#assign messageAttention = "Please, check the specifications with the seller." />
<#include "parts/security.ftl" >


<@c.page>

<main class="container">

    <p class="h4 mb-4 text-center text-secondary">In cart</p>


    <#--LAPTOPS-->

    <#list laptops as laptop>

        <div class="card mb-3 mx-auto" style="max-width: 940px;">
            <div class="row no-gutters">
                <div class="col-3 p-2">
                    <img src="/img/${laptop.fileName}" class="card-img" alt="Laptop">
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${laptop.manufacturer} ${laptop.model}</h5>
                        <p class="card-text">${laptop.monitor}", ${laptop.cpu}, ${laptop.ram}Gb,
                            ${laptop.storageType}, ${laptop.storageSize}Gb, video card: ${laptop.videoCard}.</p>
                        <p class="card-text"><small class="text-muted">${messageAttention}</small></p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${laptop.price}</h5>

                        <form class="d-inline" action="/removeFromCart" method="post">
                            <div class="from-group mb-2">
                                <button class="btn btn-warning" name="username"
                                        value="${user.username}">Remove</button>
                                <input type="hidden" name="laptopId" value="${laptop.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>
                        </form>

                        <form class="d-inline" action="buy" method="post">
                            <div class="from-group">
                                <button class="btn btn-primary" name="username" value="${user.username}"
                                        style="width: 83px;">Buy</button>
                                <input type="hidden" name="laptopId" value="${laptop.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

        <#assign laptopPrice += laptop.getPrice() />
    </#list>



    <#--TABLETS-->

     <#list tablets as tablet>

        <div class="card mb-3 mx-auto" style="max-width: 940px; max-height: 200px;">
            <div class="row no-gutters">
                <div class="col-3 p-2 " >
                    <div class="col-8 mx-auto">
                        <img src="/img/${tablet.fileName}" class="card-img" alt="Tablet">
                    </div>
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${tablet.manufacturer} ${tablet.model}</h5>
                        <p class="card-text">${tablet.os}, ${tablet.monitor}", CPU: ${tablet.cpu}, RAM ${tablet.ram}Gb,
                            flash memory: ${tablet.storageSize}Gb, flash card: ${tablet.flashCard?then("Yes", "No")}.</p>
                        <p class="card-text"><small class="text-muted">${messageAttention}</small></p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${tablet.price}</h5>

                        <form class="d-inline" action="removeFromCart" method="post">
                            <div class="from-group mb-2">
                                <button class="btn btn-warning" name="username" value="${user.username}">Remove</button>
                                <input type="hidden" name="tabletId" value="${tablet.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>

                        </form>

                        <form class="d-inline" action="buy" method="post">
                            <div class="from-group">
                                <button class="btn btn-primary" name="username"
                                        value="${user.username}" style="width: 83px;">Buy</button>
                                <input type="hidden" name="tabletId" value="${tablet.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
         <#assign tabletPrice += tablet.getPrice() />
     </#list>

    <#--PHONES-->

     <#list phones as phone>

        <div class="card mb-3 mx-auto" style="max-width: 940px; max-height: 200px;">
            <div class="row no-gutters">
                <div class="col-3 p-2 " >
                    <div class="col-8 mx-auto">
                        <img src="/img/${phone.fileName}" class="card-img" alt="Tablet">
                    </div>
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <h5 class="card-title">${phone.manufacturer} ${phone.model}</h5>
                        <p class="card-text">${phone.monitor}", CPU: ${phone.cpu}, RAM ${phone.ram}Gb,
                            flash memory: ${phone.storageSize}Gb, dual SIM:
                            ${phone.dualSim?then("Yes", "No")},
                            flash card: ${phone.flashCard?then("Yes", "No")}.</p>
                        <p class="card-text"><small class="text-muted">${messageAttention}</small></p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${phone.price}</h5>

                        <form class="d-inline" action="removeFromCart" method="post">
                            <div class="from-group mb-2">
                                <button class="btn btn-warning" name="username" value="${user.username}">Remove</button>
                                <input type="hidden" name="phoneId" value="${phone.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>

                        </form>

                        <form class="d-inline" action="buy" method="post">
                            <div class="from-group">
                                <button class="btn btn-primary" name="username" value="${user.username}" style="width: 83px;">Buy</button>
                                <input type="hidden" name="phoneId" value="${phone.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

         <#assign phonePrice += phone.getPrice() />

     </#list>

        <hr class="my-3"/>

    <#if user.getInCart() gt 1 >
    <div class="d-flex justify-content-end align-items-center">
        <p class="h5">Total sum: $${laptopPrice + tabletPrice + phonePrice}</p>

        <form action="/buyAll" method="post" class=" ml-3">
            <button class="btn btn-primary" name="username"
                    value="${user.username}" style="width: 83px;">Buy All</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>

    </#if>

    <#if user.getInCart() == 0>
         <div class="container">
             <p>Cart is empty.</p>
         </div>
    </#if>

</main>

</@c.page>