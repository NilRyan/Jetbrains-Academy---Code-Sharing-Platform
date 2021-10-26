<html>
    <head>
        <title>${codeWithId.getTitle()}</title>
    </head>
    <body>
        <span id="load_date">${codeWithId.getDate()}</span>
        <pre id="code_snippet"><code>${codeWithId.getCode()}</code></pre>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    </body>

</html>