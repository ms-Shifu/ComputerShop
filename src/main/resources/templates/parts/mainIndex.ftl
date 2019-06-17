<#import "filters.ftl" as f>
<#import "sectionIndex.ftl" as s>

<main class="mb-5">
    <div class="container">

        <a href="/laptopsEdit">Laptops Edit</a>

        <#include "navbarIn.ftl">

    <#--SIDEBAR-->
        <div class="row">
            <div class="col-3 border-right">
                <@f.filters "/filter"/>
            </div>

            <#--SECTION-->

            <div class="col-9">
                <@s.sectionIndex></@s.sectionIndex>
            </div>
        </div>

    </div>
</main>