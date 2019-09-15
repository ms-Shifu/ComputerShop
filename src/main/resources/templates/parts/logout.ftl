<form action="/logout" method="post">
    <button type="submit" class="btn btn-outline-primary">Log Out</button>
    <#--<a class="btn btn-outline-primary" href="/" role="button">Loq Out</a>-->
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>
