<#import "parts/common.ftl" as c>

<@c.page>

<div>
    <form action="/login" method="post" class="text-center border border-light p-5">

        <p class="h4 mb-4">Sign In</p>

        <div class="">
            <input type="text" name="username" id="defaultLoginFormEmail" class="form-control mb-4 col-4 mx-auto" placeholder="Username" autofocus required>
            <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4 col-4 mx-auto" placeholder="Password" required>
            <button class="btn btn-info btn-block my-4 col-4 mx-auto" type="submit">Sign In</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </div>
    </form>
</div>

</@c.page>

<#--<!DOCTYPE html>-->

<#--<head>-->
    <#--<title>Spring Security Example </title>-->
<#--</head>-->
<#--<body>-->
<#--<form action="/login" method="post">-->
    <#--<div><label> User Name : <input type="text" name="username"/> </label></div>-->
    <#--<div><label> Password: <input type="password" name="password"/> </label></div>-->
    <#--<div><input type="submit" value="Sign In"/></div>-->
    <#---->
<#--</form>-->
<#--</body>-->
<#--</html>-->