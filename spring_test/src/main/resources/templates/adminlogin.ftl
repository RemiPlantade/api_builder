<html>
<head>
  <title>Admin login page</title>
</head>
<body>
  <h1> Please enter your login </h1>
  <div id="content">
  <fieldset>
    <legend>Login</legend>
    <form name="login" action="login" method="post">
      Mail : <input type="text" name="mail" /><br/>
      Password: <input type="password" name="password" /><br/>
      <input type="submit" value="Login" />
    </form>
    <#if message_erreur??>
    ${message_erreur}
    </#if>
  </fieldset>
  <br/>
</div>
</body>
</html>