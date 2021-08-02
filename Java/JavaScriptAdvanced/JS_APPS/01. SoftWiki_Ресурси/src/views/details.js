import { html } from '../../node_modules/lit-html/lit-html.js';
import { getArticleById, deleteArticle } from '../api/data.js';

const detailsTemplate = (article, onDelete) => html `
<section id="details-page" class="content details">
            <h1>${article.title}</h1>
            <div class="details-content">
                <strong>Published in category ${article.category}</strong>
                <p>${article.content}</p>

                <div class="buttons">
                ${article._ownerId != sessionStorage.getItem('userId')
             ? ''
            : html`<a href="/edit/${article._id}" class="btn edit">Edit</a>
            <a href="#" @click="${(event) => onDelete(event, article._id)}" class="btn delete">Delete</a>`}
                    <a href="/home" class="btn edit">Back</a>
                </div>
            </div>
        </section>`;

export async function detailsPage(ctx) {
    const id = ctx.params.id;
    const article = await getArticleById(id);
    ctx.render(detailsTemplate(article, onDelete));

    async function onDelete(event, id) {
        event.preventDefault();
        const confirmation = confirm('Are you sure you want to delete this article?');
        if (confirmation) {
            await deleteArticle(id);
            ctx.page.redirect('/home');
        }
    }
}