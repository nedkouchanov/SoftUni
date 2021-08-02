import { html } from '../../node_modules/lit-html/lit-html.js';
import { login } from '../api/data.js';

const loginTemplate = (onSubmit) => html `
    <section id="login">
    <article class="narrow">
        <header class="pad-med">
            <h1>Login</h1>
        </header>
        <form @submit="${onSubmit}" id="login-form" class="main-form pad-large">
            <div class="error">Error message.</div>
            <label>E-mail: <input type="text" name="email"></label>
            <label>Password: <input type="password" name="password"></label>
            <input class="action cta" type="submit" value="Sign In">
        </form>
        <footer class="pad-small">Don't have an account? <a href="#" class="invert">Sign up here</a>
        </footer>
    </article>
</section>`;

export function loginPage(ctx) {
    ctx.render(loginTemplate(onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        const form = new FormData(event.target);
        const email = form.get('email').trim();
        const password = form.get('password').trim();

        if (email == '' || password == '') {
            throw new Error('All fields are required !');
        }

        await login(email, password);
        ctx.setNavBar();
        ctx.page.redirect('/myTeams');
    }
}