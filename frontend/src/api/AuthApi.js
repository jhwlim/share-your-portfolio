import axios from 'axios';
import AuthUtil from '@/util/AuthUtil.js';

const api = axios.create({
    baseURL: '/api',
    headers: {
        'Content-Type': 'application/json',
    }
});

const login = ({username , password}) => {
    const url = '/login';
    const data = {
        username,
        password,
    };
    return api.post(url, data);
};

const logout = () => {
    const url = '/auth/logout';    
    const token = AuthUtil.getToken();
    const tokenHeader = process.env.VUE_APP_JWT_HEADER;

    return api.post(url, null, {
        headers: {
            [tokenHeader]: token,
        }
    });
};

export default {
    login,
    logout,
}