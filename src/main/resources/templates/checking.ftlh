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
          <div class="aside__sidebar">
            <a href="/">
                      <span class="material-symbols-sharp">
                        grid_view
                      </span>
                      <h3>Главная страница</h3>
                    </a>
                    <#if user.isWorker()==false>
                    <a href="/add">
                      <span class="material-symbols-sharp">
                        add_circle
                      </span>
                      <h3>Добавление места</h3>
                    </a>
                    <a href="/admin">
                    <span class="material-symbols-sharp">
                    admin_panel_settings
                    </span>
                                        </#if>
                                        <#if user.isAdmin()>
                    <h3>Администрирование</h3>
                    </a>
                    </#if>
                    <a href="/about">
                      <span class="material-symbols-sharp">
                        info
                      </span>
                      <h3>О сайте</h3>
                    </a>
                                    <a>
                                      <span class="material-symbols-sharp">
                                        logout
                                      </span>
                                    <form action="/logout" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                        <h3><input type="submit" value="Выйти"/></h3>
                                    </form>
                                    </a>
          </div>
        </aside>
    <main>
                <div class="web__head">
                  <div class="header__title"><h1>Список мест для инвертаризации</h1></div>
                  <div class="right-side">
                    <div class="top">
                      <button id="menu-btn">
                        <span class="material-symbols-sharp">
                          menu
                        </span>
                      </button>
                      <div class="profile">
                        <div class="info">
                          <p>${user.name}</p>
                          <small class="text-muted">${user.stringRole()}</small>
                        </div>
                        <div class="profile-photo">
                          <img src="/images/${user.stringRole()}.png" alt="photo">
                        </div>
                      </div>
                    </div>
                </div>
                </div>
          <#if user.isWorker()><form action="/place/accept/${place.id}" method="post"></#if>
          <div class="main__checklist">
            <h2>Регламентированный&nbsp;список&nbsp;для&nbsp;инвентаризации </h2>
            <table>
              <thead>
                <th>Характеристика</th>
                <th>Серийный номер</th>
                <th>По учету</th>
                <th>По факту</th>
                <th>Статус</th>
              </thead>
              <tbody>
              <#list place.equipments as equipment>
                <tr>
                  <td>${equipment.characteristic}</td>
                  <td>${equipment.id}</td>
                  <td><input type="checkbox" name="accounting_${equipment?counter}" <#if equipment.accounting>checked</#if> <#if user.isWorker()==false>disabled</#if> class="input-check"></td>
                  <td><input type="checkbox" name="fact_${equipment?counter}" <#if equipment.fact>checked</#if> <#if user.isWorker()==false>disabled</#if> class="input-check"></td>
                  <td><input name="status_${equipment?counter}" <#if equipment.status??>value="${equipment.status}"</#if> <#if user.isWorker()==false>disabled</#if> type="text" class="input-td"></td>
                </tr>
              </#list>
              </tbody>
            </table>
          </div>
          <#if user.isWorker()>
                          <div class="checking-buttons">
                              <input type="hidden" name="_csrf" value="${_csrf.token}">
                              <button class="checking-btn"><h3>Принять</h3></button>
                          </div>
                      </form>
          <#else>

          <div class="checking-buttons">
            <form action="/place/invert/${place.id}" method="post">
                <#if place.checked>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="checking-btn"><h3>Провести инвертаризацию</h3></button>
                <#else>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="checking-btn"><h3>Принять инвертаризацию</h3></button>
                </#if>
            </form>
            <form action="/place/delete/${place.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="checking-btn"><h3>Удалить</h3></button>
            </form>
          </div>
          </#if>
        </main>
      </div>
    </body>
    </html>