<#import "parts/common.ftl" as c>

<@c.page>

<main class="container">
        <form action="/login" method="post" class="text-center border border-light p-5">

            <p class="h4 mb-4 text-secondary">Sign In</p>

            <p class="h5 col-9 mb-3 mx-auto text-left pl-0 text-danger">${message!""}</p>
            <p class="h5 col-9 mb-3 mx-auto text-left pl-0 text-success">${message2!""}</p>

            <div class="form-group">

                <input type="text" name="username" id="defaultLoginFormEmail" class="form-control mb-4 col-9 mx-auto" placeholder="Username" autofocus required maxlength="50">
                <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4 col-9 mx-auto" placeholder="Password" required maxlength="50">
                <a href="/forgotPassword" methods="post">Forgot your password?</a>
                <button class="btn btn-info btn-block my-4 col-9 mx-auto" type="submit">Sign In</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </div>

            <a href="/registration">Add new user</a>
        </form>
</main>

</@c.page>