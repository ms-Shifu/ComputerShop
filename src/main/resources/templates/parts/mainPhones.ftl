<#import "filters.ftl" as f>
<#import "sectionPhones.ftl" as s>

<main class="container">

    <section>
        <div class="row">
            <div class="col-12">
                <#include "navbarIn.ftl">
            </div>
        </div>

    <#--SIDEBAR-->

        <div class="row">
            <div class="col-3 border-right">
                <@f.filters "/phones" />
            </div>

    <#--SECTION-->

            <div class="col-9">
                <@s.sectionPhones />
            </div>
        </div>
    </section>

</main>