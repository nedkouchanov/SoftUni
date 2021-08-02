import { html } from '../../node_modules/lit-html/lit-html.js';
import { getTeamById, editTeam } from '../api/data.js';

const editTemplate = (team, onSubmit) => html `
    <section id="edit">
    <article class="narrow">
        <header class="pad-med">
            <h1>Edit Team</h1>
        </header>
        <form @submit=${onSubmit} id="edit-form" class="main-form pad-large">
            <div class="error">Error message.</div>
            <label>Team name: ${team.name}<input type="text" name="name"></label>
            <label>Logo URL: ${team.logoUrl}<input type="text" name="logoUrl"></label>
            <label>Description:${team.description} <textarea name="description"></textarea></label>
            <input class="action cta" type="submit" value="Save Changes">
        </form>
    </article>
</section>`;

export async function editPage(ctx) {
    const id = ctx.params.id;
    const team = await getTeamById(id);
    ctx.render(editTemplate(team, onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        const form = new FormData(event.target);
        const name = form.get('name');
        const description = form.get('description');
        const logoUrl = form.get('logoUrl');

        if (!name || !description || !logoUrl) {
            throw new Error('All fields are required !');
        }

        await editTeam(id, name, description, logoUrl);
        ctx.page.redirect('/details/' + id);
    }

}