import { render } from '../node_modules/lit-html/lit-html.js';
import page from '../node_modules/page/page.mjs';


import { registerPage } from './views/register.js';
import { loginPage } from './views/login.js';
import { logout as logoutUser } from './api/data.js';
import { homePage } from './views/home.js';
//import { detailsPage } from './views/details.js';
import { createPage } from './views/create.js';
import { browseAllPage } from './views/browseAll.js';

import { editPage } from './views/edit.js';
//import { myProfilePage } from './views/myProfile.js';
const main = document.querySelector('main');
document.getElementById('user-logout').addEventListener('click', logout);

page('/edit/:id', decorateContext, editPage);
//page('/myProfile', decorateContext, myProfilePage);
page('/', decorateContext, homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
//page('/details/:id', decorateContext, detailsPage);
page('/create', decorateContext, createPage);
page('/browseAll', decorateContext, browseAllPage);

setNavBar();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, main);
    ctx.setNavBar = setNavBar;
    next();
}

function setNavBar() {
    const email = sessionStorage.getItem('email');
    if (email) {
        document.getElementById('user-myt').style.display = '';
        document.getElementById('user-logout').style.display = '';
        document.getElementById('guest-log').style.display = 'none';
        document.getElementById('guest-reg').style.display = 'node';

    } else {
        document.getElementById('guest-log').style.display = '';
        document.getElementById('guest-reg').style.display = '';
        document.getElementById('user-myt').style.display = 'none';
        document.getElementById('user-logout').style.display = 'none';
    }
}

async function logout() {
    await logoutUser();
    setNavBar();
    page.redirect('/home');
}