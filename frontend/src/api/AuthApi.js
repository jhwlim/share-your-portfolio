import axios from 'axios';
import AuthUtil from '@/util/AuthUtil.js';

const login = async ({username , password}) => {
    const url = '/login';
    const data = {
        username,
        password,
    };
    return await axios.post(url, data)
            .then(response => {
                const token = response.data.token;
                AuthUtil.saveToken(token);
                return token;
            });
};

const logout = async () => {
    const url = '/auth/logout';
    await axios.post(url);
    AuthUtil.removeToken();
};

const refreshToken = async () => {
    const url = '/auth/refresh';
    const token = await axios.get(url)
                            .then(response => response.data.token)
                            .catch(() => null);
    
    token !== null ? AuthUtil.saveToken(token) : AuthUtil.removeToken();
    return token;
};

export default {
    login,
    logout,
    refreshToken,
};