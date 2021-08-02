import { html } from '../../node_modules/lit-html/lit-html.js';
import { getListingById, deleteListing } from '../api/data.js';



const detailsTemplate = (listing, onDelete) => html `
<section id="listing-details">
    <h1>Details</h1>
    <div class="details-info">
        <img src="${listing.imageUrl}">
        <hr>
        <ul class="listing-props">
            <li><span>Brand:</span>${listing.brand}</li>
            <li><span>Model:</span>${listing.model}</li>
            <li><span>Year:</span>${listing.year}</li>
            <li><span>Price:</span>${listing.price}$</li>
        </ul>

        <p class="description-para">${listing.description}.</p>
${listing._ownerId != sessionStorage.getItem('userId')? '': 
html`<div class="listings-buttons">
<a class="button-list" href="/edit/${listing._id}">Edit</a>
<a @click="${(event)=>onDelete(event, listing._id)}" href="/listings" class="button-list">Delete</a>
</div>`} 
    </div>
</section>`;

export async function detailsPage(ctx) {
    const id = ctx.params.id;
    const listing = await getListingById(id);
    ctx.render(detailsTemplate(listing, onDelete));

    async function onDelete(event, id) {
        event.preventDefault();
        const confirmation = confirm('Are you sure you want to delete this listing ?');
        if (confirmation) {
            await deleteListing(id);
            ctx.page.redirect('/listings');
        }
    }
}