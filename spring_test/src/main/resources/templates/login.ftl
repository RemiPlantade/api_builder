<html>
<head>
<title>Admin login page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css">
</head>
<body>
	<section class="section">
		<div class="container">
			<div id="content">
				<div class="columns is-centered">
					<div class="column is-4">
						<div class="box">
							<h1 class="title is-5 has-text-centered">Please enter your
								login</h1>

							<form name="login" action="login" method="post">
								<div class="field">
									<label class="label">Mail</label>
									<div class="control">
										<input type="text" name="username" id="username"/><br />
									</div>
								</div>
								<div class="field">
									<label class="label">Password</label>
									<div class="control">
										<input type="password" name="password" id="password"/><br />
									</div>
								</div>
								<div class="field">
									<label class="label">
									<#if param ??>
									<#if param.error??> ${param.error}</#if>
									<#if param.logout??> ${param.logout}</#if>
									<#if param.error??> ${param.error}</#if>
									</#if>
									</label>
								</div>
								<div class="field is-grouped">
									<div class="control">
										<input class="button is-link" type="submit" value="Login" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>