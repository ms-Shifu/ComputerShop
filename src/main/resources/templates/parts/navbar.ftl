<#include "security.ftl">

<nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top mb-5">
    <strong><a class="navbar-brand text-primary" href="#"><span style="font-size: 1.5rem;"><span class="text-danger">C</span>omputer<span class="text-danger">S</span>hop</span></a></strong>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Catalog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contacts">Contacts</a>
            </li>
        </ul>

        <ul class="navbar-nav mr-5">
            <li class="nav-item">
                <a class="nav-link" href="/cart">
                    <img src="/img/Cart-1-512.png" width="25" height="25" class="d-inline-block align-top"  alt="cart">
                    <h5 class="d-inline">
                        <span class="badge badge-danger"><#if know> ${user.getInCart()} <#else>0</#if></span>
                    </h5>
                </a>

            </li>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if know>
            <#include "logout.ftl">

        <#else >
            <a class="btn btn-primary" href="/indexAdmin" role="button">Log In</a>

        </#if>

    </div>
</nav>