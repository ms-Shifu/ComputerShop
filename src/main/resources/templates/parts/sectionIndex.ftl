<#include "security.ftl">

<#macro sectionIndex>
    <section>
        <div class="row" id="laptops-list">
            <#list laptops as laptop>
                <div class="col-lg-4 col-md-6 mt-2" data-id="${laptop.id}">
                    <div class="card" style="height: 22rem;">
                        <img src="/img/${laptop.fileName}" class="card-img-top mt-1 px-2" alt="laptop" />
                        <div class="card-body  text-center">
                            <h5 class="card-title text-center">${laptop.manufacturer} ${laptop.model}</h5>
                            <p class="card-text text-center">${laptop.monitor}", ${laptop.cpu}, ${laptop.ram}Gb,
                                ${laptop.storageType}, ${laptop.storageSize}Gb, video card: ${laptop.videoCard}.</p>

                        </div>

                        <div class="mx-auto mb-3">
                            <strong class="text-primary mr-4 align-middle">$${laptop.getPrice()?string["0.00"]}</strong>
                        <#--<a href="#" class="btn btn-primary">Add to cart</a>-->
                            <form class="d-inline" action="addLaptopToCart" method="post">
                                <button class="btn btn-primary" name="buttonAddLaptopToCart" value="${laptop.id}">Add to cart</button>
                                    <#if know><input type="hidden" name="userId" value="${user.id}"/></#if>
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            </form>
                        </div>

                    </div>
                </div>
            <#else >
                <div class="container">
                    <p>There is no results</p>
                </div>
            </#list>
        </div>
    </section>
</#macro>
