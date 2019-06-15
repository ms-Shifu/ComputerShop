<#import "filters.ftl" as f>

<main class="mb-5">
    <div class="container">

        <a href="/laptopsEdit">Laptops Edit</a>

        <#include "navbarIn.ftl">

    <#--SIDEBAR-->
        <div class="row">
            <div class="col-lg-3 border-right">
                <@f.filters "/"/>
            </div>

            <#--SECTION-->

            <div class="col-lg-9">
                Content
                <div class="row">
                    <div class="col-4">Lorem ipsum dolor sit amet.</div>
                    <div class="col-4">Lorem ipsum dolor sit amet.</div>
                    <div class="col-4">Lorem ipsum dolor sit amet.</div>
                </div>
            </div>
        </div>

    </div>
</main>