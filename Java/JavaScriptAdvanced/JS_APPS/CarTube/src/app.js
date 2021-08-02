import { render } from '../node_modules/lit-html/lit-html.js';
import page from '../node_modules/page/page.mjs';
import { logout as logoutUser } from './api/data.js';

import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { homePage } from './views/home.js';
import { listingsPage } from './views/listings.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { searchPage } from './views/search.js';
import { myProfilePage } from './views/userlistings.js';
const main = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click', logout);


page('/', decorateContext, homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, createPage);
page('/listings', decorateContext, listingsPage);
page('/details/:id', decorateContext, detailsPage);
page('/userlistings', decorateContext, myProfilePage);
page('/edit/:id', decorateContext, editPage);
page('/search', decorateContext, searchPage);


setNavBar();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, main);
    ctx.setNavBar = setNavBar;
    next();
}

function setNavBar() {
    const username = sessionStorage.getItem('username');
    if (username) {
        document.getElementById('profile').style.display = '';
        document.getElementById('guest').style.display = 'none';
        document.getElementById('welcome-valid').innerHTML = `Welcome, ${username}`;
    } else {
        document.getElementById('profile').style.display = 'none';
        document.getElementById('guest').style.display = '';
    }
}

async function logout() {
    await logoutUser();
    setNavBar();
    page.redirect('/');
}