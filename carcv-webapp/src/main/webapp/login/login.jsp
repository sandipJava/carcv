<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="SHORTCUT ICON"
	href="http://upload.wikimedia.org/wikipedia/commons/f/f0/Car_with_Driver-Silhouette.svg">
<link rel="icon"
	href="http://upload.wikimedia.org/wikipedia/commons/f/f0/Car_with_Driver-Silhouette.svg"
	type="image/ico">
<title>CarCV - Login</title>
<link rel="stylesheet" type="text/css" href="/resources/mystyle.css">
</head>

<body>
	<div id="header">
		<a href="/" target="_top"><img src="/resources/opencv-logo.png"
			width="150"
			style="border: 0; margin-top: 5px; margin-bottom: 5px; text-align: left; position: relative; top: -10px"
			alt="OpenCV" /></a>
		<p
			style="position: absolute; right: 8%; top: 2%; font-size: 11pt; word-spacing: .5em;">
			<b> <a href="/" target="_top" style="text-decoration: none">Home</a>
				<a href="/" target="_top" style="text-decoration: none">Features</a>
				<a href="/" target="_top" style="text-decoration: none">Contribute</a>
				<a href="/" target="_top"
				style="text-decoration: none; word-spacing: 0em;">Contact us</a>
			</b>
		</p>
	</div>

	<div id="center-login">
		<form method="post" target="_top" action="j_security_check">
			<p>
				Username:<input type="text" name="j_username">
			</p>
			<p>
				Password: <input type="password" name="j_password">
			</p>
			<p>
				<input type="checkbox" name="stay-signed" value="stay-signed">Keep
				me logged in
			</p>
			<input type="submit" style="position: relative; left: 25%;"
				value="Login">
		</form>
	</div>

	<div id="footer"></div>

</body>
</html>