<#import "parts/common.ftl" as c>

<@c.page>

<main class="container">
        <form action="/login" method="post" class="text-center border border-light p-5">

            <p class="h4 mb-4 text-secondary">Sign In</p>

            <div class="">
                <input type="text" name="username" id="defaultLoginFormEmail" class="form-control mb-4 col-9 mx-auto" placeholder="Username" autofocus required maxlength="50">
                <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4 col-9 mx-auto" placeholder="Password" required maxlength="50">
                <button class="btn btn-info btn-block my-4 col-9 mx-auto" type="submit">Sign In</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </div>

            <a href="/registration">Add new user</a>
        </form>
</main>

</@c.page>