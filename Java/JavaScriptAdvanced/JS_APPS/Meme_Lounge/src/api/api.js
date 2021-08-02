export const settings = {
    host: ''
};

async function request(url, options) {
    try {
        const response = await fetch(url, options);

        if (response.ok == false) {
            const error = await response.json();
            throw new Error(error.message);
        }

        try {
            const data = await response.json();
            return data;
        } catch (error) {
            return response;
        }

    } catch (error) {
        alert(error.message);
        throw error;
    }
}

function getOptions(method = 'get', body) {
    const options = {
        method,
        headers: {}
    };

    const token = sessionStorage.getItem('authToken');
    if (token != null) {
        options.headers['X-Authorization'] = token;
    }

    if (body) {
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body);
    }

    return options;
}

async function get(url) {
    return await request(url, getOptions());
}

async function post(url, data) {
    return await request(url, getOptions('post', data));
}

async function put(url, data) {
    return await request(url, getOptions('put', data));
}

async function del(url) {
    return await request(url, getOptions('delete'));
}

async function login(email, password) {
    const result = await post(settings.host + '/users/login', { email, password });

    sessionStorage.setItem('username', result.username);
    sessionStorage.setItem('email', result.email);
    sessionStorage.setItem('userId', result._id);
    sessionStorage.setItem('authToken', result.accessToken);
    sessionStorage.setItem('gender', result.gender);
    
    return result;
}

async function register(username, email, password, gender) {
    const result = await post(settings.host + '/users/register', { username, email, password, gender });

    sessionStorage.setItem('username', result.username);
    sessionStorage.setItem('email', result.email);
    sessionStorage.setItem('userId', result._id);
    sessionStorage.setItem('authToken', result.accessToken);
    sessionStorage.setItem('gender', result.gender);
    
    return result;
}

async function logout() {
    const result = await get(settings.host + '/users/logout');

    sessionStorage.removeItem('username');
    sessionStorage.removeItem('email');
    sessionStorage.removeItem('userId');
    sessionStorage.removeItem('authToken');
    sessionStorage.removeItem('gender');
    
    return result;
}

export {
    get,
    post,
    put,
    del,
    login,
    register,
    logout
};