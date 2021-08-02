import * as api from './api.js';

const host = 'http://localhost:3030';
api.settings.host = host;

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function createTeam(name, logoUrl, description) {
    return await api.post(host + '/data/teams', { name, logoUrl, description });
}

export async function getAllTeams() {
    return await api.get(host + '/data/teams');
}

export async function getTeamById(id) {
    return await api.get(host + '/data/teams/' + id);
}

export async function deleteMeme(id) {
    return await api.del(host + '/data/memes/' + id);
}

export async function editTeam(id, name, logoUrl, description) {
    return await api.put(host + '/data/teams/' + id, { name, logoUrl, description });
}

export async function getUserTeams(userId) {
    return await api.get(host + `/data/members?where=_ownerId%3D%22${userId}%22%20AND%20status%3D%22member%22&load=team%3DteamId%3Ateams`);
}