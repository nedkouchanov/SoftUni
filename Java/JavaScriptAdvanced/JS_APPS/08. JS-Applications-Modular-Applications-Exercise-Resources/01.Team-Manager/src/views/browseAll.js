import { html } from '../../node_modules/lit-html/lit-html.js';
import { getAllTeams } from '../api/data.js';

const browseTeamsTemplate = (teams) => html `
<section id="browse">

<article class="pad-med">
    <h1>Team Browser</h1>
</article>
${teams.map(browseTemplate)}
<article class="layout narrow">
    <div class="pad-small"><a href="/create" class="action cta">Create Team</a></div>
</article>`;

const browseTemplate = (team) => html `
<article class="layout">
                    <img src=${team.logoUrl} class="team-logo left-col">
                    <div class="tm-preview">
                        <h2>${team.name}</h2>
                        <p>${team.description}</p>
                        <span class="details">5000 Members</span>
                        <div><a href="/details/${team._id}" class="action">See details</a></div>
                    </div>
                </article>`;

export async function browseAllPage(ctx) {
    const teams = await getAllTeams();
    ctx.render(browseTeamsTemplate(teams));
}