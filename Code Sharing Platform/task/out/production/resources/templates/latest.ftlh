<html>
    <head>
        <title>Latest</title>
    </head>
    <body>
        <#list latestList?reverse as codes>
            <span id="load_date">${codes.getDate()}</span>
            <pre id="code_snippet"><code>${codes.getCode()}</code></pre>
        </#list>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    </body>
</html>