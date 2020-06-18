<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <#if !isCurrentUser>
        <#if isSubscriber>
        <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Unsubscribe</a>
        <#else >
        <a class="btn btn-info" href="/user/subscribe/${userChannel.id}">Subscribe</a>
        </#if>
    </#if>
    <h3>${userChannel.username}</h3>
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">Subscriptions</div>
                    <h3 class="card-text">
                        <a href="/user/subscriptions/${userChannel.id}">${subscriptionsCount}</a>
                    </h3>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card-body">
                <div class="card-title">Subscribers</div>
                <div class="card-text">
                    <a href="/user/subscribers/${userChannel.id}">${subscribersCount}</a>
                </div>
            </div>
        </div>
    </div>
    <#if isCurrentUser>
        <#include "parts/messageEdit.ftlh"/>
    </#if>
    <#include "parts/messageList.ftlh"/>
</@c.page>