<#include "security.ftl">

<#macro sectionPhones>
    <section>
        <div class="row">
            <#list phones as phone>
                <div class="col-lg-4 col-md-6 mt-2">
                    <div class="card" style="height: 30rem;">
                        <img src="/img/${phone.fileName}" class="card-img-top px-4 pt-2" alt="phone">
                        <div class="card-body  text-center">
                            <h5 class="card-title text-center">${phone.manufacturer} ${phone.model}</h5>
                            <p class="card-text text-center">${phone.monitor}", CPU: ${phone.cpu},
                                RAM ${phone.ram}Gb, flash memory: ${phone.storageSize}Gb,
                                dual SIM: ${phone.dualSim?then("Yes", "No")},
                                flash card: ${phone.flashCard?then("Yes", "No")}.</p>
                        </div>
                        <div class="mx-auto" style="margin-bottom: 10px;">
                            <strong class="text-primary mr-2 align-middle">$${phone.getPrice()?string["0.00"]}</strong>
                            <form class="d-inline" action="/addPhoneToCart" method="post">
                                <button class="btn btn-primary" name="buttonAddPhoneToCart" value="${phone.id}">Add to cart</button>
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