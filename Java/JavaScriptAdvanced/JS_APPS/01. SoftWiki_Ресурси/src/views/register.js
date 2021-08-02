import { html } from '../../node_modules/lit-html/lit-html.js';
import { register } from '../api/data.js';

const registerTemplate = (onRegister) => html `
    <section id="register-page" class="content auth">
    <h1>Register</h1>

    <form @submit="${onRegister}" id="register" action="#" method="">
        <fieldset>
            <blockquote>Knowledge is not simply another commodity. On the contrary. Knowledge is never used up.
                It
                increases by diffusion and grows by dispersion.</blockquote>
            <p class="field email">
                <label for="register-email">Email:</label>
                <input type="email" id="register-email" name="email" placeholder="maria@email.com">
            </p>
            <p class="field password">
                <label for="register-pass">Password:</label>
                <input type="password" name="password" id="register-pass">
            </p>
            <p class="field password">
                <label for="register-rep-pass">Repeat password:</label>
                <input type="password" name="rep-pass" id="register-rep-pass">
            </p>
            <p class="field submit">
                <input class="btn submit" type="submit" value="Register">
            </p>
            <p class="field">
                <span>If you already have profile click <a href="/login">here</a></span>
            </p>
        </fieldset>
    </form>
</section>`;

export function registerPage(ctx) {
    ctx.render(registerTemplate(onRegister));

    async function onRegister(event) {
        event.preventDefault();
        const form = new FormData(event.target);
        const email = form.get('email').trim();
        const password = form.get('password').trim();
        const repeatPass = form.get('rep-pass').trim();

        if (!email || !password || !repeatPass) {
            return alert('All fields are required !');
        }

        if (password != repeatPass) {
            return alert('Passwords don\'t match !');
        }

        await register(email, password);
        ctx.setNavBar();
        ctx.page.redirect('/home');
    }
}