import { html } from '../../node_modules/lit-html/lit-html.js';
import { createTeam } from '../api/data.js';

const createTemplate = (onSubmit) => html `
    <section id="create">
    <article class="narrow">
        <header class="pad-med">
            <h1>New Team</h1>
        </header>
        <form @submit="${onSubmit}" id="create-form" class="main-form pad-large">
            <div class="error">Error message.</div>
            <label>Team name: <input type="text" name="name"></label>
            <label>Logo URL: <input type="text" name="logoUrl"></label>
            <label>Description: <textarea name="description"></textarea></label>
            <input class="action cta" type="submit" value="Create Team">
        </form>
    </article>
</section>`;

export function createPage(ctx) {
    ctx.render(createTemplate(onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        const form = new FormData(event.target);
        const name = form.get('name');
        const logoUrl = form.get('logoUrl');
        const description = form.get('description');


        if (!name || !description || !logoUrl) {
            throw new Error('All fields are required !');
        }

        await createTeam(name, description, logoUrl);
        ctx.page.redirect('/details');

    }
}