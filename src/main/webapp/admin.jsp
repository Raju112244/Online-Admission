<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin sign in | Raj University</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;600;700&family=Space+Grotesk:wght@500;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/app.css">
  <link rel="stylesheet" href="assets/account.css">
</head>
<body class="login-page admin-login-page">
  <a class="login-brand brand" href="index.jsp"><span class="brand-mark">R</span><span>raj<span class="brand-muted">university</span></span></a>
  <main class="login-layout">
    <section class="login-intro">
      <span class="eyebrow">UNIVERSITY OPERATIONS</span>
      <h1>Lead the work<br><span>behind the learning.</span></h1>
      <p>Access admissions, student records, course updates, and campus operations from the administration portal.</p>
      <div class="login-points"><span>◈ <b>Student records</b></span><span>▣ <b>Course management</b></span><span>◌ <b>Campus operations</b></span></div>
    </section>
    <section class="login-card">
      <div class="card-top"><span class="eyebrow">ADMIN PORTAL</span><span class="secure">◉ Secure login</span></div>
      <h2>Welcome back</h2>
      <p class="card-copy">Use your administrator credentials to continue.</p>
      <% if (request.getAttribute("error") != null) { %><div class="form-error"><%= request.getAttribute("error") %></div><% } %>
      <form action="admin1" method="get">
        <label for="mailid">Administrator email</label>
        <input id="mailid" type="email" name="mailid" placeholder="admin@rajuniversity.edu" autocomplete="username" required>
        <label for="password">Password</label>
        <input id="password" type="password" name="password" placeholder="Enter your password" autocomplete="current-password" required>
        <button class="primary-button full-button" type="submit">Sign in to admin portal <span>→</span></button>
      </form>
      <a class="role-link" href="index.jsp">← Return to university website</a>
      <small class="login-legal">Administrator access is restricted to authorized Raj University staff.</small>
    </section>
  </main>
  <a class="back-home" href="index.jsp">← Back to home</a>
</body>
</html>
