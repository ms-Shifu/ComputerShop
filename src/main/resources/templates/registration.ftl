<#import "parts/common.ftl" as c>

<@c.page>
    <main class="container">
        <form action="/registration" method="post" class="border border-light p-5" autocomplete="on">

            <p class="h4 mb-4 text-center text-secondary">Sign Up</p>

            <#if message??>
                <div class="alert alert-danger col-9 mx-auto mb-4" role="alert">
                    <p class="h5  text-center">${message}</p>
                </div>
            </#if>


            <div class="form-group">
                <label for="inputUsername" style="padding-left: 127px;">Username</label>
                <input type="text" name="username" id="inputUsername"
                       class="form-control col-9 mx-auto ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="Enter username" autofocus value="${(userRegistration.getUsername())!''}">
                <#if usernameError??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${usernameError}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <label for="inputPassword" style="padding-left: 127px;">Password</label>
                <input type="password" name="password" id="inputPassword"
                       class="form-control col-9 mx-auto ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Enter password">
                <#if passwordError??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${passwordError}
                    </div>
                </#if>
                <input type="password" name="password2" id="inputPassword"
                       class="form-control col-9 mx-auto mt-2 ${(password2Error??)?string('is-invalid', '')}"
                       placeholder="Confirm password">
                <#if password2Error??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${password2Error}
                    </div>
                </#if>
            </div>

            <div class="form-group">
                <label for="inputEmail" style="padding-left: 127px;">Email</label>
                <input type="email" name="email" id="inputEmail"
                       class="form-control mb-2 col-9 mx-auto ${(emailError??)?string('is-invalid', '')}"
                       placeholder="some@some.com" value="${(userRegistration.getEmail())!''}">
                <#if emailError??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${emailError}
                    </div>
                </#if>
            </div>


            <div class="form-group">
                <label for="inputAddress" style="padding-left: 127px;">Home address</label>
                <input type="text" name="address" id="inputAddress"
                       class="form-control col-9 mx-auto ${(addressError??)?string('is-invalid', '')}"
                       aria-describedby="addressHelp" placeholder="Enter home address"
                       value="${(userRegistration.getAddress())!''}">
                <small id="addressHelp" class="form-text text-muted" style="padding-left: 127px;">City, Street Address,
                    Apartment</small>
                <#if addressError??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${addressError}
                    </div>
                </#if>
            </div>


            <div class="form-group">
                <label for="inputPhoneNumber" style="padding-left: 127px;">Phone number</label>
                <input type="tel" name="phoneNumber" id="inputPhoneNumber"
                       class="form-control col-9 mx-auto ${(phoneNumberError??)?string('is-invalid', '')}"
                       aria-describedby="telHelp" placeholder="+375 XX XXX-XX-XX"
                       value="${(userRegistration.getPhoneNumber())!''}">
                <small id="telHelp" class="form-text text-muted" style="padding-left: 127px;">Example: +375 XX
                    XXX-XX-XX</small>
                <#if phoneNumberError??>
                    <div class="invalid-feedback" style="padding-left: 127px;">
                        ${phoneNumberError}
                    </div>
                </#if>
            </div>

            <button class="btn btn-info btn-block my-4 col-9 mx-auto" type="submit">Sign Up</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </main>

</@c.page>