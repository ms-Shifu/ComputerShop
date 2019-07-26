<#import "sectionTablets.ftl" as s>

<#import "filters.ftl" as f>

<main class="mb-0">
    <div class="container">

        <#include "navbarIn.ftl">

    <#--SIDEBAR-->
        <div class="row">
            <div class="col-3 border-right">
                <@f.filters "/tablets"/>
            </div>

        <#--SECTION-->

            <div class="col-9">
                <@s.sectionTablets/>
            </div>
        </div>

    </div>
</main>