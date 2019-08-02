<#include "security.ftl">

    <nav class="navbar navbar-expand navbar-dark bg-primary">
            <a class="navbar-brand pl-3 text-dark text-uppercase" href="#">Catalog:</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ${activeLaptops!""}">
                    <a class="h5 nav-link mb-0" href="/">Laptops </a>
                    <#if isAdmin>
                        <a class="nav-link text-dark" href="/laptopsEdit" style="margin-top: -15px;">[Edit]</a>
                    </#if>
                </li>
                <li class="nav-item ${activeTablets!""}">
                    <a class="h5 nav-link mb-0" href="/tablets">Tablets</a>
                     <#if isAdmin>
                        <a class="nav-link text-dark" href="/tabletsEdit" style="margin-top: -15px;">[Edit]</a>
                     </#if>
                </li>
                <li class="nav-item ${activePhones!""}">
                    <a class="h5 nav-link mb-0" href="/phones">Cell Phones</a>
                     <#if isAdmin>
                        <a class="nav-link text-dark" href="/phonesEdit" style="margin-top: -15px;">[Edit]</a>
                     </#if>
                </li>
            </ul>

            <ul class="navbar-nav">
                <li class="nav-item ">
                    <form action="/" method="get">
                        <div class="form-group my-auto">
                        <#--<label for="inputState">State</label>-->
                            <select class="form-control" name="sortByPrice">
                                <option selected disabled>Sort</option>
                                <option value="true">Price ASC</option>
                                <option value="false">Price DESC</option>
                            </select>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </nav>