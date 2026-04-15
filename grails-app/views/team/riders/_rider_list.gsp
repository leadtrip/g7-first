<ul>
    <g:each in="${bean.riders}" var="rider">
        <li><g:link uri="/rider/show/${rider.id}">${rider.forename} ${rider.surname}</g:link></li>
    </g:each>
</ul>