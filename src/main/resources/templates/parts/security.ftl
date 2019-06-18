<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = "admin"
        isAdmin = true
    >

<#else >
    <#assign
        name = "guest"
        isAdmin = false
    >

</#if>