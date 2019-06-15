<#import "parts/common.ftl" as c>

<@c.page>
<form class="text-center border border-light p-5">

    <p class="h4 mb-4">Sign in</p>

    <!-- Email -->
    <input type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Username">

    <!-- Password -->
    <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">
    <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>
    <input type="hidden" model="_csrf" value="${_csrf.token}">
</form>
</@c.page>

