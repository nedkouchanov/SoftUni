import * as api from './api.js';

const host = 'http://localhost:3030';
api.settings.host = host;

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function createMeme(title, description, imageUrl) {
    return await api.post(host + '/data/memes', {title, description, imageUrl});
}

export async function getAllMemes() {
    return await api.get(host + '/data/memes?sortBy=_createdOn%20desc');
}

export async function getMemeById(id) {
    return await api.get(host + '/data/memes/' + id);
}

export async function deleteMeme(id) {
    return await api.del(host + '/data/memes/' + id);
}

export async function editMeme(id, title, description, imageUrl) {
    return await api.put(host + '/data/memes/' + id, {title, description, imageUrl});
}

export async function getUserMemes(userId) {
    return await api.get(host + `/data/memes?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
}