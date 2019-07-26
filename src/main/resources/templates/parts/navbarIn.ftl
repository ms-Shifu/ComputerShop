<#include "security.ftl">

    <nav class="navbar navbar-expand navbar-dark bg-primary">
        <div>
            <a class="navbar-brand pl-3 text-dark text-uppercase" href="#">Catalog:</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link active" href="/">Laptops </a>
                    <#if isAdmin>
                        <a class="nav-link text-dark" href="/laptopsEdit" style="margin-top: -15px;">-Edit-</a>
                    </#if>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/tablets">Tablets</a>
                     <#if isAdmin>
                        <a class="nav-link text-dark" href="/tabletsEdit" style="margin-top: -15px;">-Edit-</a>
                     </#if>
                </li>
            </ul>
        </div>
    </nav>