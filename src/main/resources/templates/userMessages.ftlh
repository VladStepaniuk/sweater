<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <#if isCurrentUser>
        <#include "parts/messageEdit.ftlh"/>
    </#if>
    <#include "parts/messageList.ftlh"/>
</@c.page>