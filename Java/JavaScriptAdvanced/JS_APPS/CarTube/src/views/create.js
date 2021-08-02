import { html } from '../../node_modules/lit-html/lit-html.js';
import { createListing } from '../api/data.js';


const createTemplate = (onSubmit) => html `
<section id="create-listing">
    <div class="container">
        <form @submit="${onSubmit}" id="create-form">
            <h1>Create Car Listing</h1>
            <p>Please fill in this form to create an listing.</p>
            <hr>

            <p>Car Brand</p>
            <input type="text" placeholder="Enter Car Brand" name="brand">

            <p>Car Model</p>
            <input type="text" placeholder="Enter Car Model" name="model">

            <p>Description</p>
            <input type="text" placeholder="Enter Description" name="description">

            <p>Car Year</p>
            <input type="number" placeholder="Enter Car Year" name="year">

            <p>Car Image</p>
            <input type="text" placeholder="Enter Car Image" name="imageUrl">

            <p>Car Price</p>
            <input type="number" placeholder="Enter Car Price" name="price">

            <hr>
            <input type="submit" class="registerbtn" value="Create Listing">
        </form>
    </div>
</section>`;

export function createPage(ctx) {
    ctx.render(createTemplate(onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        const form = new FormData(event.target);
        const brand = form.get('brand');
        const model = form.get('model');
        const description = form.get('description');
        const year = Number(form.get('year'));
        const imageUrl = form.get('imageUrl');
        const price = Number(form.get('price'));

        if (Number.isNaN(year) || Number.isNaN(price)) {
            return alert('Year and Price must be a postive numbers!')
        }
        if (!brand || !model || !year ||
            !price || !description || !imageUrl) {
            return alert('All fields are required !');
        }

        await createListing(brand, model, description, year, imageUrl, price);
        ctx.page.redirect('/listings');
    }

}