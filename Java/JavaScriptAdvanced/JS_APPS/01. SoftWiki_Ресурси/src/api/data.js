import * as api from './api.js';

const host = 'http://localhost:3030';
api.settings.host = host;

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function createArticle(title, category, content) {
    return await api.post(host + '/data/wiki', { title, category, content });
}

export async function getAllArticles() {
    return await api.get(host + '/data/wiki?sortBy=_createdOn%20desc');
}

export async function getArticleById(id) {
    return await api.get(host + '/data/wiki/' + id);
}

export async function deleteArticle(id) {
    return await api.del(host + '/data/wiki/' + id);
}

export async function editArticle(id, title, category, content) {
    return await api.put(host + '/data/wiki/' + id, { title, category, content });
}

export async function getRecentArticles() {
    return await api.get(host + `/data/wiki?sortBy=_createdOn%20desc&distinct=category`);
}
export async function search(query) {
    return await api.get(host + `/data/wiki?where=title%20LIKE%20%22${query}%22`);
}