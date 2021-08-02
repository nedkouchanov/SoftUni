import { render } from '../node_modules/lit-html/lit-html.js';
import page from '../node_modules/page/page.mjs';
import { logout as logoutUser } from './api/data.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { cataloguePage } from './views/catalogue.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { homePage } from './views/home.js';
import { searchPage } from './views/search.js';

const main = document.getElementById('main-content');
document.getElementById('logoutBtn').addEventListener('click', logout);

page('/', decorateContext, homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, createPage);
page('/catalogue', decorateContext, cataloguePage);
page('/home', decorateContext, homePage);
page('/details/:id', decorateContext, detailsPage);
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
    const email = sessionStorage.getItem('email');
    if (email) {
        document.getElementById('user').style.display = '';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = '';
    }
}

async function logout() {
    await logoutUser();
    setNavBar();
    page.redirect('/');
}