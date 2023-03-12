<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/css/style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300;400;500;600;700&display=swap" rel="stylesheet" crossorigin="anonymous">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" crossorigin="anonymous"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" crossorigin="anonymous">
  <title>Инвентаризация</title>
</head>

<body>
  <div class="web-container">
    <aside>
      <div class="aside__top">
        <div class="aside__logo">
          <img src="/images/logo.png" alt="logo">
          <h2 class="text-muted">
            <span class="text-border"><span class="color-primary">TECh </span><span class="color-success">
                Inc.</span></span>
          </h2>
        </div>
        <div class="aside__close" id="close-btn">
          <span class="material-symbols-sharp">
            close
          </span>
        </div>
      </div>
    </aside>
    <main>
                                  <#if errorMessage??>
                                      <span style="color: red">${errorMessage}</span>
                                  </#if>
      <form action="/registration" method="post">
      <div class="login-window">
        <div class="login-title">
          <h1>Регистрация</h1>
          <br>
          <div class="login-input_window">
            <div class="login-put_data">
              <span>
                <h3>Имя</h3>
              </span>
              <div class="login-name">
                <input class="input-td2" required type="text" name="name">
              </div>
              <br>
              <span>
                <h3>Email</h3>
              </span>
              <div class="login-name">
                <input class="input-td2" required type="email" name="email">
              </div>
              <br>
              <span>
                <h3>Пароль</h3>
              </span>
              <div class="login-name">
                <input class="input-td2" required maxlength="8" type="password" name="password">
              </div>
            </div>
            <div class="login-reset">
              <img src="/images/admin.png" alt="reset">
              <input type="hidden" name="_csrf" value="${_csrf.token}">
              <button type="submit" class="login_reg-btn"><h2>Регистрация</h2></button>
            </div>
          </div>
        </div>
      </div>
      </form>
    </main>
  </div>
</body>

</html>