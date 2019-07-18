<#import "parts/common.ftl" as c>

<@c.page>

<main class="container">

    <#list laptops as laptop>
        <h5>${laptop}</h5>
    </#list>

</main>


</@c.page>