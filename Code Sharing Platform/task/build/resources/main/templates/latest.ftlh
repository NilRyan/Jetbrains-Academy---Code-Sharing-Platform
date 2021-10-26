<html>
    <head>
        <title>Latest</title>
    </head>
    <body>
        <#list latestList?reverse as codes>
            <span id="load_date">${codes.getDate()}</span>
            <pre id="code_snippet">${codes.getCode()}</pre>
        </#list>
    </body>
</html>