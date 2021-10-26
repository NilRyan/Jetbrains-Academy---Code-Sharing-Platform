<html>
    <head>
        <title>Code</title>
        <link rel="stylesheet"
              href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <span id="time_restriction">${codeWithId.getTime()} seconds left</span>
        <span id="views_restriction">${codeWithId.getViews()} views left</span>
        <span id="load_date">${codeWithId.getDate()}</span>
        <pre id="code_snippet"><code>${codeWithId.getCode()}</code></pre>

    </body>

</html>