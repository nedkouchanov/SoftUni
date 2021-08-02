import { html } from '../../node_modules/lit-html/lit-html.js';
import { register } from '../api/data.js';

const registerTemplate = (onRegister, flag) => html `
    <section id="register">
    <article class="narrow">
        <header class="pad-med">
            <h1>Register</h1>
        </header>
        <form @submit="${onRegister}" id="register-form" class="main-form pad-large">
            ${flag ? html`<div class="error">Error message.</div>`: ''}
            <label>E-mail: <input type="text" name="email"></label>
            <label>Username: <input type="text" name="username"></label>
            <label>Password: <input type="password" name="password"></label>
            <label>Repeat: <input type="password" name="repass"></label>
            <input class="action cta" type="submit" value="Create Account">
        </form>
        <footer class="pad-small">Already have an account? <a href="/login" class="invert">Sign in here</a>
        </footer>
    </article>
</section>`;

export function registerPage(ctx) {
    ctx.render(registerTemplate(onRegister));

    async function onRegister(event) {
        event.preventDefault();
        let flag = false;
        const form = new FormData(event.target);
        const email = form.get('email').trim();
        const username = form.get('username').trim();
        const password = form.get('password').trim();
        const repass = form.get('repass').trim();

        if (!username || !email || !password || !repass) {
            flag = true;
        }
        if (username.length < 3 || password.length < 3) {
            flag = true;
        }

        if (password != repass) {
            flag = true;
        }

        await register(username, email, password);
        ctx.setNavBar();
        ctx.page.redirect('/myTeams');
    }
}