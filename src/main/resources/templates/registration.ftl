<#import "parts/common.ftl" as c>

<@c.page>
<main class="container">
    <form action="/registration" method="post" class="border border-light p-5" autocomplete="on">

        <p class="h4 mb-4 text-center text-secondary">Sign Up</p>

        <p class="h5 mb-4 text-center text-danger">${message!''}</p>

        <div class="form-group">
            <label for="inputUsername" style="padding-left: 127px;">Username</label>
            <input type="text" name="username" id="inputUsername" class="form-control col-9 mx-auto"
                   placeholder="Enter username" autofocus required maxlength="50">
        </div>

        <div class="form-group">
            <label for="inputPassword" style="padding-left: 127px;">Password</label>
            <input type="password" name="password1" id="inputPassword" class="form-control mb-2 col-9 mx-auto"
                   placeholder="Enter password" required maxlength="50">
            <input type="password" name="password2" id="inputPassword" class="form-control col-9 mx-auto"
                   placeholder="Confirm password" required maxlength="50">
        </div>

        <div class="form-group">
            <label for="inputAddress" style="padding-left: 127px;">Address</label>
            <input type="text" name="address" id="inputAddress" class="form-control col-9 mx-auto"
                   aria-describedby="addressHelp" placeholder="Enter address" autofocus required maxlength="50">
            <small id="addressHelp" class="form-text text-muted" style="padding-left: 127px;">City, Street Address, Apartment</small>
        </div>


        <div class="form-group">
            <label for="inputPhoneNumber" style="padding-left: 127px;">Phone number</label>
            <input type="tel" name="phoneNumber" id="inputPhoneNumber" class="form-control col-9 mx-auto"
                   aria-describedby="telHelp" placeholder="+375-XX-XXX-XX-XX" autofocus required maxlength="50">
            <small id="telHelp" class="form-text text-muted" style="padding-left: 127px;">Example: +375 XX XXX-XX-XX</small>
        </div>

        <button class="btn btn-info btn-block my-4 col-9 mx-auto" type="submit">Sign Up</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</main>

</@c.page>