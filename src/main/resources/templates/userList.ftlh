<#import "parts/common.ftlh" as c>

<@c.page>
    List of users:
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
    <#list users as user>
        <tbody>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">Edit</a></td>
        </tr>
        </tbody>
    </#list>
    </table>
</@c.page>