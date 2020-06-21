<#include "security.ftlh">
<div class="card-columns">
    <#list messages as message>
        <div class="card my-3" style="width: 18rem;">
            <#if message.filename??>
                <img src="/images/${message.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${message.text}</span><br/>
                <i>#${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                <div class="row">
                    <a class="col align-self-center" href="/user-messages/${message.author.id}">${message.authorName}</a>
                    <a class="col align-self-center" href="message/${message.id}/like">
                        <#if message.meLiked>
                        <i class="fas fa-heart"></i>
                            <#else>
                        <i class="far fa-heart"></i>
                        </#if>
                        ${message.likes}
                    </a>
                <#if message.author.id == currentUserId>
                    <a class="btn btn-primary" href="/user-messages/${message.author.id}?message=${message.id}">Edit</a>
                </#if>
                </div>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>