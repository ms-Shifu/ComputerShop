<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<main class="container">

    <p class="h4 mb-4 text-center text-secondary">In cart</p>

    <#list user.laptops as laptop>

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
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                </div>
                <div class="col-2">
                    <div class="card-body">
                        <h5 class="card-title">$${laptop.price}</h5>

                        <form class="d-inline" action="removeFromCart" method="post">
                            <div class="from-group mb-2">
                                <button class="btn btn-warning" name="removeLaptop" value="${laptop.id}">Remove</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>

                        </form>

                        <form class="d-inline" action="order" method="post">
                            <div class="from-group">
                                <button class="btn btn-primary" name="buyProduct" value="${laptop.id}" style="width: 83px;">Buy</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    <#else >

          <div class="container">
              <p>Cart is empty</p>
          </div>

    </#list>



</main>

</@c.page>