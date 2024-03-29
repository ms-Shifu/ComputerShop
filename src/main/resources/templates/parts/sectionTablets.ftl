<#include "security.ftl">

<#macro sectionTablets>
    <section>
        <div class="row">
            <#list tablets as tablet>
                <div class="col-lg-4 col-md-6 mt-2">
                    <div class="card bd-highlight mb-3" style="height: 34rem;">
                        <img src="/img/${tablet.fileName}" class="card-img-top px-4 pt-2" alt="tablet">
                        <div class="card-body  text-center">
                            <h5 class="card-title text-center">${tablet.manufacturer} ${tablet.model}</h5>
                            <p class="card-text text-center">${tablet.os}, ${tablet.monitor}", CPU: ${tablet.cpu}, RAM ${tablet.ram}Gb,
                              flash memory: ${tablet.storageSize}Gb,
                                flash card: ${tablet.flashCard?then("Yes", "No")}.</p>
                        </div>
                        <div class="mb-3 mx-auto">
                            <strong class="text-primary mr-4 align-middle">$${tablet.getPrice()?string["0.00"]}</strong>
                            <form class="d-inline" action="addTabletToCart" method="post">
                                <button class="btn btn-primary" name="buttonAddTabletToCart" value="${tablet.id}">Add to cart</button>
                                    <#if know><input type="hidden" name="userId" value="${user.id}"></#if>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
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