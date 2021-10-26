<html>
    <head>
        <title>Code</title>
        <link rel="stylesheet"
              href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <#if (codeResponse.getTime() > 0)>
            <span id="time_restriction">${codeResponse.getTime()} seconds left</span>
        </#if>

        <#if (codeResponse.getViews() >= 0 )>
            <span id="views_restriction">${codeResponse.getViews()} views left</span>
        </#if>

        <span id="load_date">${codeResponse.getDate()}</span>
        <pre id="code_snippet"><code>${codeResponse.getCode()}</code></pre>

    </body>

</html>