<#import "parts/common.ftl" as c>

<@c.page>
    <main class="container">
        <p class="h4 mb-4 text-secondary text-center">Password recovery</p>

        <form action="/passwordRecovery" method="post" class="text-center border border-light p-5">

            <p class="h5 text-danger">${message!""}</p>

            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" name="email" class="form-control col-9 mx-auto" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required maxlength="50">
                <small id="emailHelp" class="form-text text-muted">Password will send on your email.</small>


            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-info col-9">Submit</button>
        </form>
    </main>
</@c.page>

